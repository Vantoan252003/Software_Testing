package org.example.bai6;

/**
 * Bai 6.1 - TDD: Kiem tra so dien thoai Viet Nam hop le.
 * Quy tac: bat dau 0 hoac +84; sau chuan hoa bat dau 03x/05x/07x/08x/09x; tong 10 chu so.
 */
public class PhoneValidator {
    public static boolean isValid(String phone) {
        if (phone == null || phone.isBlank()) return false;
        String n = phone.trim();
        if (n.startsWith("+84")) n = "0" + n.substring(3);
        return n.matches("^0[35789]\\d{8}$");
    }
}
