FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

KERNEL_SRC = "git://github.com/SoMLabs/somlabs-linux-imx.git;protocol=http"
SRC_URI = " \
		${KERNEL_SRC};branch=${KERNEL_BRANCH} \
		file://0001-device-tree.patch \
		file://0002-defconfig.patch \
		"

KERNEL_BRANCH = "somlabs_imx_5.10.72-2.2.0"
SRCREV = "12c292ea743de0a2adca6fdd1c4e14b788aa17c8"

IMX_KERNEL_CONFIG_AARCH64_visionsom-8mm-cb = "somlabs_8m_defconfig"

# Remove the kernel-image dependency to not install additional kernel packages
RDEPENDS_${KERNEL_PACKAGE_NAME}-base = ""
