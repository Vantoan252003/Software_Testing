package dtm.tests;

import dtm.base.BaseTest;
import dtm.pages.InventoryPage;
import dtm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * TC_TimKiemTest - kiểm thử hộp đen chức năng tìm kiếm / sắp xếp sản phẩm.
 */
public class TC_TimKiemTest extends BaseTest {

    private InventoryPage inventoryPage;

    @BeforeMethod
    public void dangNhap() {
        new LoginPage(driver).dangNhap("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(driver);
    }

    // ─── DataProvider ─────────────────────────────────────────────────────
    @DataProvider(name = "sapXepData")
    public Object[][] sapXepData() {
        return new Object[][] {
            { "Name (A to Z)",  true  },   // tăng dần
            { "Name (Z to A)",  false },   // giảm dần
            { "Price (low to high)", true  },
            { "Price (high to low)", false },
        };
    }

    @DataProvider(name = "timKiemData")
    public Object[][] timKiemData() {
        return new Object[][] {
            { "sauce",  true  },   // có kết quả
            { "backpack", true  },
            { "xyz123notexist", false }, // không có kết quả
        };
    }

    // ─── TC01: Kiểm tra trang inventory tải đầy đủ sản phẩm ─────────────
    @Test(groups = {"smoke", "regression"},
          description = "TC01 - Trang inventory hiển thị đầy đủ 6 sản phẩm")
    public void TC01_TrangInventoryHienThiSanPham() {
        Assert.assertTrue(inventoryPage.trangDaTai(), "Kỳ vọng: trang inventory đã tải");

        List<String> danhSach = inventoryPage.layDanhSachTenSanPham();
        Assert.assertEquals(danhSach.size(), 6,
                "Kỳ vọng: có 6 sản phẩm trên trang inventory");
    }

    // ─── TC02: Sắp xếp sản phẩm ──────────────────────────────────────────
    @Test(groups = {"regression"},
          dataProvider = "sapXepData",
          description = "TC02 - Sắp xếp sản phẩm theo các tuỳ chọn")
    public void TC02_SapXepSanPham(String option, boolean tangDan) {
        inventoryPage.sapXep(option);
        List<String> danhSach = inventoryPage.layDanhSachTenSanPham();

        Assert.assertFalse(danhSach.isEmpty(), "Danh sách không được rỗng sau khi sắp xếp");

        // Kiểm tra thứ tự (chỉ áp dụng cho sort theo tên)
        if (option.contains("Name")) {
            for (int i = 0; i < danhSach.size() - 1; i++) {
                int cmp = danhSach.get(i).compareToIgnoreCase(danhSach.get(i + 1));
                if (tangDan) {
                    Assert.assertTrue(cmp <= 0,
                            "Kỳ vọng A→Z: '" + danhSach.get(i) + "' <= '" + danhSach.get(i + 1) + "'");
                } else {
                    Assert.assertTrue(cmp >= 0,
                            "Kỳ vọng Z→A: '" + danhSach.get(i) + "' >= '" + danhSach.get(i + 1) + "'");
                }
            }
        }
    }

    // ─── TC03: Lọc sản phẩm theo từ khoá ─────────────────────────────────
    @Test(groups = {"regression"},
          dataProvider = "timKiemData",
          description = "TC03 - Lọc sản phẩm theo từ khoá (phía client)")
    public void TC03_LocSanPhamTheoTuKhoa(String tuKhoa, boolean coKetQua) {
        List<String> ketQua = inventoryPage.timKiemSanPham(tuKhoa);

        if (coKetQua) {
            Assert.assertFalse(ketQua.isEmpty(),
                    "Kỳ vọng: có kết quả cho từ khoá '" + tuKhoa + "'");
            ketQua.forEach(name ->
                Assert.assertTrue(name.toLowerCase().contains(tuKhoa.toLowerCase()),
                        "Tên sản phẩm '" + name + "' phải chứa '" + tuKhoa + "'"));
        } else {
            Assert.assertTrue(ketQua.isEmpty(),
                    "Kỳ vọng: không có kết quả cho từ khoá '" + tuKhoa + "'");
        }
    }

    // ─── TC04: Xem chi tiết sản phẩm ─────────────────────────────────────
    @Test(groups = {"regression"},
          description = "TC04 - Nhấn vào tên sản phẩm để xem chi tiết")
    public void TC04_XemChiTietSanPham() {
        String sanPham = "Sauce Labs Backpack";
        inventoryPage.xemChiTietSanPham(sanPham);

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item"),
                "Kỳ vọng: URL chuyển tới trang chi tiết sản phẩm");
    }
}
