SUMMARY = "SystemD service to init Bluetooth"
SECTION = "devel"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit systemd

SRC_URI += " \
    file://bt-init.service \
    file://bt-init.sh \
"

S = "${WORKDIR}"

do_install:append () {
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${S}/bt-init.service ${D}${systemd_system_unitdir}/bt-init.service
        install -d ${D}${bindir}
        install -m 0755 ${S}/bt-init.sh ${D}${bindir}/bt-init.sh
}

FILES:${PN} = "\
         ${systemd_system_unitdir} \
         ${bindir} \
         ${systemd_system_unitdir}/bt-init.service \
         ${bindir}/bt-init.sh \
"


SYSTEMD_SERVICE:${PN} = "bt-init.service"

INSANE_SKIP:${PN} = "file-rdeps"
