package org.example.bai6;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Bai 6.1 - PhoneValidator TDD")
public class PhoneValidatorTest {

    @Test @Story("So 09x hop le") @Severity(SeverityLevel.CRITICAL)
    public void testValid_09x() {
        Assert.assertTrue(PhoneValidator.isValid("0912345678"), "0912345678 phai hop le");
    }

    @Test @Story("So +84 hop le") @Severity(SeverityLevel.CRITICAL)
    public void testValid_Plus84() {
        Assert.assertTrue(PhoneValidator.isValid("+84912345678"), "+84912345678 phai hop le");
    }

    @Test @Story("So 03x hop le") @Severity(SeverityLevel.CRITICAL)
    public void testValid_03x() {
        Assert.assertTrue(PhoneValidator.isValid("0381234567"), "0381234567 phai hop le");
    }

    @Test @Story("Khong co dau so") @Severity(SeverityLevel.NORMAL)
    public void testInvalid_NoPrefix() {
        Assert.assertFalse(PhoneValidator.isValid("1234567890"), "1234567890 khong hop le");
    }

    @Test @Story("Chi 9 chu so") @Severity(SeverityLevel.NORMAL)
    public void testInvalid_9Digits() {
        Assert.assertFalse(PhoneValidator.isValid("091234567"), "9 so khong hop le");
    }

    @Test @Story("Co 11 chu so") @Severity(SeverityLevel.NORMAL)
    public void testInvalid_11Digits() {
        Assert.assertFalse(PhoneValidator.isValid("09123456789"), "11 so khong hop le");
    }

    @Test @Story("Dau 02x khong hop le") @Severity(SeverityLevel.NORMAL)
    public void testInvalid_02xPrefix() {
        Assert.assertFalse(PhoneValidator.isValid("0212345678"), "0212345678 khong hop le");
    }
}
