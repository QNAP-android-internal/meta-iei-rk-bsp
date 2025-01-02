# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SRCREV = "${AUTOREV}"
SRCREV_rkbin = "c41b714cacd249e3ef69b2bbe774da5095eefd72"
SRC_URI = " \
	git://github.com/QNAP-android-internal/uboot-rk.git;protocol=https;branch=iei-android-14.0.0_rkr5; \
	git://github.com/JeffyCN/mirrors.git;protocol=https;branch=rkbin;name=rkbin;destsuffix=rkbin; \
"
