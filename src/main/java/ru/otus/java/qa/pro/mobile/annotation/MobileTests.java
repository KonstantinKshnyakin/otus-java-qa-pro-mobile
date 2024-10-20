package ru.otus.java.qa.pro.mobile.annotation;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.otus.java.qa.pro.mobile.extensions.MobileTestExtension;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({MobileTestExtension.class, TextReportExtension.class})
public @interface MobileTests {
}