package com.lviv.iot.aqa.driver;

import com.lviv.iot.aqa.driver.service.DriverName;
import com.lviv.iot.aqa.driver.service.DriverService;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DriverServiceFactory {

    private final Map<DriverName, DriverService> driverMap;

    public DriverServiceFactory(Set<DriverService> driverServices) {
        this.driverMap = registerDrivers(driverServices);
    }

    private Map<DriverName, DriverService> registerDrivers(Set<DriverService> driverServices) {
        var driverMap = new HashMap<DriverName, DriverService>();
        driverServices.forEach(driverService -> driverMap.put(driverService.getName(), driverService));
        return driverMap;
    }

    public WebDriver getDriver(DriverName driverName) {
        return driverMap.get(driverName).getDriver();
    }
}
