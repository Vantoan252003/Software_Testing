package dtm.tests;

import dtm.base.BaseTest;
import dtm.data.DangNhapData;
import dtm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC_DangNhapTest - kiểm thử hộp đen chức năng đăng nhập.
 */
public class TC_DangNhapTest extends BaseTest {

    // ─── TC01: Đăng nhập thành công ───────────────────────────────────────
    @Test(groups = {"smoke", "regression"},
          dataProvider = "dangNhapHopLe",
          dataProviderClass = DangNhapData.class,
          description = "TC01 - Đăng nhập thành công với tài khoản hợp lệ")
    public void TC01_DangNhapThanhCong(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.dangNhap(username, password);

        Assert.assertTrue(loginPage.dangNhapThanhCong(),
                "Kỳ vọng: chuyển tới trang inventory. Thực tế: URL = " + driver.getCurrentUrl());
    }

    // ─── TC02: Đăng nhập với nhiều bộ dữ liệu (valid + invalid) ──────────
    @Test(groups = {"regression"},
          dataProvider = "dangNhapData",
          dataProviderClass = DangNhapData.class,
          description = "TC02 - Đăng nhập với nhiều bộ dữ liệu khác nhau")
    public void TC02_DangNhapNhieuBoData(String username, String password,
                                         boolean isValid, String moTa) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.dangNhap(username, password);

        if (isValid) {
            Assert.assertTrue(loginPage.dangNhapThanhCong(),
                    "[" + moTa + "] Kỳ vọng đăng nhập thành công");
        } else {
            Assert.assertTrue(loginPage.coThongBaoLoi(),
                    "[" + moTa + "] Kỳ vọng có thông báo lỗi");
        }
    }

    // ─── TC03: Tài khoản bị khoá ──────────────────────────────────────────
    @Test(groups = {"regression"},
          description = "TC03 - Tài khoản bị khoá hiển thị lỗi phù hợp")
    public void TC03_TaiKhoanBiKhoa() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.dangNhap("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.coThongBaoLoi(), "Kỳ vọng: hiển thị lỗi khoá tài khoản");
        Assert.assertTrue(loginPage.layThongBaoLoi().toLowerCase().contains("locked"),
                "Kỳ vọng: nội dung lỗi chứa 'locked'");
    }

    // ─── TC04: Sai mật khẩu ───────────────────────────────────────────────
    @Test(groups = {"regression"},
          description = "TC04 - Sai mật khẩu hiển thị thông báo lỗi")
    public void TC04_SaiMatKhau() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.dangNhap("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.coThongBaoLoi(), "Kỳ vọng: hiển thị thông báo lỗi");
    }

    // ─── TC05: Để trống username ──────────────────────────────────────────
    @Test(groups = {"regression"},
          description = "TC05 - Để trống username")
    public void TC05_TrongUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.dangNhap("", "secret_sauce");

        Assert.assertTrue(loginPage.coThongBaoLoi(), "Kỳ vọng: hiển thị lỗi khi username trống");
    }

    // ─── TC06: Để trống password ──────────────────────────────────────────
    @Test(groups = {"regression"},
          description = "TC06 - Để trống password")
    public void TC06_TrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.dangNhap("standard_user", "");

        Assert.assertTrue(loginPage.coThongBaoLoi(), "Kỳ vọng: hiển thị lỗi khi password trống");
    }
}
