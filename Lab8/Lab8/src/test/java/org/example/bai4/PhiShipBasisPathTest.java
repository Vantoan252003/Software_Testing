package org.example.bai4;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Bai 4.2 - TestNG Basis Path Test cho ham tinhPhiShip (8 paths)
 */
@Feature("Bai 4.2 - PhiShip Basis Path Testing")
public class PhiShipBasisPathTest {

    @Test(description = "Path1: weight <= 0 -> IllegalArgumentException")
    @Story("Path 1 - Can nang khong hop le")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath1_InvalidWeight() {
        Assert.assertThrows(IllegalArgumentException.class,
            () -> PhiShip.tinhPhiShip(-1, "noi_thanh", false));
    }

    @Test(description = "Path2: noi_thanh, <=5kg, khong member -> 15000")
    @Story("Path 2 - Noi thanh nhe khong member")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath2_NoiThanh_Nhe_KhongMember() {
        Assert.assertEquals(PhiShip.tinhPhiShip(3, "noi_thanh", false), 15000.0, 0.01);
    }

    @Test(description = "Path3: noi_thanh, >5kg, khong member -> 21000")
    @Story("Path 3 - Noi thanh nang khong member")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath3_NoiThanh_Nang_KhongMember() {
        Assert.assertEquals(PhiShip.tinhPhiShip(8, "noi_thanh", false), 21000.0, 0.01);
    }

    @Test(description = "Path4: ngoai_thanh, <=5kg, khong member -> 25000")
    @Story("Path 4 - Ngoai thanh nhe khong member")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath4_NgoaiThanh_Nhe_KhongMember() {
        Assert.assertEquals(PhiShip.tinhPhiShip(2, "ngoai_thanh", false), 25000.0, 0.01);
    }

    @Test(description = "Path5: ngoai_thanh, >5kg, khong member -> 34000")
    @Story("Path 5 - Ngoai thanh nang khong member")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath5_NgoaiThanh_Nang_KhongMember() {
        Assert.assertEquals(PhiShip.tinhPhiShip(6, "ngoai_thanh", false), 34000.0, 0.01);
    }

    @Test(description = "Path6: tinh_khac, <=5kg, khong member -> 50000")
    @Story("Path 6 - Tinh khac nhe khong member")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath6_TinhKhac_Nhe_KhongMember() {
        Assert.assertEquals(PhiShip.tinhPhiShip(1, "tinh_khac", false), 50000.0, 0.01);
    }

    @Test(description = "Path7: tinh_khac, >5kg, khong member -> 65000")
    @Story("Path 7 - Tinh khac nang khong member")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath7_TinhKhac_Nang_KhongMember() {
        Assert.assertEquals(PhiShip.tinhPhiShip(10, "tinh_khac", false), 65000.0, 0.01);
    }

    @Test(description = "Path8: noi_thanh, <=5kg, co member -> 13500 (giam 10%)")
    @Story("Path 8 - Noi thanh nhe co member")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath8_NoiThanh_Nhe_Member() {
        Assert.assertEquals(PhiShip.tinhPhiShip(3, "noi_thanh", true), 13500.0, 0.01);
    }
}
