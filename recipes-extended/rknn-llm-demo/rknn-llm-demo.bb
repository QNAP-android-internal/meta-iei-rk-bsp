DESCRIPTION = "deep seek demo"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;;md5=801f80980d171dd6425610833a22dbe6"

INSANE_SKIP:${PN} += "ldflags"

SRC_URI += "\
	file://llm_demo \
	file://librkllmrt.so \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/opt/npu_demo/deep_seek_demo/
	install -d ${D}/opt/npu_demo/deep_seek_demo/lib/

	install -m 0777 ${WORKDIR}/llm_demo ${D}/opt/npu_demo/deep_seek_demo/
	install -m 0644 ${WORKDIR}/librkllmrt.so ${D}/opt/npu_demo/deep_seek_demo/lib/
}

FILES:${PN} += " \
    /opt \
    /opt/npu_demo \
    /opt/npu_demo/deep_seek_demo \
    /opt/npu_demo/deep_seek_demo/llm_demo \
    /opt/npu_demo/deep_seek_demo/lib \
    /opt/npu_demo/inference_demo/lib/librkllmrt.so \
"

# This line for /opt directory
INSANE_SKIP_${PN} += "installed-vs-shipped"
