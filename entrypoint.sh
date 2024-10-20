#!/bin/bash

command="mvn test -DplatformName=$PLATFORM_NAME
                                   -DplatformVersion=$PLATFORM_VERSION
                                   -DautomationName=$AUTOMATION_NAME
                                   -DdeviceName=$DEVICE_NAME
                                   -Dudid=$UDID
                                   -DappiumUrl=$APPIUM_URL
                                   -DapkPath=$APK_PATH
                                   -DisRemote=true
                                   "
eval $command