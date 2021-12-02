package com.lviv.iot.aqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    public static final String NAME           = "Roman";
    public static final String PHONE          = "123456789";
    public static final String STREET         = "Варшавська вулиця";
    public static final String HOUSE_NUMBER   = "12";
    public static final String FULL_PHONE     = "+38(012)345-67-89";
    public static final String FINAL_TEXT     = "Ця адреса в зеленій зоні";
    public static final String TEXT_FROM_PAGE = "Ваше замовлення";

    public WebDriver driver;

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[2]/section/div[2]/div[1]/div/div/h1")
    private WebElement myOrderField;

    @FindBy(xpath = "/html/body/div[2]/section/div[2]/div[2]/div/div/div[2]/div[2]/form/label[1]/span/input")
    private WebElement nameField;

    @FindBy(xpath = "/html/body/div[2]/section/div[2]/div[2]/div/div/div[2]/div[2]/form/label[1]/span")
    private WebElement nameFieldSpan;

    @FindBy(xpath = "/html/body/div[2]/section/div[2]/div[2]/div/div/div[2]/div[2]/form/label[2]/span/input")
    private WebElement phoneField;

    @FindBy(xpath = "/html/body/div[2]/section/div[2]/div[2]/div/div/div[2]/div[2]/form/div[2]/div[2]/div/label/span/input")
    private WebElement streetField;

    @FindBy(xpath = "/html/body/ul/li/div")
    private WebElement streetSelect;

    @FindBy(xpath = "/html/body/div[2]/section/div[2]/div[2]/div/div/div[2]/div[2]/form/div[2]/div[3]/label/span/input")
    private WebElement houseNumber;

    @FindBy(xpath = "/html/body/div[2]/section/div[2]/div[2]/div/div/div[2]/div[3]/a")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/div[2]/section/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]")
    private WebElement greenElement;

    public String getTextFromOrderPage() {
        return myOrderField.getText();
    }

    public void fillNameField(String value) {
        nameField.sendKeys(value);
    }

    public String getNameFieldValue() {
        return nameField.getAttribute("value");
    }

    public void fillPhoneField(String value) {
        phoneField.sendKeys(value);
    }

    public String getPhoneFieldValue() {
        return phoneField.getAttribute("value");
    }

    public void fillStreetField(String value) {
        streetField.sendKeys(value);
    }

    public void clickOnSelectedStreet() {
        streetSelect.click();
    }

    public void fillHouseNumberField(String value) {
        houseNumber.sendKeys(value);
    }

    public String getHouseNumberFieldValue() {
        return houseNumber.getAttribute("value");
    }

    public boolean isFinalTextShown() {
        return greenElement.getText().contains(FINAL_TEXT);
    }
}
