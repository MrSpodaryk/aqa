package com.lviv.iot.aqa.driver.service.impl;

import com.lviv.iot.aqa.driver.service.DriverName;
import com.lviv.iot.aqa.driver.service.DriverService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverServiceService implements DriverService {

    private WebDriver driver;

    @Override
    public DriverName getName() {
        return DriverName.CHROME;
    }

    @Override
    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
