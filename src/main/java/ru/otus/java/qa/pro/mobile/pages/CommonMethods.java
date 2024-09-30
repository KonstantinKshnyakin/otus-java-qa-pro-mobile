package ru.otus.java.qa.pro.mobile.pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public interface CommonMethods<T> {

    default boolean shouldBe(By by, WebElementCondition... condition) {
        try {
            $(by).shouldBe(condition);
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    default T textIsPresent(String expText){
        boolean act = shouldBe(androidUIAutomator("new UiSelector().text(\"%s\")".formatted(expText)), Condition.exist);
        Assertions.assertTrue(act, "expected text: '%s'".formatted(expText));
        return (T) this;
    }

    default void checkClickable(By by, String buttonName) {
        boolean act = shouldBe(by, exist, clickable);
        assertTrue(act, "'%s' button is exist, clickable".formatted(buttonName));
    }

    default void checkText(By by, String expText) {
        boolean act = shouldBe(by, exist);
        assertTrue(act, "locator present: %s".formatted(by.toString()));
        String actText = $(by).text();
        Assertions.assertEquals(expText, actText, "locator '%s' with text '%s'".formatted(by.toString(), expText));
    }

}
