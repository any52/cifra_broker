package ru.cifra_broker.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.cifra_broker.config.WebDriverProvider;
import ru.cifra_broker.helpers.Attach;
import ru.cifra_broker.pages.MainPage;


public class TestBaseExtended {

    static final String URL = "https://cifra-broker.ru/";
    MainPage mainPage = new MainPage();

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider provider = new WebDriverProvider();
    }

    @BeforeEach
    void addListener() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}