#!/usr/bin/env bash
shopt -s globstar
rm -rf **/*.class
javac de/onyxbits/raccoon/standalone/gui/mock/MockDeviceActivity.java
cp ../dummydroid-2.2-original.jar ../dummydroid-2.2-patched.jar
jar -uf ../dummydroid-2.2-patched.jar de/onyxbits/raccoon/standalone/gui/mock/MockDeviceActivity.class
