#!/bin/bash

echo "Patch dosyaları uygulanıyor..."

patch -p1 -d ../../../../device/generic/car/ < ./01_AndroidProducts.patch
patch -p1 -d ../../../../system/core/ < ./02_mcdevice_init.patch
#patch -p1 -d ../../../../frameworks/base/data/etc/car/ < ./03_framework.patch
patch -p1 -d ../../../../frameworks/base/ < ./03_framework.patch
patch -p1 -d ../../../../device/generic/car/ < ./04_gsi_car_base.patch
patch -p1 -d ../../../../device/generic/car/ < 05_preinstalled-packages-product-car-emulato.patch
#patch -p1 -d ../../../../packages/apps/Car/SystemUI/res/layout/ < 06_SystemUI_1.patch
patch -p1 -d ../../../../packages/apps/Car/SystemUI/ < 06_SystemUI_1.patch
#patch -p1 -d ../../../../packages/apps/Car/SystemUI/res/values/ < 07_SystemUI_2.patch
patch -p1 -d ../../../../packages/apps/Car/SystemUI/ < 07_SystemUI_2.patch

echo "Patch dosyaları başarıyla uygulandı."

echo "Dosyalar kopyalanıyor..."
cp com.android.car.mccarlauncher.xml ../../../../frameworks/base/data/etc/car/
cp mc_car_x86.mk ../../../../device/generic/car/

echo "İşlem tamamlandı."

