# meta-klexdash

## Introduction

Meta-klexdash is a layer providing the SoMLabs module hardware support for KlexDash Yocto-based NXP Linux system.

## System image

This layer should be used in order to build the system image. This layer adds a new example image called klexdash-image.

## Building the system image

The general description of the building process is described in the iMX Yocto Project User's Guide document:

https://www.nxp.com/docs/en/user-guide/IMXLXYOCTOUG.pdf

The summary of required steps including the meta-klexdash layer is shown below:

```shell
mkdir imx-yocto-bsp
cd imx-yocto-bsp
repo init -u https://github.com/klexdash/imx-meta-klexdash -b hardknott -m imx-klexdash-5.10.72-2.2.0.xml
repo sync
```

System building may be configured for machine configuration:

* visionsom-8mm-cb - VisionCB-8M board family with VisionSOM-8Mmini modules

The following system distributions were tested on klexdash modules:

* fsl-imx-fb - distribution without graphical environment
* fsl-imx-xwayland - distribution with wayland and x11 enabled

System building may be started by the following commands:

```shell
DISTRO=<SELECTED_DISTRIBUTION> MACHINE=<SELECTED_MACHINE> source imx-klexdash-setup-release.sh -b <BUILD_DIRECTORY>
bitbake klexdash-image
```

The system image is located in the klexdash-image-<SELECTED_MACHINE>.wic.bz2 file in the tmp/deploy/images/<SELECTED_MACHINE> directory. It should be extracted and installed on a SD-card:

```shell
bunzip2 -dkf klexdash-image-<SELECTED_MACHINE>.wic.bz2 
sudo dd if=klexdash-image-<SELECTED_MACHINE>.wic of=/dev/sdX bs=1M
```

The instruction for the eMMC memory image installation may be found on the following wiki pages:

* VisionSOM-6ULL: https://wiki.klexdash.com/index.php/Writing_VisionSOM-6ULL_system_image_to_eMMC_memory
* VisionSOM-8MM: https://wiki.klexdash.com/index.php/Writing_VisionSOM-8MM_system_image_to_eMMC_memory
