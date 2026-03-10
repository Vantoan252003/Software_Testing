package org.example.bai1;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Bài 1.1 - Kiểm thử tiêu đề và URL trang https://www.saucedemo.com
 */
@Feature("Bai 1.1 - Title & URL Test")
public class TitleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Story("Kiem thu tieu de trang")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kiem tra title cua trang saucedemo.com phai la 'Swag Labs'")
    public void testTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "Title trang khong dung, expected: Swag Labs");
    }

    @Test
    @Story("Kiem thu URL trang")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kiem tra URL trang phai chua 'saucedemo'")
    public void testURL() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("saucedemo"), "URL khong chua 'saucedemo', actual URL: " + url);
    }

    @Test
    @Story("Kiem thu page source")
    @Severity(SeverityLevel.MINOR)
    @Description("Kiem tra page source phai chua the form")
    public void testPageSource() {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("<form"), "Page source khong chua the <form>");
    }

    @Test
    @Story("Kiem thu form dang nhap hien thi")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kiem tra form dang nhap co hien thi tren trang")
    public void testFormDisplayed() {
        boolean displayed = driver.findElement(By.id("login-button")).isDisplayed();
        Assert.assertTrue(displayed, "Form dang nhap (login-button) khong hien thi");
    }
}
