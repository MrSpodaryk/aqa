package com.lviv.iot.aqa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public static final String TEXT_FROM_PAGE = "Піца";

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/span[2]")
    private WebElement casarioIncreaseCountButton;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/span[1]")
    private WebElement casarioDecreaseCountButton;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/input")
    private WebElement casarioCountFiled;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[2]/div/div[2]/div[2]/div[3]")
    private WebElement casarioSelectButton;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/span")
    private WebElement casarioFullPriceField;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[3]/div/div[2]/div[2]/div[2]/span[2]")
    private WebElement quadroFormadziIncreaseCountButton;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[3]/div/div[2]/div[2]/div[2]/span[1]")
    private WebElement quadroFormadziDecreaseCountButton;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[3]/div/div[2]/div[2]/div[2]/input")
    private WebElement quadroFormadziCountFiled;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[3]/div/div[2]/div[2]/div[3]")
    private WebElement quadroFormadziSelectButton;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div[3]/div/div[2]/div[2]/div[1]/span")
    private WebElement quadroFormadziFullPriceField;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[1]/div/h2")
    private WebElement pizzaField;

    @FindBy(xpath = "/html/body/div[2]/header/div/div/div/div[4]/div[3]/a/span/span")
    private WebElement basket;

    public void loadMainPage() {
        driver.get("https://la.ua/");
    }

    public String getTextFromMainPage() {
        return pizzaField.getText();
    }

    public Integer getPricePerOneCasario() {
        return Integer.parseInt(casarioFullPriceField.getText());
    }

    public Integer getPricePerOneQuadroFormadzi() {
        return Integer.parseInt(quadroFormadziFullPriceField.getText());
    }

    public void clickCasarioIncreaseCountButton() {
        casarioIncreaseCountButton.click();
    }

    public void clickCasarioDecreaseCountButton() {
        casarioDecreaseCountButton.click();
    }

    public void clickQuadroFormadziIncreaseCountButton() {
        quadroFormadziIncreaseCountButton.click();
    }

    public void clickQuadroFormadziDecreaseCountButton() {
        quadroFormadziDecreaseCountButton.click();
    }

    public Integer getFullPricePerCasario() {
        return Integer.valueOf(casarioFullPriceField.getText());
    }

    public Integer getFullPricePerQuadroFormadzi() {
        return Integer.valueOf(quadroFormadziFullPriceField.getText());
    }

    public void clickOnBasket() {
        basket.click();
    }

    public Integer getTotalPriceInBasket() {
        return Integer.parseInt(basket.getText());
    }

    public Integer getTotalPrice() {
        return getFullPricePerQuadroFormadzi() + getFullPricePerCasario();
    }

    public void clickSelectOnCasario() {
        casarioSelectButton.click();
    }

    public void clickSelectOnQuadroFormadzi() {
        quadroFormadziSelectButton.click();
    }
}
