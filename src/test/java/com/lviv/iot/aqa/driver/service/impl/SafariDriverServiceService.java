package com.lviv.iot.aqa.driver.service.impl;

import com.lviv.iot.aqa.driver.service.DriverName;
import com.lviv.iot.aqa.driver.service.DriverService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.stereotype.Component;

public class SafariDriverServiceService implements DriverService {

    private WebDriver driver;

    @Override
    public DriverName getName() {
        return DriverName.SAFARI;
    }

    @Override
    public WebDriver getDriver() {
        if (driver == null) {
            driver = new SafariDriver();
        }
        return driver;
    }
}
