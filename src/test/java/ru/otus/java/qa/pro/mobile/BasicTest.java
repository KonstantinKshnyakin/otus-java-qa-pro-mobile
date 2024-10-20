package ru.otus.java.qa.pro.mobile;

import com.google.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.java.qa.pro.mobile.annotation.MobileTests;
import ru.otus.java.qa.pro.mobile.pages.ChatPage;
import ru.otus.java.qa.pro.mobile.pages.PresentationCarousel;

@MobileTests
public class BasicTest {

    @Inject
    private PresentationCarousel presentationCarousel;
    @Inject
    private ChatPage chatPage;

    @Test
    @DisplayName("Проверка презентационной карусели")
    public void checkPresentationCarousel() {
        presentationCarousel
                .textIsPresent("Chat to improve your English")
                .nextButtonIsPresent()
                .nextButtonClick()
                .textIsPresent("Learn new words and grammar")
                .nextButtonIsPresent()
                .nextButtonClick()
                .textIsPresent("7 days FREE")
                .skipButtonIsPresent()
                .skipButtonClick();
    }

    @Test
    @DisplayName("Проверка алерта")
    public void checkAlert() {
        presentationCarousel
                .scrollToSkipAndClick();
        chatPage
                .getAlert()
                .allerIsPresent()
                .okButtonClick();
    }

    @Test
    @DisplayName("Проверка отправки сообщения в чат")
    public void checkChatSendMessage() {
        presentationCarousel.scrollToSkipAndClick();
        chatPage.getAlert().okButtonClick();

        String text = "hi everyone 12345!";
        chatPage
                .inputIsPresent()
                .inputSend(text)
                .sendButtonIsPresent()
                .sendButtonClick()
                .textIsPresent(text + " ");
    }

}