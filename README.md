# Yocto BSP Layer for IEI Boards

This repository contains the Yocto BSP (Board Support Package) layer for IEI boards. It includes the necessary configurations, recipes, and scripts to build and deploy a custom Linux distribution for IEI hardware using the Yocto Project.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Setup](#setup)
  - [Building the Image](#building-the-image)
  - [Flashing the Image](#flashing-the-image)
- [Directory Structure](#directory-structure)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Yocto Project is an open-source collaboration project that provides templates, tools, and methods to help you create custom Linux-based systems for embedded products. This BSP layer is specifically designed for IEI boards, enabling the creation of tailored Linux distributions.

## Features

- Support for various IEI board models
- Custom recipes for board-specific software and configurations
- Integration with the Yocto Project build system
- Shell scripts to automate common tasks

## Getting Started

To get started with building and deploying a custom Linux image for IEI boards, follow the steps below.

### Prerequisites

Ensure you have the following installed on your build machine:

- A supported Linux distribution (e.g., Ubuntu, CentOS)
- Git
- Docker (optional, for containerized builds)
- Yocto Project tools (e.g., `bitbake`, `oe-init-build-env`)

### Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/QNAP-android-internal/meta-iei-rk-bsp.git
    cd meta-iei-rk-bsp
    ```

2. Initialize the Yocto build environment:
    ```bash
    source oe-init-build-env
    ```

3. Add the meta-iei-rk-bsp layer to your `bblayers.conf`:
    ```bash
    bitbake-layers add-layer ../meta-iei-rk-bsp
    ```

### Building the Image

1. Configure the build for your target IEI board by editing `local.conf`:
    ```bash
    nano conf/local.conf
    ```

2. Build the image:
    ```bash
    bitbake core-image-minimal
    ```

### Flashing the Image

1. Once the build completes, write the image to an SD card or other storage device:
    ```bash
    sudo dd if=tmp/deploy/images/<board>/<image>.wic of=/dev/sdX bs=4M
    sync
    ```

2. Insert the SD card into your IEI board and power it on.

## Directory Structure

- `recipes-<category>/`: Contains Yocto recipes for various software packages.
- `conf/`: Configuration files for the Yocto build system.
- `scripts/`: Shell scripts for automating tasks.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
