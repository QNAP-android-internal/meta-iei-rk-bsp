SUMMARY = "bluealsa config"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit systemd

SRC_URI += " \
	file://bluealsa.conf \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/etc
	install -m 0644 ${S}/bluealsa.conf ${D}/etc/
}

FILES:${PN} = "\
	/etc \
	/etc/bluealsa.conf \
"
