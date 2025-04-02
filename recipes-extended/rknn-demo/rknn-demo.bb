DESCRIPTION = "rknn yolov5 demo"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;;md5=801f80980d171dd6425610833a22dbe6"

INSANE_SKIP:${PN} += "ldflags"

SRC_URI += "\
	file://yolov5s-640-640.rknn \
	file://rknn_yolov5_demo \
	file://librknnrt.so \
	file://librga.so \
	file://coco_80_labels_list.txt \
	file://bus.jpg \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/opt/npu_demo/inference_demo/
	install -d ${D}/opt/npu_demo/inference_demo/model/
	install -d ${D}/opt/npu_demo/inference_demo/lib/
	install -d ${D}/opt/npu_demo/inference_demo/model/RK3588

	install -m 0777 ${WORKDIR}/rknn_yolov5_demo ${D}/opt/npu_demo/inference_demo/
	install -m 0644 ${WORKDIR}/librknnrt.so ${D}/opt/npu_demo/inference_demo/lib/
	install -m 0644 ${WORKDIR}/librga.so ${D}/opt/npu_demo/inference_demo/lib/
	install -m 0644 ${WORKDIR}/coco_80_labels_list.txt ${D}/opt/npu_demo/inference_demo/model/
	install -m 0644 ${WORKDIR}/bus.jpg ${D}/opt/npu_demo/inference_demo/model/
	install -m 0644 ${WORKDIR}/yolov5s-640-640.rknn ${D}/opt/npu_demo/inference_demo/model/RK3588
}

FILES:${PN} += " \
    /opt \
    /opt/npu_demo \
    /opt/npu_demo/inference_demo \
    /opt/npu_demo/inference_demo/rknn_yolov5_demo \
    /opt/npu_demo/inference_demo/model \
    /opt/npu_demo/inference_demo/model/bus.jpg \
    /opt/npu_demo/inference_demo/model/coco_80_labels_list.txt \
    /opt/npu_demo/inference_demo/model/RK3588 \
    /opt/npu_demo/inference_demo/lib \
    /opt/npu_demo/inference_demo/lib/librga.so \
    /opt/npu_demo/inference_demo/lib/RK3588 \
    /opt/npu_demo/inference_demo/lib/librknnrt.so \
"

# This line for /opt directory
INSANE_SKIP_${PN} += "installed-vs-shipped"
