package ru.cifra_broker.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        createDriver();
    }

    public void createDriver() {
        Configuration.baseUrl = config.getBaseUrl();
        switch (config.getBrowser().toLowerCase()) {
            case "chrome": {
                Configuration.browser = "chrome";
                break;
            }
            case "firefox": {
                Configuration.browser = "firefox";
                break;
            }
            default:
                throw new RuntimeException("No such driver: + " + config.getBrowser());

        }
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        String remoteURL = config.getRemoteURL();

        if (remoteURL != null) {
            Configuration.remote = remoteURL;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;



    }

}