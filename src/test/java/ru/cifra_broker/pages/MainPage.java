package ru.cifra_broker.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends Page {

    private static final String URL =  "https://cifra-broker.ru/";;
    private SelenideElement bankLink = $("[href='https://cifra-bank.ru/']"),
            businessLink = $("[href='/business/']"),
            loginBtn = $(".header__profile .btn-login "),
            analyticsLink = $("[href='/analytics/'"),
            tariffLink = $("[href='/tariffs/']"),
            phoneLabel = $(".tel__number"),
            addressLabel = $(".footer__contact .address");

    private final String EXPECTED_PHONE = "+7 (495) 783-91-73";
    private final String EXPECTED_ADDRESS = "123112, г. Москва, 1-й Красногвардейский проезд," +
            " д. 15 (18 этаж, башня «Меркурий Тауэр», ММДЦ «Москва-Сити»)";

    public void openPage() {
        open(URL);
    }

    public void clickBankLink() {
        bankLink.click();
    }

    public void clickBusinessLink() {
        businessLink.click();
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void clickAalyticsLink() {
        analyticsLink.click();
    }

    public void clickTariffLink() {
        tariffLink.click();
    }

    public void verifyContacts() {
        phoneLabel.shouldHave(text(EXPECTED_PHONE));
        addressLabel.shouldHave(text(EXPECTED_ADDRESS));
    }
}
