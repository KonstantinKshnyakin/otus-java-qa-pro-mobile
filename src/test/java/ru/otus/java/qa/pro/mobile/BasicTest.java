package ru.otus.java.qa.pro.mobile;

import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.otus.java.qa.pro.mobile.extensions.MobileTestExtension;
import ru.otus.java.qa.pro.mobile.pages.ChatPage;
import ru.otus.java.qa.pro.mobile.pages.PresentationCarousel;

@ExtendWith(MobileTestExtension.class)
public class BasicTest {

    @Inject
    private PresentationCarousel presentationCarousel;
    @Inject
    private ChatPage chatPage;

    @Test
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
    public void checkAlert() {
        presentationCarousel
                .scrollToSkipAndClick();
        chatPage
                .getAlert()
                .allerIsPresent()
                .okButtonClick();
    }

    @Test
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