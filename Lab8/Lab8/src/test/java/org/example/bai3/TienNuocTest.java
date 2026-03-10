package org.example.bai3;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Bai 3.2 - TestNG 100% Branch Coverage cho ham tinhTienNuoc
 * TC1: (0,  ho_ngheo)   -> 0
 * TC2: (5,  ho_ngheo)   -> 25000
 * TC3: (8,  dan_cu)     -> 60000
 * TC4: (15, dan_cu)     -> 148500
 * TC5: (25, dan_cu)     -> 285000
 * TC6: (3,  kinh_doanh) -> 66000
 */
@Feature("Bai 3.2 - TienNuoc Branch Coverage")
public class TienNuocTest {

    @Test
    @Story("TC1 - So m3 bang 0")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC1: soM3=0, ho_ngheo -> 0 dong")
    public void testSoM3_Zero() {
        Assert.assertEquals(TienNuoc.tinhTienNuoc(0, "ho_ngheo"), 0.0, 0.01);
    }

    @Test
    @Story("TC2 - Ho ngheo 5m3")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC2: soM3=5, ho_ngheo -> 25000 dong")
    public void testHoNgheo() {
        Assert.assertEquals(TienNuoc.tinhTienNuoc(5, "ho_ngheo"), 25000.0, 0.01);
    }

    @Test
    @Story("TC3 - Dan cu duoi 10m3")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC3: soM3=8, dan_cu -> 60000 dong")
    public void testDanCuDuoi10() {
        Assert.assertEquals(TienNuoc.tinhTienNuoc(8, "dan_cu"), 60000.0, 0.01);
    }

    @Test
    @Story("TC4 - Dan cu 10 den 20m3")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC4: soM3=15, dan_cu -> 148500 dong")
    public void testDanCu10Den20() {
        Assert.assertEquals(TienNuoc.tinhTienNuoc(15, "dan_cu"), 148500.0, 0.01);
    }

    @Test
    @Story("TC5 - Dan cu tren 20m3")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC5: soM3=25, dan_cu -> 285000 dong")
    public void testDanCuTren20() {
        Assert.assertEquals(TienNuoc.tinhTienNuoc(25, "dan_cu"), 285000.0, 0.01);
    }

    @Test
    @Story("TC6 - Kinh doanh 3m3")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC6: soM3=3, kinh_doanh -> 66000 dong")
    public void testKinhDoanh() {
        Assert.assertEquals(TienNuoc.tinhTienNuoc(3, "kinh_doanh"), 66000.0, 0.01);
    }
}
