package ru.cifra_broker.test;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static ru.cifra_broker.helpers.Attach.veryfyConsoleLog;

public class CommonTests extends TestBaseExtended {

    private final String URL_BANK_PAGE = "https://cifra-bank.ru/";
    private final String URL_BUSINESS_PAGE = "https://cifra-broker.ru/business/";
    private final String URL_LOGIN_PAGE = "https://tradernet.ru/authentication/login/";
    private final String URL_ANALYTICS_PAGE = "https://cifra-broker.ru/analytics/";
    private static String URL_TARIFF_PAGE = "https://cifra-broker.ru/tariffs/";
    private static String URL_EDUCATION_PAGE = "https://webinar.cifra-broker.ru/";

    @Test
    @Owner("almoiseeva")
    @Tag("ui")
    @DisplayName("Проверить ссылку на раздел \"Банк\" в главном меню")
    void checkLinkBankFromMainMenuTest() {
        step("Открыть страницу " + URL, () -> {
            mainPage.openPage();
        });

        step("Нажать на раздел \"Банк\" в главном меню", () -> {
            mainPage.clickBankLink();
        });

        step("Проверить, что открылась страница " + URL_BANK_PAGE, () -> {
            mainPage.verifyUrlPage(URL_BANK_PAGE);
        });
    }

    @Test
    @Owner("almoiseeva")
    @Tag("ui")
    @DisplayName("Проверить ссылку на раздел \"Бизнесу\" в главном меню")
    void checkLinkBusinessFromMainMenuTest() {
        step("Открыть страницу " + URL, () -> {
            mainPage.openPage();
        });

        step("Нажать на раздел \"Бизнесу\" в главном меню", () -> {
            mainPage.clickBusinessLink();
        });

        step("Проверить, что открылась страница " + URL_BUSINESS_PAGE, () -> {
            mainPage.verifyUrlPage(URL_BUSINESS_PAGE);
        });

    }

    @Test
    @Owner("almoiseeva")
    @Tag("ui")
    @DisplayName("Проверить ссылку на открытие страницы логина")
    void checkLoginPageTest() {
        step("Открыть страницу " + URL, () -> {
            mainPage.openPage();
        });

        step("Нажать на кнопку \"Войти\" ", () -> {
            mainPage.clickLoginBtn(); //todo
        });

        step("Проверить, что открылась страница " + URL_LOGIN_PAGE, () -> {
            mainPage.verifyUrlPage(URL_LOGIN_PAGE);
        });

    }

    @Test
    @Owner("almoiseeva")
    @Tag("ui")
    @DisplayName("Проверить ссылку на раздел \"Аналитика\"")
    void checkLinkAnalyticsTest() {
        step("Открыть страницу " + URL, () -> {
            mainPage.openPage();
        });

        step("Нажать на раздел \"Аналитика\"", () -> {
            mainPage.clickAalyticsLink();
        });

        step("Проверить, что открылась страница " + URL_ANALYTICS_PAGE, () -> {
            mainPage.verifyUrlPage(URL_ANALYTICS_PAGE);
        });

    }

    @Test
    @Owner("almoiseeva")
    @Tag("ui")
    @DisplayName("Проверить ссылку на раздел \"Тарифы\"")
    void checkLinkTariffTest() {
        step("Открыть страницу " + URL, () -> {
            mainPage.openPage();
        });

        step("Нажать на раздел \"Тарифы\"", () -> {
            mainPage.clickTariffLink();
        });

        step("Проверить, что открылась страница " + URL_TARIFF_PAGE, () -> {
            mainPage.verifyUrlPage(URL_TARIFF_PAGE);
        });

    }

    @Test
    @Owner("almoiseeva")
    @Tag("ui")
    @DisplayName("Проверить секцию \"Контакты\"")
    void checkContactsTest() {

        step("Открыть страницу " + URL, () -> {
            mainPage.openPage();
        });

        step("Проверить, что в секции \"Контакты\" содержатся ожидаемыe номер телефона и адрес", () -> {
            mainPage.verifyContacts();
        });

    }

    @Test
    @Owner("almoiseeva")
    @Tag("ui")
    @DisplayName("Проверить лог консоли на отсутствие ошибок")
    void checkConsolLogTest() {
        step("Открыть страницу " + URL, () -> {
            mainPage.openPage();
        });

        step("Журнал консоли не должен содержать текст 'SEVERE'", () -> {
            veryfyConsoleLog();
        });

    }
}
