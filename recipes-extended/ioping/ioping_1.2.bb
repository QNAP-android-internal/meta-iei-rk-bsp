DESCRIPTION = "ioping – simple disk I/O latency monitoring tool"
HOMEPAGE = "https://github.com/koct9i/ioping"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/koct9i/ioping/archive/refs/tags/v1.2.tar.gz"
SRC_URI[sha256sum] = "d3e4497c653a1e96df67c72ce2b70da18e9f5e3b93179a5bb57a6e30ceacfa75"

S = "${WORKDIR}/ioping-1.2"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ioping ${D}${bindir}/ioping
}

