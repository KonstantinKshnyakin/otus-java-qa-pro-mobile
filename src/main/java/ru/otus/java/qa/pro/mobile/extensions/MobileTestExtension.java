package ru.otus.java.qa.pro.mobile.extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.inject.Guice;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import ru.otus.java.qa.pro.mobile.driver.MobileDriver;

public class MobileTestExtension implements TestInstancePostProcessor {

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        Selenide.closeWebDriver();
        Configuration.browserSize = null;
        Configuration.browser = MobileDriver.class.getName();
        Guice.createInjector().injectMembers(testInstance);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Selenide.open();
    }

}