FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG += "no-idle-timeout"

SRC_URI += "file://pavucontrol.png \
            file://terminal.png \
"

do_install:append() {
    printf "\n[launcher]\nicon=/usr/share/icons/hicolor/32x32/apps/terminal.png\npath=/usr/bin/weston-terminal" >> ${D}${sysconfdir}/xdg/weston/weston.ini
    printf "\n[launcher]\nicon=/usr/share/icons/hicolor/32x32/apps/chromium.png\npath=/usr/bin/chromium --in-process-gpu" >> ${D}${sysconfdir}/xdg/weston/weston.ini
    printf "\n[launcher]\nicon=/usr/share/icons/hicolor/32x32/apps/pavucontrol.png\npath=/usr/bin/pavucontrol" >> ${D}${sysconfdir}/xdg/weston/weston.ini


    install -d ${D}/usr/share/icons/hicolor/32x32/apps/
    install -m 0644 ${WORKDIR}/terminal.png ${D}/usr/share/icons/hicolor/32x32/apps/
    install -m 0644 ${WORKDIR}/pavucontrol.png ${D}/usr/share/icons/hicolor/32x32/apps/
}

FILES:${PN} += " \
  /usr/share \
  /usr/share/icons \
  /usr/share/icons/hicolor \
  /usr/share/icons/hicolor/32x32 \
  /usr/share/icons/hicolor/32x32/apps \
  /usr/share/icons/hicolor/32x32/apps/terminal.png \
  /usr/share/icons/hicolor/32x32/apps/pavucontrol.png \
"
