package ru.otus.java.qa.pro.mobile.pages;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import com.google.inject.Singleton;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

@Singleton
public class PresentationCarousel implements CommonMethods<PresentationCarousel> {

    private final By nextButtonSelector = androidUIAutomator("new UiSelector().text(\"Next\")");
    private final By skipButtonSelector = androidUIAutomator("new UiSelector().text(\"Skip >\")");

    private final SelenideAppiumElement nextButton = $(nextButtonSelector);
    private final SelenideAppiumElement skipButton = $(skipButtonSelector);

    public PresentationCarousel nextButtonIsPresent() {
        checkClickable(nextButtonSelector, "Next");
        return this;
    }

    @Step("Клик по кнопке 'Next'")
    public PresentationCarousel nextButtonClick(){
        nextButton.click();
        return this;
    }

    public PresentationCarousel skipButtonIsPresent() {
        checkClickable(skipButtonSelector, "Skip");
        return this;
    }

    @Step("Клик по кнопке 'Skip'")
    public PresentationCarousel skipButtonClick(){
        skipButton.click();
        return this;
    }

    @Step("Просвайпать презентационную карусель до 'Skip' и кликнуть")
    public PresentationCarousel scrollToSkipAndClick(){
        skipButton.swipeTo();
        skipButton.click();
        return this;
    }

}