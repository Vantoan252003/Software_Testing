package dtm.data;

import org.testng.annotations.DataProvider;

/**
 * GioHangData - cung cấp dữ liệu test cho chức năng giỏ hàng.
 */
public class GioHangData {

    /**
     * Dữ liệu thêm sản phẩm vào giỏ hàng.
     * Cột: { tenSanPham, soLuongMongDoi }
     */
    @DataProvider(name = "themGioHangData")
    public static Object[][] themGioHangData() {
        return new Object[][] {
            { "Sauce Labs Backpack",          1 },
            { "Sauce Labs Bike Light",        1 },
            { "Sauce Labs Bolt T-Shirt",      1 },
            { "Sauce Labs Fleece Jacket",     1 },
            { "Sauce Labs Onesie",            1 },
            { "Test.allTheThings() T-Shirt (Red)", 1 },
        };
    }

    /**
     * Dữ liệu xoá sản phẩm khỏi giỏ hàng.
     * Cột: { tenSanPham }
     */
    @DataProvider(name = "xoaGioHangData")
    public static Object[][] xoaGioHangData() {
        return new Object[][] {
            { "Sauce Labs Backpack" },
            { "Sauce Labs Bike Light" },
        };
    }

    /**
     * Dữ liệu thêm nhiều sản phẩm cùng lúc.
     * Cột: { danhSachSanPham (mảng tên), tongSoLuongMongDoi }
     */
    @DataProvider(name = "nhieuSanPhamData")
    public static Object[][] nhieuSanPhamData() {
        return new Object[][] {
            { new String[] { "Sauce Labs Backpack", "Sauce Labs Bike Light" }, 2 },
            { new String[] { "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie" }, 3 },
        };
    }
}
