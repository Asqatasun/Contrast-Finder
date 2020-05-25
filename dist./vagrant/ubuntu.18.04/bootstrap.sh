#!/usr/bin/env bash

# stop at first error
set -e

VERSION="1.0.0-SNAPSHOT"
OS="ubuntu.18.04"
DEB_FILE="contrast-finder-webapp_${VERSION}_${OS}.deb"


cd /vagrant

echo "--- 0 ---------------------------"
apt-get update

echo "--- 1 ---------------------------"
apt-get  -y --no-install-recommends                 \
         install wget                               \
                 curl                               \
                 ca-certificates                    \
                 tomcat8
echo "--- 2 ---------------------------"
mkdir -p src_db
mv -v "${DEB_FILE}" "src_db/${DEB_FILE}"
set -e
rm -v *.deb
set +e
cd src_db
dpkg    -i "${DEB_FILE}"

