FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DESCRIPTION = "fw_env.config for libubootenv"

SRC_URI += "file://fw_env.config"

do_install:append() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}

FILES:${PN} += "${sysconfdir}/fw_env.config"
