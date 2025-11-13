FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

INSANE_SKIP:${PN} += "already-stripped file-rdeps"

inherit systemd

SRCREV = "${AUTOREV}"
SRC_URI += "\
	git://10.20.70.37/sw3_yocto_rk356x_odm_group/odm/abm/iaso-rk3568/dqv/iei-dqv-tools.git;protocol=ssh;branch=b675_yocto_050_dqv; \
"
do_install:append () {
	install -d ${D}/iei_dqv_tool
	install -m 0755  ${WORKDIR}/git/config.sh ${D}/iei_dqv_tool/
        install -m 0755  ${WORKDIR}/git/exec.sh ${D}/iei_dqv_tool/
        install -m 0755  ${WORKDIR}/git/logging_utils.sh ${D}/iei_dqv_tool/
        install -m 0755  ${WORKDIR}/git/main.sh ${D}/iei_dqv_tool/
	install -m 0755  ${WORKDIR}/git/test_png/SMPTE_Color_Bars_16x9.svg.png ${D}/iei_dqv_tool/
	install -d ${D}/${ROOT_HOME}
	install -m 0644  ${WORKDIR}/git/test_png/image.png ${D}/${ROOT_HOME}/
	install -d ${D}/iei_dqv_tool/burnin
	install -m 0755  ${WORKDIR}/git/burnin/burnin_loop.sh ${D}/iei_dqv_tool/burnin/
	install -m 0755  ${WORKDIR}/git/burnin/cpu_burnin.sh ${D}/iei_dqv_tool/burnin/
	install -m 0755  ${WORKDIR}/git/burnin/gpu_burnin.sh ${D}/iei_dqv_tool/burnin/
	install -m 0755  ${WORKDIR}/git/burnin/mem_burnin.sh ${D}/iei_dqv_tool/burnin/
	install -m 0755  ${WORKDIR}/git/burnin/usb_burnin.sh ${D}/iei_dqv_tool/burnin/
	install -m 0755  ${WORKDIR}/git/burnin/wifi_burnin.sh ${D}/iei_dqv_tool/burnin/
	install -d ${D}/iei_dqv_tool/configs
	install -m 0755  ${WORKDIR}/git/configs/RK3588_qc_config.json ${D}/iei_dqv_tool/configs/
	install -m 0755  ${WORKDIR}/git/configs/main_menu.json ${D}/iei_dqv_tool/configs/
	install -d ${D}/iei_dqv_tool/other_tools
	install -m 0755  ${WORKDIR}/git/other_tools/log.sh ${D}/iei_dqv_tool/other_tools/
	install -m 0755  ${WORKDIR}/git/other_tools/wifi_expect.sh ${D}/iei_dqv_tool/other_tools/
	install -d ${D}/${bindir}
	install -m 0755  ${WORKDIR}/git/other_tools/fingerpaint ${D}/${bindir}/
	install -m 0755  ${WORKDIR}/git/other_tools/showimage ${D}/${bindir}/
	install -d ${D}/iei_dqv_tool/pcba_test
	install -m 0755  ${WORKDIR}/git/pcba_test/backlight_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/bt_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/emmc_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/eth_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/gpu_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/hdmi_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/mem_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/m2_ssd_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/rgb_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -m 0755  ${WORKDIR}/git/pcba_test/rtc_qc.sh ${D}/iei_dqv_tool/pcba_test/
        install -m 0755  ${WORKDIR}/git/pcba_test/usb_qc.sh ${D}/iei_dqv_tool/pcba_test/
	install -d ${D}/iei_dqv_tool/reboot_test
	install -d ${D}/iei_dqv_tool/reboot_test/errlog
	install -m 0755  ${WORKDIR}/git/reboot_test/onoff_test.sh ${D}/iei_dqv_tool/reboot_test/
	install -m 0755  ${WORKDIR}/git/reboot_test/reboot_test.sh ${D}/iei_dqv_tool/reboot_test/
	install -m 0755  ${WORKDIR}/git/reboot_test/settimes.txt ${D}/iei_dqv_tool/reboot_test/
	install -m 0755  ${WORKDIR}/git/reboot_test/weston_poweronoff_test.sh ${D}/iei_dqv_tool/reboot_test/
	install -m 0755  ${WORKDIR}/git/reboot_test/weston_reboot_test.sh ${D}/iei_dqv_tool/reboot_test/
	install -d ${D}/${systemd_system_unitdir}
	install -m 0644  ${WORKDIR}/git/service/main_test.service ${D}${systemd_system_unitdir}/main_test.service
	install -m 0644  ${WORKDIR}/git/service/power-onoff-test.service ${D}${systemd_system_unitdir}/
	install -m 0644  ${WORKDIR}/git/service/reboot_test.service ${D}${systemd_system_unitdir}/
	install -d ${D}/iei_dqv_tool/ui
	install -m 0755  ${WORKDIR}/git/ui/ui_about.sh ${D}/iei_dqv_tool/ui/
	install -m 0755  ${WORKDIR}/git/ui/ui_burnin.sh ${D}/iei_dqv_tool/ui/
	install -m 0755  ${WORKDIR}/git/ui/ui_pcba.sh ${D}/iei_dqv_tool/ui/
	install -m 0755  ${WORKDIR}/git/ui/ui_power_onoff.sh ${D}/iei_dqv_tool/ui/
	install -m 0755  ${WORKDIR}/git/ui/ui_reboot.sh ${D}/iei_dqv_tool/ui/
}

FILES:${PN} ="/iei_dqv_tool/ \
${systemd_system_unitdir}/ \
${ROOT_HOME}/ \
${bindir}/ \
"

SYSTEMD_SERVICE:${PN} = "main_test.service"

DQV_TOOLS = "dialog jq stress-ng usbutils memtester io mmc-utils evtest libinput i2c-tools tslib tslib-tests tslib-calibrate strace glmark2 iperf2 iperf3 fio fb-test coreutils systemd-analyze libcap chrony cifs-utils tzdata"
RDEPENDS:${PN}:append = "${DQV_TOOLS} expect"
RPROVIDES:${PN} += "libQt5Core.so.5()(64bit) \
libQt5Core.so.5(Qt_5)(64bit) \
libQt5Core.so.5()(64bit)dialog \
libQt5Widgets.so.5(Qt_5)(64bit) \
libQt5Gui.so.5(Qt_5)(64bit) \
libQt5Widgets.so.5()(64bit) \
libQt5Gui.so.5()(64bit) \
libQt5Core.so.5()(64bit)"

RDEPENDS:${PN} += "libQt5Core.so.5(Qt_5)(64bit) \
libQt5Widgets.so.5(Qt_5)(64bit) \
libQt5Gui.so.5(Qt_5)(64bit) \
libQt5Widgets.so.5()(64bit) \
libQt5Gui.so.5()(64bit) \
libQt5Core.so.5()(64bit)"
