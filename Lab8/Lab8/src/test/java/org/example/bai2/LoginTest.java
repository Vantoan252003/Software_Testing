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

/**
 * Bài 2.1 / 2.2 - LoginTest phân nhóm smoke/regression, hỗ trợ song song
 */
@Feature("Bai 2 - Login Tests")
public class LoginTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver("chrome");
        DriverFactory.getDriver().get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test(groups = {"smoke"}, description = "Dang nhap thanh cong - smoke test")
    @Story("Dang nhap thanh cong")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginSuccess() {
        WebDriver driver = DriverFactory.getDriver();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),
                "Dang nhap thanh cong nhung URL sai");
    }

    @Test(groups = {"regression"}, description = "Dang nhap sai mat khau - regression test")
    @Story("Dang nhap sai mat khau")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWrongPassword() {
        WebDriver driver = DriverFactory.getDriver();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertFalse(error.isEmpty(), "Khong hien loi khi sai mat khau");
    }
}
