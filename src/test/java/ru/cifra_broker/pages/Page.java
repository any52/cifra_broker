package ru.cifra_broker.pages;

import com.codeborne.selenide.WebDriverRunner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Page {

    public void verifyUrlPage(String expectedUrl) {
        Set<String> pages = WebDriverRunner.getWebDriver().getWindowHandles();
        WebDriverRunner.getWebDriver().switchTo().window(pages.stream().toList().get(pages.size()-1));
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }
}
