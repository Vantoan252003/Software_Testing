package dtm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CartPage - Page Object cho trang giỏ hàng.
 */
public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By cartContainer      = By.id("cart_contents_container");
    private final By cartItems          = By.cssSelector(".cart_item");
    private final By checkoutButton     = By.id("checkout");
    private final By continueShoppingBtn = By.id("continue-shopping");
    private final By cartItemNames      = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Kiểm tra trang giỏ hàng đã tải */
    public boolean trangDaTai() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartContainer));
            return driver.getCurrentUrl().contains("cart");
        } catch (Exception e) {
            return false;
        }
    }

    /** Lấy danh sách tên sản phẩm trong giỏ */
    public List<String> layDanhSachSanPhamTrongGio() {
        return driver.findElements(cartItemNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /** Đếm số sản phẩm trong giỏ */
    public int demSoSanPham() {
        return driver.findElements(cartItems).size();
    }

    /** Xoá sản phẩm khỏi giỏ hàng theo tên */
    public void xoaSanPham(String tenSanPham) {
        List<WebElement> items = driver.findElements(cartItems);
        for (WebElement item : items) {
            String name = item.findElement(By.cssSelector(".inventory_item_name")).getText();
            if (name.equalsIgnoreCase(tenSanPham)) {
                item.findElement(By.cssSelector("button[id^='remove']")).click();
                return;
            }
        }
        throw new RuntimeException("Không tìm thấy sản phẩm trong giỏ: " + tenSanPham);
    }

    /** Nhấn nút Checkout */
    public CheckoutPage checkout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        return new CheckoutPage(driver);
    }

    /** Tiếp tục mua sắm */
    public InventoryPage tiepTucMuaSam() {
        driver.findElement(continueShoppingBtn).click();
        return new InventoryPage(driver);
    }
}
