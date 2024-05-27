DESCRIPTION = "This is image for KlexDash baseod on SoMLabs module"

inherit core-image populate_sdk_qt5

CONFLICT_DISTRO_FEATURES = "directfb"

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    tools-sdk \
    tools-debug \
    package-management \
    nfs-server \
    ssh-server-dropbear \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"

G2D_SAMPLES                 = ""
G2D_SAMPLES_imxgpu2d        = "imx-g2d-samples"
G2D_SAMPLES_imxgpu2d_imxdpu = ""

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'somlabs-demo', '', d)} \
    firmwared \
    packagegroup-core-full-cmdline \
    packagegroup-imx-core-tools \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-imx-security \
    packagegroup-imx-ml \
    packagegroup-qt5-imx \
    tzdata \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    {G2D_SAMPLES} \
    iperf3 \
    htop \
    nvme-cli \
    hdparm \
    stress-ng \
"
