package dtm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * LoginPage - Page Object cho trang đăng nhập SauceDemo.
 */
public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Nhập username */
    public LoginPage nhapUsername(String username) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        el.clear();
        el.sendKeys(username);
        return this;
    }

    /** Nhập password */
    public LoginPage nhapPassword(String password) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        el.clear();
        el.sendKeys(password);
        return this;
    }

    /** Nhấn nút Login */
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /** Đăng nhập đầy đủ (username + password + click) */
    public void dangNhap(String username, String password) {
        nhapUsername(username);
        nhapPassword(password);
        clickLogin();
    }

    /** Kiểm tra thông báo lỗi có hiển thị không */
    public boolean coThongBaoLoi() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /** Lấy nội dung thông báo lỗi */
    public String layThongBaoLoi() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    /** Kiểm tra đã đăng nhập thành công (redirect sang /inventory.html) */
    public boolean dangNhapThanhCong() {
        try {
            wait.until(ExpectedConditions.urlContains("inventory"));
            return driver.getCurrentUrl().contains("inventory");
        } catch (Exception e) {
            return false;
        }
    }
}
