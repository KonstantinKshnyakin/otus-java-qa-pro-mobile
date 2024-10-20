package ru.otus.java.qa.pro.mobile.pages.components;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import com.google.inject.Singleton;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.otus.java.qa.pro.mobile.pages.CommonMethods;

@Singleton
public class Alert implements CommonMethods {

    private final By titleSelector = id("android:id/alertTitle");
    private final By messageSelector = id("android:id/message");
    private final By okButtonSelector = id("android:id/button1");

    private final SelenideAppiumElement okButton = $(okButtonSelector);

    @Step("Клик по 'OK'")
    public Alert okButtonClick(){
        okButton.click();
        return this;
    }

    @Step("Проверка 'Alert'а")
    public Alert allerIsPresent(){
        checkText(titleSelector, "Alert");
        checkText(messageSelector, "Failed to get push token for push notification!");
        checkClickable(okButtonSelector, "OK");
        return this;
    }

}