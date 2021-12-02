package com.lviv.iot.aqa.driver;

import com.lviv.iot.aqa.driver.service.DriverName;
import com.lviv.iot.aqa.driver.service.impl.ChromeDriverServiceService;
import com.lviv.iot.aqa.driver.service.impl.SafariDriverServiceService;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import java.util.Set;


@Getter
public class DriverManager {

    private final WebDriver driver;

    public DriverManager() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        DriverServiceFactory factory = new DriverServiceFactory(Set.of(new ChromeDriverServiceService(), new SafariDriverServiceService()));
        driver = factory.getDriver(DriverName.CHROME);
    }
}
