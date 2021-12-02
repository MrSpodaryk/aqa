package com.lviv.iot.aqa.driver.service;

import org.openqa.selenium.WebDriver;

public interface DriverService {

    DriverName getName();

    WebDriver getDriver();
}
