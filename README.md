# otus-java-qa-pro-mobile

### Технологии:
- JUnit 5
- Appium
- Selenide
- Google Guice

**Строка запуска : `mvn clean test -DplatformName=android -DplatformVersion=15.0 -DautomationName=UIAutomator2 -DdeviceName=Pixel_7 -Dudid=emulator-5554 -DappiumUrl=http://127.0.0.1:4723`**
**Строка запуска : `docker run --rm -e PLATFORM_NAME=android -e PLATFORM_VERSION=15.0 -e AUTOMATION_NAME=UIAutomator2 -e DEVICE_NAME=Pixel_7 -e UDID=emulator-5554 -e APPIUM_URL=http://192.168.56.1:4723 -e APK_PATH=C:\\Users\\Константин\\IdeaProjects\\otus-java-qa-pro-mobile\\src\\main\\resources\\Andy.apk localhost:5000/mobile-tests:1.0.0`**

Ни один из параметров не является обязательным. Конфигурируете под свою систему.

Необходимо обязательно:
- поднятый appium-server
- поднятый эмулятор или подключеный Android смарфон
