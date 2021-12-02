package com.lviv.iot.aqa;

import com.lviv.iot.aqa.driver.DriverManager;
import com.lviv.iot.aqa.page.AlertPage;
import com.lviv.iot.aqa.page.MainPage;
import com.lviv.iot.aqa.page.OrderPage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AqaApplicationTests {
    public static WebDriver driver;
    public static MainPage  mainPage;
    public static AlertPage alertPage;
    public static OrderPage orderPage;

    @BeforeAll
    public static void setup() {
        driver = new DriverManager().getDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        alertPage = new AlertPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    @Order(1)
    @SneakyThrows
    public void loadPage() {
        mainPage.loadMainPage();
        Assertions.assertEquals(MainPage.TEXT_FROM_PAGE, mainPage.getTextFromMainPage());
        Thread.sleep(2000);
    }

    @Test
    @Order(2)
    @SneakyThrows
    public void addThreeCesario() {
        mainPage.clickCasarioIncreaseCountButton();
        mainPage.clickCasarioIncreaseCountButton();

        Thread.sleep(300);
        Assertions.assertEquals(mainPage.getPricePerOneCasario() * 3, mainPage.getFullPricePerCasario());
    }

    @Test
    @Order(3)
    @SneakyThrows
    public void addThreeAndDeleteOneQuadroFormadzi() {
        mainPage.clickQuadroFormadziIncreaseCountButton();
        mainPage.clickQuadroFormadziIncreaseCountButton();
        mainPage.clickQuadroFormadziDecreaseCountButton();

        Thread.sleep(300);
        Assertions.assertEquals(mainPage.getPricePerOneQuadroFormadzi() * 2, mainPage.getFullPricePerQuadroFormadzi());
    }

    @Test
    @Order(4)
    @SneakyThrows
    public void addToBasket() {
        mainPage.clickCasarioDecreaseCountButton();
        Thread.sleep(300);
        mainPage.clickCasarioDecreaseCountButton();
        Thread.sleep(300);
        mainPage.clickQuadroFormadziDecreaseCountButton();
        Thread.sleep(300);

        mainPage.clickSelectOnCasario();
        Thread.sleep(1000);
        mainPage.clickSelectOnQuadroFormadzi();
        Thread.sleep(1000);

        Assertions.assertEquals(mainPage.getTotalPrice(), mainPage.getTotalPriceInBasket());
    }

    @Test
    @Order(5)
    @SneakyThrows
    public void goToBasket() {
        mainPage.clickOnBasket();
        Thread.sleep(2000);
        alertPage.clickNoButton();
        Thread.sleep(300);
        Assertions.assertEquals(OrderPage.TEXT_FROM_PAGE, orderPage.getTextFromOrderPage());
    }

    @Test
    @Order(6)
    @SneakyThrows
    public void enterName() {
        orderPage.fillNameField(OrderPage.NAME);
        Assertions.assertEquals(OrderPage.NAME, orderPage.getNameFieldValue());
    }

    @Test
    @Order(7)
    @SneakyThrows
    public void enterPhone() {
        orderPage.fillPhoneField(OrderPage.PHONE);
        Assertions.assertEquals(OrderPage.FULL_PHONE, orderPage.getPhoneFieldValue());
    }

    @Test
    @Order(8)
    @SneakyThrows
    public void enterStreet() {
        orderPage.fillStreetField(OrderPage.STREET);
        Thread.sleep(300);
        orderPage.clickOnSelectedStreet();
    }

    @Test
    @Order(9)
    @SneakyThrows
    public void enterHouseNumber() {
        orderPage.fillHouseNumberField(OrderPage.HOUSE_NUMBER);
        Assertions.assertEquals(OrderPage.HOUSE_NUMBER, orderPage.getHouseNumberFieldValue());
    }

    @Test
    @Order(10)
    @SneakyThrows
    public void isGreen() {
        Thread.sleep(1000);
        Assertions.assertTrue(orderPage.isFinalTextShown());
    }
}
