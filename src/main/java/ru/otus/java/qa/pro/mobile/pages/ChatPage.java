package ru.otus.java.qa.pro.mobile.pages;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.otus.java.qa.pro.mobile.pages.components.Alert;

@Singleton
public class ChatPage implements CommonMethods<ChatPage> {

    private final By inputSelector = androidUIAutomator("new UiSelector().text(\"Type a message...\")");
    private final By sendButtonSelector = androidUIAutomator("new UiSelector().text(\"Send\")");

    private final SelenideAppiumElement input = $(inputSelector);
    private final SelenideAppiumElement sendButton = $(sendButtonSelector);

    private final Alert alert;

    @Inject
    public ChatPage(Alert alert) {
        this.alert = alert;
    }

    public Alert getAlert() {
        return alert;
    }

    public ChatPage inputIsPresent() {
        checkClickable(inputSelector, "Type a message...");
        return this;
    }

    @Step("Ввод текста 'text'")
    public ChatPage inputSend(String text) {
        input.sendKeys(text);
        return this;
    }

    public ChatPage sendButtonIsPresent() {
        checkClickable(sendButtonSelector, "Send");
        return this;
    }

    @Step("Клик по 'Send'")
    public ChatPage sendButtonClick() {
        sendButton.click();
        return this;
    }

}