package dtm.data;

import org.testng.annotations.DataProvider;

/**
 * DangNhapData - cung cấp dữ liệu test cho chức năng đăng nhập.
 */
public class DangNhapData {

    /**
     * Dữ liệu đăng nhập hợp lệ và không hợp lệ.
     * Cột: { username, password, isValid, moTa }
     */
    @DataProvider(name = "dangNhapData")
    public static Object[][] dangNhapData() {
        return new Object[][] {
            // Tài khoản hợp lệ
            { "standard_user",       "secret_sauce", true,  "Đăng nhập thành công - standard_user" },
            { "problem_user",        "secret_sauce", true,  "Đăng nhập thành công - problem_user" },
            { "performance_glitch_user", "secret_sauce", true, "Đăng nhập thành công - performance_glitch_user" },

            // Tài khoản bị khoá
            { "locked_out_user",     "secret_sauce", false, "Tài khoản bị khoá" },

            // Sai mật khẩu
            { "standard_user",       "wrong_pass",   false, "Sai mật khẩu" },

            // Tên đăng nhập trống
            { "",                    "secret_sauce", false, "Username trống" },

            // Mật khẩu trống
            { "standard_user",       "",             false, "Password trống" },

            // Cả hai trống
            { "",                    "",             false, "Username và password đều trống" },
        };
    }

    /**
     * Chỉ dữ liệu đăng nhập hợp lệ (dùng cho smoke test).
     */
    @DataProvider(name = "dangNhapHopLe")
    public static Object[][] dangNhapHopLe() {
        return new Object[][] {
            { "standard_user", "secret_sauce" },
        };
    }
}
