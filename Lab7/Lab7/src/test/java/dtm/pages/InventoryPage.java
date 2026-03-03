package dtm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * InventoryPage - Page Object cho trang danh sách sản phẩm.
 */
public class InventoryPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By inventoryContainer = By.id("inventory_container");
    private final By inventoryItems     = By.cssSelector(".inventory_item");
    private final By sortDropdown       = By.cssSelector("[data-test='product-sort-container']");
    private final By cartBadge          = By.cssSelector(".shopping_cart_badge");
    private final By cartLink           = By.cssSelector(".shopping_cart_link");
    private final By productNames       = By.cssSelector(".inventory_item_name");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Kiểm tra trang inventory đã tải */
    public boolean trangDaTai() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Lấy danh sách tên sản phẩm */
    public List<String> layDanhSachTenSanPham() {
        return driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /** Thêm sản phẩm vào giỏ hàng theo tên */
    public void themVaoGioHang(String tenSanPham) {
        List<WebElement> items = driver.findElements(inventoryItems);
        for (WebElement item : items) {
            String name = item.findElement(By.cssSelector(".inventory_item_name")).getText();
            if (name.equalsIgnoreCase(tenSanPham)) {
                item.findElement(By.cssSelector("button")).click();
                return;
            }
        }
        throw new RuntimeException("Không tìm thấy sản phẩm: " + tenSanPham);
    }

    /** Lấy số lượng trong badge giỏ hàng */
    public int laySoLuongGioHang() {
        try {
            return Integer.parseInt(driver.findElement(cartBadge).getText());
        } catch (Exception e) {
            return 0;
        }
    }

    /** Click vào giỏ hàng */
    public CartPage moGioHang() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }

    /** Sắp xếp sản phẩm */
    public void sapXep(String option) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(option);
    }

    /** Tìm kiếm sản phẩm theo tên (lọc phía client) */
    public List<String> timKiemSanPham(String tuKhoa) {
        return layDanhSachTenSanPham().stream()
                .filter(name -> name.toLowerCase().contains(tuKhoa.toLowerCase()))
                .collect(Collectors.toList());
    }

    /** Click vào tên sản phẩm để xem chi tiết */
    public void xemChiTietSanPham(String tenSanPham) {
        driver.findElements(productNames).stream()
                .filter(el -> el.getText().equalsIgnoreCase(tenSanPham))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Không tìm thấy: " + tenSanPham))
                .click();
    }
}
