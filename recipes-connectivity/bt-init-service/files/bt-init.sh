#!/bin/bash

connmanctl enable bluetooth

sleep 2

bt_firmware_path=/lib/firmware/BCM4362A2.hcd
brcm_patchram_plus1 --enable_hci --no2bytes --use_baudrate_for_download --tosleep 200000 --baudrate 3000000 --patchram $bt_firmware_path /dev/ttyS9 &

sleep 2

hciconfig hci0 up

