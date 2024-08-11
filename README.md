Tasks Accomplished:
	Custom AAOSP Image: mc_car_x86
	Custom Launcher: MCCarLauncher
	Native Application: mcnativeapp
	Android Application: mcandroidautoapp

Follow the steps below: 

	1. Preparation & Installation "MC Device" to AOSP 12
	2. Confirmation the custom image and custom Launcher
	3. Confirmation the VHAL enabled on the image
	4. Confirmation "mcnativeapp" native application
	5. Confirmation "mcandroidautoapp" Android Application
======================================================================

1. Preparation & Installation "MC Device" to AOSP 12
1.1 Download AOSP 12 to Development PC
	Development PC: Ubuntu 20.04 with 450GB Disk and 28GB RAM

	To install required packages on the development PC
	$ sudo apt-get install git-core gnupg flex bison build-essential zip curl zlib1g-dev libc6-dev-i386 x11proto-core-dev libx11-dev lib32z1-dev libgl1-mesa-dev libxml2-utils xsltproc unzip fontconfig

	Download AOSP 12 to the development PC
	$ sudo apt-get update
	$ sudo apt-get install repo

	$ mkdir ~/android-12.0.0_r2
	$ cd ~/android-12.0.0_r2
	$ repo init -u https://android.googlesource.com/platform/manifest -b android-12.0.0_r2
	$ repo sync 

1.2 Install the Custom Packages developed for the Task on the default AOSP 12
	$ cd {aosp_root_folder} 
	$ mkdir vendor
	$ git clone https://github.com/mcihangir/mc.git   
	OR 
	$ cp [path]/mc vendor/

	Apply patches and copy the necessary files to the default android-12.0.0_r2
	$ cd vendor/mc/ttask/patches
	$ ./00_install_mcdevice.sh

1.3 Build AOSP12 Custom Image
	$ source build/envsetup.sh
	$ lunch mc_car_x86-userdebug
	$ make -j4
	$ m emu_img_zip -j4

======================================================================

2. Confirmation the custom image and custom Launcher
	Run the emulator from the same terminal after finishing compiling the AOPS
	$ emulator &
2.1. Confirming the custom image
	Go to the settings
	![image](https://github.com/user-attachments/assets/6a4a3145-dfdf-4306-a63a-12bb940d797d)

	The image name should be"mc_car_x86"
![image](https://github.com/user-attachments/assets/574bc3aa-d833-42b7-9a25-674dd7e4328e)

2.2. Confirming the custom Launcher

![image](https://github.com/user-attachments/assets/b9e980d0-150b-41bf-a47a-050fd5293275)

======================================================================

3. Confirmation the VHAL enabled on the image
	Connect to the shell of the Android running on the emulator by using the following command from the same terminal
	$ adb shell
	Verify that the VHAL service is started by checking the logcat output:
	$ logcat | grep VehicleHal
08-10 12:09:34.781   393   393 I automotive.vehicle@2.0-impl: VehicleHalManager::init
	Checking the Status of VHAL Service
	$ ps -ef | grep android.hardware.automotive.vehicle
vehicle_network 393    1 1 12:09:33 ?     00:00:05 android.hardware.automotive.vehicle@2.0-service

======================================================================

4. Confirmation "mcnativeapp" native application

4.1 Confirming "mcnativeapp" , "mcnativeapp.rc", and "mcdevice.rc" files are installed to the target image
	$ ls /system/bin/mcnativeapp
	/system/bin/mcnativeapp

	$ ls /system/etc/init/mc*
	/system/etc/init/mcnativeapp.rc

4.2 Confirming "init.mcdevice.rc" init script run at the boot time
	$ dmesg | grep mcdevice
[    6.554729] init: Added '/system/etc/init/init.mcdevice.rc' to import list
[    6.584376] init: Parsing file /system/etc/init/init.mcdevice.rc...
[    6.706547] init: Parsing file /system/etc/init/init.mcdevice.rc...
[   17.143814] init: processing action (boot) from (/system/etc/init/init.mcdevice.rc:9)
[   17.147745] mcdevice: on boot
[   17.201237] init: processing action (boot) from (/system/etc/init/init.mcdevice.rc:9)
[   17.207022] mcdevice: on boot
[  213.019619] init: processing action (sys.boot_completed=1) from (/system/etc/init/init.mcdevice.rc:6)
[  213.033760] mcdevice: on property:sys.boot_completed=1
[  213.142150] init: processing action (sys.boot_completed=1) from (/system/etc/init/init.mcdevice.rc:6)
[  213.154886] mcdevice: on property:sys.boot_completed=1

4.3 Confirming the custom design "mcnativeapp" running on the image automatically after booting the image
	$ ps | grep mcnativeapp
	Checking logs of "mcnativeapp" 
	$ logcat | grep mcnativeapp
08-10 12:09:45.564   482   482 D [MCDEV v1.0]: mcnativeapp: 0
08-10 12:09:55.565   482   482 D [MCDEV v1.0]: mcnativeapp: 1
08-10 12:10:05.567   482   482 D [MCDEV v1.0]: mcnativeapp: 2
08-10 12:10:15.568   482   482 D [MCDEV v1.0]: mcnativeapp: 3

======================================================================

5. Confirmation "mcandroidautoapp" Android Application
	Open "Applications" in MCCarLauncher
	Click "MCAutov2"
	
![image](https://github.com/user-attachments/assets/2fe76191-6561-4c9f-b2c4-954aa9a9ea1a)
![image](https://github.com/user-attachments/assets/aa90794b-d0fa-4652-8478-e61852273266)

