#!/bin/bash

# Bash script dosyası: cleanup.sh

# Hedef dizinleri ve dosyaları sil
echo "Silme işlemi başlatılıyor..."

rm -r ../../../../out/target/product/generic_car_x86/obj/ETC/
rm -r ../../../../out/target/product/generic_car_x86/system/etc/permissions/
rm -r ../../../../out/soong/.intermediates/frameworks/base/data/etc/
rm -r ../../../../out/target/common/obj/APPS/mcandroid*

echo "Silme işlemi tamamlandı."

