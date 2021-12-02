package com.lviv.iot.aqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver;

    public AlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[3]/div[6]/div[2]/div[1]/div/div")
    private WebElement noButton;

    public void clickNoButton() {
        noButton.click();
    }
}
