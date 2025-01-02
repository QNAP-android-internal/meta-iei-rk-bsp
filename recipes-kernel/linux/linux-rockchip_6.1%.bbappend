# Copyright (C) 2021, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRCREV = "${AUTOREV}"

SRC_URI = " \
    git://github.com/QNAP-android-internal/kernel-rk.git;protocol=https;branch=iei-android-14.0.0_rkr5; \
"
SRC_URI += "file://0001-arm64-dts-rk3588-b675-add-PARTUUID-in-bootargs.patch"
