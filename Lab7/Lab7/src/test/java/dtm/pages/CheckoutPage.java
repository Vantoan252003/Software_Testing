package dtm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * CheckoutPage - Page Object cho các bước thanh toán.
 */
public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators - Step 1 (thông tin người mua)
    private final By firstNameField  = By.id("first-name");
    private final By lastNameField   = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton  = By.id("continue");
    private final By errorMessage    = By.cssSelector("[data-test='error']");

    // Locators - Step 2 (tổng quan đơn hàng)
    private final By summaryContainer   = By.id("checkout_summary_container");
    private final By finishButton       = By.id("finish");
    private final By itemTotalLabel     = By.cssSelector(".summary_subtotal_label");
    private final By taxLabel           = By.cssSelector(".summary_tax_label");
    private final By totalLabel         = By.cssSelector(".summary_total_label");

    // Locators - Step 3 (hoàn tất)
    private final By completeContainer  = By.id("checkout_complete_container");
    private final By completeHeader     = By.cssSelector(".complete-header");
    private final By backHomeButton     = By.id("back-to-products");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ───── Step 1 ─────

    /** Điền thông tin người mua */
    public CheckoutPage dienThongTin(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        return this;
    }

    /** Nhấn Continue */
    public CheckoutPage tiepTuc() {
        driver.findElement(continueButton).click();
        return this;
    }

    /** Kiểm tra thông báo lỗi Step 1 */
    public boolean coLoi() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String layThongBaoLoi() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    // ───── Step 2 ─────

    /** Kiểm tra trang tổng quan đã tải */
    public boolean trangTongQuanDaTai() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(summaryContainer));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Lấy text tổng tiền hàng */
    public String layItemTotal() {
        return driver.findElement(itemTotalLabel).getText();
    }

    /** Lấy text thuế */
    public String layTax() {
        return driver.findElement(taxLabel).getText();
    }

    /** Lấy text tổng cộng */
    public String layTotal() {
        return driver.findElement(totalLabel).getText();
    }

    /** Nhấn Finish */
    public CheckoutPage hoanTat() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
        return this;
    }

    // ───── Step 3 ─────

    /** Kiểm tra đặt hàng thành công */
    public boolean datHangThanhCong() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(completeContainer));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Lấy tiêu đề hoàn tất */
    public String layTieuDeHoanTat() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).getText();
    }

    /** Quay về trang chủ */
    public InventoryPage quayVeTrangChu() {
        driver.findElement(backHomeButton).click();
        return new InventoryPage(driver);
    }
}
