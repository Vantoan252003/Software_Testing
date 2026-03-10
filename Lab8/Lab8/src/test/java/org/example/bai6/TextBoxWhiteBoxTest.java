package org.example.bai6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Bai 6.2 - TextBox WhiteBox + POM")
public class TextBoxWhiteBoxTest {
    private WebDriver driver;
    private TextBoxPage page;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(opts);
        page = new TextBoxPage(driver);
        page.navigate();
    }

    @AfterMethod
    public void tearDown() { if (driver != null) driver.quit(); }

    @Test @Story("Input hop le") @Severity(SeverityLevel.CRITICAL)
    @Description("John + john@email.com + 123 Street -> output hien thi")
    public void testValidInput() {
        page.fillAndSubmit("John", "john@email.com", "123 Street");
        Assert.assertTrue(page.isOutputDisplayed(), "Output phai hien thi");
        Assert.assertTrue(page.getOutputName().contains("John"), "Output phai chua ten");
    }

    @Test @Story("Email sai dinh dang") @Severity(SeverityLevel.NORMAL)
    @Description("notanemail -> output KHONG hien thi")
    public void testInvalidEmail() {
        page.fillAndSubmit("John", "notanemail", "123 Street");
        Assert.assertFalse(page.isOutputDisplayed(), "Output khong hien thi voi email sai");
    }

    @Test @Story("Ten rong") @Severity(SeverityLevel.NORMAL)
    @Description("Ten rong -> name output rong")
    public void testEmptyName() {
        page.fillAndSubmit("", "john@email.com", "123 Street");
        String name = page.getOutputName();
        Assert.assertTrue(name == null || name.isEmpty(),
            "Output name phai rong khi khong nhap ten");
    }

    @Test @Story("Khoang trang") @Severity(SeverityLevel.NORMAL)
    @Description("Toan khoang trang -> output KHONG hien thi")
    public void testWhitespaceInput() {
        page.fillAndSubmit("   ", "   ", "   ");
        Assert.assertFalse(page.isOutputDisplayed(), "Output khong hien thi voi khoang trang");
    }
}
