package ru.otus.java.qa.pro.mobile.driver;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import javax.annotation.Nonnull;
import java.net.*;
import java.util.function.Consumer;

public class MobileDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        setOption("platformName", options::setPlatformName);
        setOption("platformVersion", options::setPlatformVersion);
        setOption("automationName", options::setAutomationName);
        setOption("deviceName", options::setDeviceName);
        setOption("udid", options::setUdid);

        String appiumUrl = System.getProperty("appiumUrl", "http://127.0.0.1:4723");

        String appPath = URLDecoder.decode(getClass().getResource("/Andy.apk").getPath(), UTF_8).substring(1);
        options.setApp(appPath);
        AppiumDriver driver;
        try {
            driver = new AndroidDriver(new URI(appiumUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    private void setOption(String propertyKey, Consumer<String> consumer) {
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue != null && !propertyValue.isBlank()) {
            consumer.accept(propertyValue);
        }
    }

}