FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://asound.state"

do_install:append() {
    install -m 0644 ${WORKDIR}/asound.state ${D}/var/lib/alsa/asound.state
}
