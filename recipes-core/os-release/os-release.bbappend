OS_RELEASE_FIELDS = "\
    ID BUILD_ID \
"

do_compile[nostamp] = "1"

do_install:append() {
    META_IEI_PATH=$(echo ${BBPATH} | awk -F: '{for (i=1;i<=NF;i++)printf("%s\n", $i)}' |grep meta-iei-rk-bsp)
    cd ${META_IEI_PATH}

    case ${MACHINE} in
        wafer-rk3588)
            if git tag -l > /dev/null 2>&1; then
                OS_VERSION=$(git tag -l "*B675-YOCTO-050-*" --sort=-v:refname | sed -n 1p)
            fi
        ;;
    esac
    cd -
    install -d ${D}${sysconfdir}
    echo "VERSION=${OS_VERSION}" >> ${D}${sysconfdir}/os-release
    cd ${S}
}

