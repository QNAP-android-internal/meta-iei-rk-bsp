#!/bin/sh

CWD=$(pwd)
PROGNAME="$CWD/oe-init-build-env"

if [ -z "$BUILD" ]; then
        BUILD="build"
fi


MACHINE=$MACHINE DISTRO=$DISTRO source $PROGNAME $@

CWD=$(pwd)

if [ -f ${CWD}/../sources/meta-iei-rk-bsp/conf/iei-conf/$MACHINE/bblayers.conf ]; then
        cat ${CWD}/../sources/meta-iei-rk-bsp/conf/iei-conf/$MACHINE/bblayers.conf > ${CWD}/conf/bblayers.conf
fi
if [ -f ${CWD}/../sources/meta-iei-rk-bsp/conf/iei-conf/$MACHINE/local.conf ]; then
        cat ${CWD}/../sources/meta-iei-rk-bsp/conf/iei-conf/$MACHINE/local.conf > ${CWD}/conf/local.conf
fi

sed -e "s,^DISTRO ?=.*$,DISTRO ?= '$DISTRO',g" -i ${CWD}/conf/local.conf

echo "PA_USER ?= \"iei-user\"" >> ${CWD}/conf/local.conf
