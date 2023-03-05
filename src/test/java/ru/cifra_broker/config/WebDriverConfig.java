package ru.cifra_broker.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://cifra-broker.ru/")
    String getBaseUrl();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteURL();

}
