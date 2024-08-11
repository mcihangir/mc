#!/bin/bash

echo "Patch dosyaları geri alınıyor..."

patch -p1 -R -d ../../../../device/generic/car/ < ./01_AndroidProducts.patch
patch -p1 -R -d ../../../../system/core/ < ./02_mcdevice_init.patch
patch -p1 -R -d ../../../../frameworks/base/ < ./03_framework.patch
patch -p1 -R -d ../../../../device/generic/car/ < ./04_gsi_car_base.patch
patch -p1 -R -d ../../../../device/generic/car/ < 05_preinstalled-packages-product-car-emulato.patch
patch -p1 -R -d ../../../../packages/apps/Car/SystemUI/ < 06_SystemUI_1.patch
patch -p1 -R -d ../../../../packages/apps/Car/SystemUI/ < 07_SystemUI_2.patch


echo "Patch dosyaları başarıyla geri alındı."

echo "Copyalanan dosyalar siliniyor..."
rm -rf ../../../../frameworks/base/data/etc/car/com.android.car.mccarlauncher.xml
rm -rf ../../../../device/generic/car/mc_car_x86.mk

echo "İşlem tamamlandı."

