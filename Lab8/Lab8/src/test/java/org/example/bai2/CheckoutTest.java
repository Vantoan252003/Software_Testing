package org.example.bai2;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

@Feature("Bai 2 - Checkout Tests")
public class CheckoutTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver("chrome");
        WebDriver d = DriverFactory.getDriver();
        d.get("https://www.saucedemo.com");
        d.findElement(By.id("user-name")).sendKeys("standard_user");
        d.findElement(By.id("password")).sendKeys("secret_sauce");
        d.findElement(By.id("login-button")).click();
        new WebDriverWait(d, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("/inventory.html"));
        d.findElement(By.cssSelector(".btn_inventory")).click();
        d.findElement(By.cssSelector(".shopping_cart_link")).click();
    }

    @AfterMethod
    public void tearDown() { DriverFactory.quitDriver(); }

    @Test(groups = {"smoke"})
    @Story("Mo trang checkout")
    @Severity(SeverityLevel.CRITICAL)
    public void testOpenCheckout() {
        WebDriver d = DriverFactory.getDriver();
        d.findElement(By.id("checkout")).click();
        new WebDriverWait(d, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("/checkout-step-one.html"));
        Assert.assertTrue(d.getCurrentUrl().contains("/checkout-step-one.html"));
    }

    @Test(groups = {"regression"})
    @Story("Dien form checkout")
    @Severity(SeverityLevel.NORMAL)
    public void testFillCheckoutForm() {
        WebDriver d = DriverFactory.getDriver();
        d.findElement(By.id("checkout")).click();
        new WebDriverWait(d, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("/checkout-step-one.html"));
        d.findElement(By.id("first-name")).sendKeys("John");
        d.findElement(By.id("last-name")).sendKeys("Doe");
        d.findElement(By.id("postal-code")).sendKeys("12345");
        d.findElement(By.id("continue")).click();
        new WebDriverWait(d, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("/checkout-step-two.html"));
        Assert.assertTrue(d.getCurrentUrl().contains("/checkout-step-two.html"));
    }
}
