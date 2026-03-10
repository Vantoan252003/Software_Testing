package org.example.bai1;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Bài 1.2 - Kiểm thử form đăng nhập saucedemo.com với 5 kịch bản
 */
@Feature("Bai 1.2 - Login Test")
public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void login(String username, String password) {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    @Story("Dang nhap thanh cong")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Dang nhap voi standard_user/secret_sauce - phai chuyen toi /inventory.html")
    public void testLoginSuccess() {
        login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),
                "Dang nhap thanh cong nhung URL khong chuyen toi /inventory.html");
    }

    @Test
    @Story("Dang nhap sai mat khau")
    @Severity(SeverityLevel.NORMAL)
    @Description("Dang nhap voi mat khau sai - phai hien thong bao loi")
    public void testLoginWrongPassword() {
        login("standard_user", "wrongpass");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container")));
        String errorText = driver.findElement(By.cssSelector(".error-message-container")).getText();
        Assert.assertFalse(errorText.isEmpty(), "Dang nhap sai mat khau nhung khong hien thong bao loi");
    }

    @Test
    @Story("Dang nhap ten dang nhap trong")
    @Severity(SeverityLevel.NORMAL)
    @Description("Dang nhap voi username rong - phai hien 'Epic sadface: Username is required'")
    public void testLoginEmptyUsername() {
        login("", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String errorText = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(errorText.contains("Username is required"),
                "Thong bao loi khong chua 'Username is required', actual: " + errorText);
    }

    @Test
    @Story("Dang nhap mat khau trong")
    @Severity(SeverityLevel.NORMAL)
    @Description("Dang nhap voi password rong - phai hien 'Epic sadface: Password is required'")
    public void testLoginEmptyPassword() {
        login("standard_user", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String errorText = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(errorText.contains("Password is required"),
                "Thong bao loi khong chua 'Password is required', actual: " + errorText);
    }

    @Test
    @Story("Dang nhap tai khoan bi khoa")
    @Severity(SeverityLevel.NORMAL)
    @Description("Dang nhap voi locked_out_user - phai hien thong bao bi khoa")
    public void testLoginLockedUser() {
        login("locked_out_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String errorText = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(errorText.contains("Sorry, this user has been locked out"),
                "Thong bao loi khong chua 'locked out', actual: " + errorText);
    }
}
