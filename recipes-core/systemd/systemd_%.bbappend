# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:remove = "file://0001-basic-Allow-unknown-filesystems.patch"
SRC_URI:append = " \
    file://0001-meson-do-not-fail-build-with-newer-kernel-headers.patch \
"

