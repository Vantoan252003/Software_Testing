package dtm.tests;

import dtm.base.BaseTest;
import dtm.data.GioHangData;
import dtm.pages.CartPage;
import dtm.pages.InventoryPage;
import dtm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * TC_GioHangTest - kiểm thử hộp đen chức năng giỏ hàng.
 */
public class TC_GioHangTest extends BaseTest {

    private InventoryPage inventoryPage;

    /** Đăng nhập trước mỗi test */
    @BeforeMethod
    public void dangNhap() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.dangNhap("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(driver);
    }

    // ─── TC01: Thêm 1 sản phẩm vào giỏ ──────────────────────────────────
    @Test(groups = {"smoke", "regression"},
          dataProvider = "themGioHangData",
          dataProviderClass = GioHangData.class,
          description = "TC01 - Thêm từng sản phẩm vào giỏ hàng")
    public void TC01_ThemMotSanPhamVaoGio(String tenSanPham, int soLuongMongDoi) {
        inventoryPage.themVaoGioHang(tenSanPham);

        Assert.assertEquals(inventoryPage.laySoLuongGioHang(), soLuongMongDoi,
                "Kỳ vọng badge giỏ hàng = " + soLuongMongDoi);
    }

    // ─── TC02: Kiểm tra sản phẩm đã thêm xuất hiện trong giỏ ────────────
    @Test(groups = {"regression"},
          description = "TC02 - Sản phẩm thêm vào giỏ xuất hiện trong trang cart")
    public void TC02_SanPhamXuatHienTrongGio() {
        String sanPham = "Sauce Labs Backpack";
        inventoryPage.themVaoGioHang(sanPham);

        CartPage cartPage = inventoryPage.moGioHang();
        Assert.assertTrue(cartPage.trangDaTai(), "Kỳ vọng: trang giỏ hàng đã tải");
        Assert.assertTrue(cartPage.layDanhSachSanPhamTrongGio().contains(sanPham),
                "Kỳ vọng: '" + sanPham + "' có trong giỏ hàng");
    }

    // ─── TC03: Thêm nhiều sản phẩm cùng lúc ─────────────────────────────
    @Test(groups = {"regression"},
          dataProvider = "nhieuSanPhamData",
          dataProviderClass = GioHangData.class,
          description = "TC03 - Thêm nhiều sản phẩm và kiểm tra tổng số lượng")
    public void TC03_ThemNhieuSanPham(String[] danhSach, int tongMongDoi) {
        for (String sp : danhSach) {
            inventoryPage.themVaoGioHang(sp);
        }
        Assert.assertEquals(inventoryPage.laySoLuongGioHang(), tongMongDoi,
                "Kỳ vọng badge = " + tongMongDoi);
    }

    // ─── TC04: Xoá sản phẩm khỏi giỏ hàng ───────────────────────────────
    @Test(groups = {"regression"},
          dataProvider = "xoaGioHangData",
          dataProviderClass = GioHangData.class,
          description = "TC04 - Xoá sản phẩm khỏi giỏ hàng")
    public void TC04_XoaSanPhamKhoiGio(String tenSanPham) {
        inventoryPage.themVaoGioHang(tenSanPham);
        CartPage cartPage = inventoryPage.moGioHang();

        int truoc = cartPage.demSoSanPham();
        cartPage.xoaSanPham(tenSanPham);
        int sau = cartPage.demSoSanPham();

        Assert.assertEquals(sau, truoc - 1,
                "Kỳ vọng: số sản phẩm giảm 1 sau khi xoá");
        Assert.assertFalse(cartPage.layDanhSachSanPhamTrongGio().contains(tenSanPham),
                "Kỳ vọng: '" + tenSanPham + "' đã bị xoá khỏi giỏ");
    }

    // ─── TC05: Giỏ hàng trống khi chưa thêm sản phẩm ────────────────────
    @Test(groups = {"regression"},
          description = "TC05 - Giỏ hàng trống khi chưa thêm sản phẩm")
    public void TC05_GioHangTrong() {
        CartPage cartPage = inventoryPage.moGioHang();
        Assert.assertEquals(cartPage.demSoSanPham(), 0,
                "Kỳ vọng: giỏ hàng trống");
    }
}
