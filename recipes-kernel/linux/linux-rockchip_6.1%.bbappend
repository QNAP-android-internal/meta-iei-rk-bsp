# Copyright (C) 2021, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRCREV = "d1ed625fa2c42506379d89fa72e328b4e042dae5"

SRC_URI = " \
    git://github.com/QNAP-android-internal/kernel-rk.git;protocol=https;branch=iei-android-14.0.0_rkr5; \
    file://logo.bmp \
    file://logo_kernel.bmp \
"
SRC_URI += "file://0001-arm64-dts-rk3588-b675-add-PARTUUID-in-bootargs.patch"

do_preprocess_replacement() {
    # copy logo images to kernel source directory
    cp ${WORKDIR}/logo.bmp ${S}/logo.bmp
    cp ${WORKDIR}/logo_kernel.bmp ${S}/logo_kernel.bmp
}

addtask do_preprocess_replacement after do_patch before do_compile
