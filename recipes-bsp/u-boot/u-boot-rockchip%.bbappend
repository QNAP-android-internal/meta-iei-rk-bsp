# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SRCREV = "d8f5930e7ca9a055e3da1b396a4e1e060357c9eb"
SRCREV_rkbin = "c41b714cacd249e3ef69b2bbe774da5095eefd72"
SRC_URI = " \
	git://github.com/QNAP-android-internal/uboot-rk.git;protocol=https;branch=iei-android-14.0.0_rkr5; \
	git://github.com/JeffyCN/mirrors.git;protocol=https;branch=rkbin;name=rkbin;destsuffix=rkbin; \
"

SRCREV:rockchip-rk3576-evb = "${AUTOREV}"
SRCREV_rkbin:rockchip-rk3576-evb = "${AUTOREV}"
SRC_URI:rockchip-rk3576-evb = " \
	git://10.20.70.37/sw3_android_rk3588_gms_group/rk/u-boot.git;protocol=ssh;branch=iei-android-15.0.0_rkr3; \
	git://10.20.70.37/sw3_android_rk3588_gms_group/rk/rkbin.git;protocol=ssh;branch=iei-android-15.0.0_rkr3;name=rkbin;destsuffix=rkbin; \
"
