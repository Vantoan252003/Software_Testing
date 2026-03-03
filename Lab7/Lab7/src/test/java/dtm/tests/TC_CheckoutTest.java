package dtm.tests;

import dtm.base.BaseTest;
import dtm.pages.CartPage;
import dtm.pages.CheckoutPage;
import dtm.pages.InventoryPage;
import dtm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TC_CheckoutTest - kiểm thử hộp đen chức năng thanh toán.
 */
public class TC_CheckoutTest extends BaseTest {

    private InventoryPage inventoryPage;

    @BeforeMethod
    public void chuanBi() {
        new LoginPage(driver).dangNhap("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(driver);
        // Thêm sản phẩm mặc định để có hàng checkout
        inventoryPage.themVaoGioHang("Sauce Labs Backpack");
    }

    // ─── DataProvider ─────────────────────────────────────────────────────
    @DataProvider(name = "thongTinKhachHang")
    public Object[][] thongTinKhachHang() {
        return new Object[][] {
            // { firstName, lastName, postalCode, hopLe }
            { "Nguyen", "Van A",  "70000", true  },   // hợp lệ
            { "",       "Van A",  "70000", false },   // thiếu firstName
            { "Nguyen", "",       "70000", false },   // thiếu lastName
            { "Nguyen", "Van A",  "",      false },   // thiếu postalCode
        };
    }

    // ─── TC01: Checkout thành công ────────────────────────────────────────
    @Test(groups = {"smoke", "regression"},
          description = "TC01 - Quy trình checkout hoàn chỉnh thành công")
    public void TC01_CheckoutThanhCong() {
        CartPage cartPage = inventoryPage.moGioHang();
        CheckoutPage checkoutPage = cartPage.checkout();

        checkoutPage.dienThongTin("Nguyen", "Van A", "70000").tiepTuc();

        Assert.assertTrue(checkoutPage.trangTongQuanDaTai(),
                "Kỳ vọng: trang tổng quan đơn hàng đã tải");

        checkoutPage.hoanTat();

        Assert.assertTrue(checkoutPage.datHangThanhCong(),
                "Kỳ vọng: đặt hàng thành công");
        Assert.assertTrue(checkoutPage.layTieuDeHoanTat().toLowerCase().contains("thank"),
                "Kỳ vọng: tiêu đề chứa 'Thank you'");
    }

    // ─── TC02: Validate thông tin khách hàng ─────────────────────────────
    @Test(groups = {"regression"},
          dataProvider = "thongTinKhachHang",
          description = "TC02 - Kiểm tra validate form thông tin khách hàng")
    public void TC02_ValidateThongTinKhachHang(String firstName, String lastName,
                                                String postalCode, boolean hopLe) {
        CartPage cartPage = inventoryPage.moGioHang();
        CheckoutPage checkoutPage = cartPage.checkout();

        checkoutPage.dienThongTin(firstName, lastName, postalCode).tiepTuc();

        if (hopLe) {
            Assert.assertTrue(checkoutPage.trangTongQuanDaTai(),
                    "Kỳ vọng: chuyển sang trang tổng quan");
        } else {
            Assert.assertTrue(checkoutPage.coLoi(),
                    "Kỳ vọng: hiển thị lỗi validate");
        }
    }

    // ─── TC03: Kiểm tra thông tin giá trong tổng quan đơn hàng ──────────
    @Test(groups = {"regression"},
          description = "TC03 - Tổng quan đơn hàng hiển thị đầy đủ thông tin giá")
    public void TC03_KiemTraGiaTrongTongQuan() {
        CartPage cartPage = inventoryPage.moGioHang();
        CheckoutPage checkoutPage = cartPage.checkout();

        checkoutPage.dienThongTin("Nguyen", "Van A", "70000").tiepTuc();

        Assert.assertTrue(checkoutPage.trangTongQuanDaTai());
        Assert.assertFalse(checkoutPage.layItemTotal().isEmpty(),
                "Kỳ vọng: hiển thị item total");
        Assert.assertFalse(checkoutPage.layTax().isEmpty(),
                "Kỳ vọng: hiển thị tax");
        Assert.assertFalse(checkoutPage.layTotal().isEmpty(),
                "Kỳ vọng: hiển thị total");
    }

    // ─── TC04: Quay về trang inventory sau khi hoàn tất ──────────────────
    @Test(groups = {"regression"},
          description = "TC04 - Nhấn Back Home sau khi hoàn tất đơn hàng")
    public void TC04_QuayVeInventorySauHoanTat() {
        CartPage cartPage = inventoryPage.moGioHang();
        CheckoutPage checkoutPage = cartPage.checkout();

        checkoutPage.dienThongTin("Nguyen", "Van A", "70000").tiepTuc().hoanTat();

        Assert.assertTrue(checkoutPage.datHangThanhCong());

        InventoryPage backPage = checkoutPage.quayVeTrangChu();
        Assert.assertTrue(backPage.trangDaTai(),
                "Kỳ vọng: quay lại trang inventory thành công");
    }

    // ─── TC05: Checkout giỏ hàng nhiều sản phẩm ──────────────────────────
    @Test(groups = {"regression"},
          description = "TC05 - Checkout với nhiều sản phẩm trong giỏ")
    public void TC05_CheckoutNhieuSanPham() {
        inventoryPage.themVaoGioHang("Sauce Labs Bike Light");
        inventoryPage.themVaoGioHang("Sauce Labs Bolt T-Shirt");

        CartPage cartPage = inventoryPage.moGioHang();
        Assert.assertEquals(cartPage.demSoSanPham(), 3,
                "Kỳ vọng: 3 sản phẩm trong giỏ");

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.dienThongTin("Nguyen", "Van B", "70000").tiepTuc().hoanTat();

        Assert.assertTrue(checkoutPage.datHangThanhCong(),
                "Kỳ vọng: đặt hàng thành công với nhiều sản phẩm");
    }
}
