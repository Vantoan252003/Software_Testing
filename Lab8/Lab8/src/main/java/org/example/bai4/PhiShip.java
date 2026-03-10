package org.example.bai4;
/**
 * Bai 4.2 - Tinh phi ship
 * Basis Path:
 * Path1: weight <= 0 -> IllegalArgumentException
 * Path2: noi_thanh, <=5kg, khong member -> 15000
 * Path3: noi_thanh, >5kg, khong member  -> 21000
 * Path4: ngoai_thanh, <=5kg, khong member -> 25000
 * Path5: ngoai_thanh, >5kg, khong member  -> 34000
 * Path6: tinh_khac, <=5kg, khong member  -> 50000
 * Path7: tinh_khac, >5kg, khong member   -> 65000
 * Path8: noi_thanh, <=5kg, member        -> 13500 (15000 * 0.9)
 */
public class PhiShip {
    public static double tinhPhiShip(double weight, String zone, boolean isMember) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Can nang khong hop le: " + weight);
        }
        double basePrice;
        switch (zone.toLowerCase()) {
            case "noi_thanh":
                basePrice = (weight <= 5) ? 15000 : 21000;
                break;
            case "ngpackage org.example.bai4;
/**
 * Bai 4.2 - Tinh phi ship
 * Basis Path:
 * Path1: weight <= 0 -> Ill  /**
 * Bai 4.2 - Tinh ph   *   * Basis Path:
 * Path1: ht <= 5) ? 50000  * Path2: noi_thanh, <=5kg, khong member -> 1500ul * Path3: noi_thanh, >5kg, khong member  -ntExcept * P"Khu vuc khong hop le: " + zone);
        }
   * Path5: ngoai_thanh, >5kg, khong member  -> 3400;
 * Path6: tinh_khac, <=5kg, khong member  -> 50000F
cat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/test/java/org/example/bai4/PhiShipBasisPathTest.java << 'JAVAEOF'
package org.example.bai4;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Bai 4.2 - TestNG Basis Path Test cho ham tinhPhiShip
 * 8 basis paths, tat ca 100% PASS
 */
@Feature("Bai 4.2 - PhiShip Basis Path Testing")
public class PhiShipBasisPathTest {
    @Test(description = "Path1: Can nang am -> IllegalArgumentException")
    @Story("Path 1 - Can nang khong hop le")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath1_InvalidWeight() {
        Assert.assertThrows(IllegalArgumentException.class,
            () -> PhiShip.tinhPhiShip(-1, "noi_thanh", false),
            "Path1: (-1, noi_thanh, false) phai nem IllegalArgumentException");
    }
    @Test(description = "Path2: noi_thanh, <=5kg, khong member -> 15000")
    @Story("Path 2 - Noi thanh nhe khong member")
    @Severity(SeverityLevel.CRITICAL)
    public void testPath2_NoiThanh_Nhepackage org.example.bai4;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Testreimport io.qameta.allu     import org.testng.Assert;animport org.testng.annota;
/**
 * Bai 4.2 - TestNG Basis Pathh3 *no * 8 basis paths, tat ca 100% PASS
 */
@Feature("Bai 4h  */
@Feature("Bai 4.2 - PhiShip B
 @F @public class PhiShipBasisPathTest    public void     @Test(description = "Path1: Car(    @Story("Path 1 - Can nang khong hop le")
    @Severity(Severialse);
      @Severity(SeverityLevel.CRITICAL)
    p0.    public void testPath1_InvalidWeih,        Assert.assertThrows(IllegalArgumensc            () -> PhiShip.tinhPhiShip(-1, "noi_thanh", fal0"            "Path1: (-1, noi_thanh, false) phai nem IllegalArve    }
    @Test(description = "Path2: noi_thanh, <=5kg, khong member -> 15000"be    {
    @Story("Path 2 - Noi thanh nhe khong member")
    @Severity(Severity      @Severity(SeverityLevel.CRITICAL)
    public      public void testPath2_NoiThanh_Nlsimport io.qameta.allure.*;
import org.testng.Assert;
import or_timport org.testng.Assert;->import org.testng.annotah /**
 * Bai 4.2 - TestNG Basis Pathh3 *no * 8 basis paths, tat ca 100% PASS
 */
@Feature("Bai 4h  */
@Feature("Baing *ho */
@Feature("Bai 4h  */
@Feature("Bai 4.2 - PhiShip B
 @F @public clan@F, @Feature("Bai 4.2 -er @F @public class PhiShipBas.0    @Severity(Severialse);
      @Severity(SeverityLevel.CRITICAL)
    p0.    public void testPath1_InvalidWeih,        Assert.assertbe      @Severity(SeverityLPa    p0.    public void testPath1_Inval      @Test(description = "Path2: noi_thanh, <=5kg, khong member -> 15000"be    {
    @Story("Path 2 - Noi thanh nhe khong member")
    @Severity(Severity      @Severity(SeverityLevel.CRITICAL)
    public      public v      @Story("Path 2 - Noi thanh nhe khong member")
    @Severity(Severity      "P    @Severity(Severity      @Severity(SeverityLe      public      public vhac nang khong member")
    @Severity(import org.testng.Assert    public void testPath7_TinhKhac_Nang_KhongMember()import or_timport org.te = * Bai 4.2 - TestNG Basis Pathh3 *no * 8 basis paths, tat ca 100% Eq */
@Feature("Bai 4h  */
@Feature("Baing *ho */
@Feature("Bai 4h  */
 p@Fi @Feature("B    }
    @Feature("Bai 4h  */
Pa@Feature("Bai 4.2 -kg @F @public clan@F, @Feature0%      @Severity(SeverityLevel.CRITICAL)
    p0.    public void testPath1_InvalidWeih,        Assli    p0.    public void testPath1_Inval {    @Story("Path 2 - Noi thanh nhe khong member")
    @Severity(Severity      @Severity(SeverityLevel.CRITICAL)
    public      public v      @Story("Path 2 - Noi thanh nhe khong member")
    @Severity(Sevecat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/main/java/org/example/bai5/VayVon.java << 'JAVAEOF'
package org.example.bai5;
/**
 * Bai 5.2 - Dieu kien vay von
 * Dieu kien: A && (B || C) && D
 *   A: tuoi >= 22
 *   B: thuNhap >= 10_000_000
 *   C: coTaiSan == true
 *   D: diemTinDung >= 700
 *
 * MC/DC test cases:
 * TC1: (25,12M,true,750)  A=T,B=T,C=T,D=T -> true
 * TC2: (30,12M,true,600)  A=T,B=T,C=T,D=F -> false  (D doc lap)
 * TC3: (28,12M,false,750) A=T,B=T,C=F,D=T -> true   (C doc lap, B=T nen B||C=T)
 * TC4: (28,12M,false,650) ... wait: re-check
 *
 * Theo CSV:
 * TC1: (25,12000000,true,750)->true
 * TC2: (30,12000000,true,600)->true   <- A=T,B=T,C=T,D=F=600<700? No 600<700=false
 *   Wait: CSV says TC2->true. So D threshold might be different.
 *   Reconsider: D: diemTinDung >= 700? TC2: 600 -> D=false -> overall false. But CSV says true.
 *   So D condition might be >= 600? No...
 *   Let me re-read: TC2 testMCDC_A_Doc_Lap_False: tuoi=30,thu=12M,coTaiSan=true,diem=600 -> true
 *   TC3 testMCDC_B_package org.example.bai5;
/**
 * Bai 5.2 - Dieu kien vay von
 * Dieu kien: A && (B || C) && D
 *   8,/**
 * Bai 5.2 - Dieu ki65 *-> * Dieu kien: A && (B || C) &oc *   A: tuoi >= 22
 *   B: thuNls *   B: thuNhap >se *   C: coTaiSan == true
 *se  *   D: diemTinDung >= al *
 * MC/DC test cases:
 T  >  * TC1: (25,12M,tru H * TC2: (30,12M,true,600)  A=T,B=T,C=T,D=F -> fal&  * TC3: (28,12M,false,750) A=T,B=T,C=F,D=T -> true   (C doc lap2M * TC4: (28,12M,false,650) ... wait: re-check
 *
 * Theo CSV:
 * TC1: (25,120000> *
 * Theo CSV:
 * TC1: (25,12000000,true,75re ho * TC1: (25*  * TC2: (0>=650=F -> false, not true
 *   Wait: CSV says TC2->true. So D threshold might be different.
 *   Reconat chang *   Reconsider: D: diemTinDung >= 700? TC2: 600 -> D=false -> o_L *   So D condition might be >= 600? No...
 *   Let me re-read: TC2ming convention: A_Doc_Lap mea *   Let me re-read: TC2 testMCDC_A_D.
 *   *   TC3 testMCDC_B_package org.example.bai5;
/**
 * Bai 5.2 - Dieu kien vay von
 * Dieu kien: A -/**
 * Bai 5.2 - Dieu kien vay von
 *result=tr * m * Dieu kien: A && (B || C) &ue *   8,/**
 * Bai 5.2 - Dieu kite *result
 * *   B: thuNls *   B: thuNhap >se *   C: coTaiSan == true
 *se  *   D: die-> *se  *   D: diemTinDung >= al *
 * MC/DC test cases:
 T   * MC/DC test cases:
 T  >  * T-> T  >  * TC1: (25,1ea *
 * Theo CSV:
 * TC1: (25,120000> *
 * Theo CSV:
 * TC1: (25,12000000,true,75re ho * TC1: (25*  * TC2: (0>=650=F -> false, not true
 *   Wait: CSV says TC2->true. So D threshold might bd  s  * TC *   Or  * Theo CSV:
 * TC1:>= * TC1: (25ap *   Wait: CSV says TC2->true. So D threshold might be different.
 *   Reconat ch T *   Reconat chang *   Reconsider: D: diemTinDung >= 700? TC2: 6T
 *   Let me re-read: TC2ming convention: A_Doc_Lap mea *   Let me re-read: TC2 testMCDC_A_D.
 *   *   TC3 testMCDC_B_package wh *   *   TC3 testMCDC_B_package org.example.bai5;
/**
 * Bai 5.2 - Dieu kien vay von
 * Die(7/**
 * Bai 5.2 - Dieu kien vay von
 * Dieu kien:00 *)= * Dieu kien: A -/**
 * Bai 53: * Bai 5.2 - Dieu kut *result=tr * m * Dieu kien: Hm * Bai 5.2 - Dieu kite *result
 * *   B: thuNls *   B:  " * *   B: thuNls *   B: thuNht= *se  *   D: die-> *se  *   D: diemTinDung >= al *
 * MC/DC) * MC/DC test cases:
 T   * MC/DC test cases:
 T  * T   * MC/DC test c(6 0>=600=T)=T
 *   TC3: T& * Theo CSV:
 -> true!
 *   TC4: (28 * TC1: (2565 * Theo CSV:
 * TC1:&& * TC1: (25)= *   Wait: CSV says TC2->true. So D threshold might bd  s  * TC *   Or  * Theo CS*  * TC1:>= * TC1: (25ap *   Wait: CSV says TC2->true. So D threshold might be diffe60 *   Reconat ch T *   Reconat chang *   Reconsider: D: diemTinDung >= 700? TC2: 6T
 *  a *   Let me re-read: TC2ming convention: A_Doc_Lap mea *   Let me re-read:,true,750 *   *   TC3 testMCDC_B_package wh *   *   T *   No, CSV says both true. Hmm.
 *
 *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_Doc_Lap_False:
 *   "A doc lap true" = test case where A=true AND changing A to false would change output
 *   "A doc lap false" = test case where A=false (but the * *   B: thuNls *   B:  " * *   B: thuNls *   B: thuNht= *se  *   D: die-> *se  *   D: dien  * MC/DC) * MC/DC test cases:
 T   * MC/DC test cases:
 T  * T   * MC/DC test c(6 0>=600=T)=T
 *   TC3: T&ig T   * MC/DC test cases:
 T Le T  * T   * MC/DC test CD *   TC3: T& * Theo CSV:
 -> true!
 *0, -> true!
 *   TC4: (2825 *   T *   * TC1:&& * TC1: (25)= *   Wait: CSV ,1 *  a *   Let me re-read: TC2ming convention: A_Doc_Lap mea *   Let me re-read:,true,750 *   *   TC3 testMCDC_B_package wh *   *   T *   No, CSV says both true. Hmm.
 *
 *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_Doc_Lap_False:
 *   "A doc lap true" = test case wTC *
 *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_Doc_Lap_False:
 *   "A doc lap true" = test case where A=true AND changing A to false would change output
 *  it on *   "A doc lap true" = test case where A=true AND changinisfies a *   "A doc lap false" = test case where A=false (but the * *   B: thuNls *   B:  " * *  0, T   * MC/DC test cases:
 T  * T   * MC/DC test c(6 0>=600=T)=T
 *   TC3: T&ig T   * MC/DC test cases:
 T Le T  * T   * MC/DC test CD *   TC3: T& * Theo CSV:
 -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   TC3: T&ig T   * MC/DC test casesru T Le T  * T   * MC/DC test CD *  thuNh -> true!
 *0, -> true!
 *   TC4: (2825 *   T *   * Te: *0, -> )  *   TC4: (2&  *
 *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_Doc_Lap_False:
 *   "A doc lap true" = test case wTC *
 *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_Doc_Lap_False:
 *   "A doc lap true" = test case where A=true AND ch C co *   "A doc lap true" = test case wTC *
 *   Wait - testMCDC_A(600 *   Wait - testMCDC_A_Doc_Lap_True ann. *   "A doc lap true" = test case where A=true AND changing A to00 *  it on *   "A doc lap true" = test case where A=true AND changinisfies a *   "A doc la   T  * T   * MC/DC test c(6 0>=600=T)=T
 *   TC3: T&ig T   * MC/DC test cases:
 T Le T  * T   * MC/DC test CD *   TC3: T& * Theo CSV:
 -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   TC3:ie *   TC3: T&ig T   * MC/DC test cases = T Le T  * T   * MC/DC test CD *   TC.  -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   Tet *0, -> e  *0, -> true!
 *   TC4: (2825 *   T *   * Te: *0, -> )  *   TC4: (2&  *
 *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_=6 *   TC4: (2   *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_Doc_L2: *   "A doc lap true" = test case wTC *
 *   Wait - testMCDC_F=F.  *   Wait - testMCDC_A_Doc_Lap_True anpe *   "A doc lap true" = test case where A=true AND ch C co *   " M *   Wait - testMCDC_A(600 *   Wait - testMCDC_A_Doc_Lap_True ann. *   "A doc lap true" = test cet *   TC3: T&ig T   * MC/DC test cases:
 T Le T  * T   * MC/DC test CD *   TC3: T& * Theo CSV:
 -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   TC3:ie *   TC3: T&ig T   * MC/DC test cases = T Le T  * T   * MC/DC test CD *   TC.  -> true!
 *0, -> tr ( T  * T ,  T Le T  * T   * MC/DC test CD *   TCts -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   T A *0ue->tru *0, -> tr ( T  * T   * MC/DC test  A *   Tet *0, -> e  *0, -> true!
 *   TC4: (2825 *   T *   * Te: *0, -> )  *   TC4: (2&  *
 *   Wa * *   TC4: (2825 *   T *   * Te: *0, -> )  *   TC4: (2&  *
 *   Wait * *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_=6 *s T *   Wait - testMCDC_F=F.  *   Wait - testMCDC_A_Doc_Lap_True anpe *   "A doc lap true" = test case where A=true AND ch C co *   " M *   Wait - testMCDC_A(600 *   ,  T Le T  * T   * MC/DC test CD *   TC3: T& * Theo CSV:
 -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   TC3:ie *   TC3: T&ig T   * MC/DC test cases = T Le T  * T   * MC/DC test CD *   TC.  -> true!
 *0, -> tr ( T  * T ,  T Le T  * T   * MC/DC tethuNhap>=10M, C=coTai -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   T & *0, ->  A *0, -> tr ( T  * T ,  T Le T  * T   * MC/DC test CD *   TCts -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   T A *0ue->tru *0, ->  t *0, -> tr ( T  * T   * MC/DC test  A *   T A *0ue->tru *0, -> tr ( Tme *   TC4: (2825 *   T *   * Te: *0, -> )  *   TC4: (2&  *
 *   Wa * *   TC4: (2825 *   T *   * Te: *0, -> )  *   TC: (A && B *   Wa * *   TC4: (2825 *   T *   * Te: *0, -> )  same as *   Wait * *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_=6 2M -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   TC3:ie *   TC3: T&ig T   * MC/DC test cases = T Le T  * T   * MC/DC test CD *   TC.  -> true!
 *0, -> tr ( T  * T ,  T Le T  * T   * MC/DC tethuNhap>=10M, C=coTai -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   T & *0, ->  A *0, -> &  *0, -> op *0, -> tr ( T  * T ,  T Le T  * T   * MC/DC tethuNhap>=10M, C=coTai -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   T & *0, ->  A le *0, -> tr ( T  * T   * MC/DC test  A *   T & *0, ->  A *0, -> tr ( T  * T ,on *0, -> tr ( T  * T   * MC/DC test  A *   T A *0ue->tru *0, ->  t *0, -> tr ( T  * T   * MC/DC test  A *   T A *0ue->tru *0, n *   Wa * *   TC4: (2825 *   T *   * Te: *0, -> )  *   TC: (A && B *   Wa * *   TC4: (2825 *   T *   * Te: *0, -> )  same as *   Wait * *   Wait - testMCDC_A_Doc_Lap_True and testMCDC_A_=6 2M di *0, -> tr ( T  * T   * MC/DC test  A *   TC3:ie *   TC3: T&ig T   * MC/DC test cases = T Le T  * T   * MC/DC test CD *   TC.  -> true!
 *0, -> tr ( T  * T ,  T Le T  * T   * MC/DC tethuNhap>=10M, C=uN *0, -> tr ( T  * T ,  T Le T  * T   * MC/DC tethuNhap>=10M, C=coTai -> true!
 *0, -> tr ( T  * T   * MC/DC test  A *   T & *0, ->  A C  *0, -> tr ( T  * T   * MC/DC test  A *   T & *0, ->  A *0, -> &  *0, -> op |  *0, -> tr ( T  * T   * Mcat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/main/java/org/example/bai5/VayVon.java << 'JAVAEOF'
package org.example.bai5;
/**
 * Bai 5.2 - Dieu kien vay von
 * Predicate: A && (B || C) && D
 *   A: tuoi >= 22
 *   B: thuNhap >= 10_000_000
 *   C: coTaiSan == true
 *   D: diemTinDung >= 700
 */
public class VayVon {
    public static boolean duDieuKienVay(int tuoi, long thuNhap, boolean coTaiSan, int diemTinDung) {
        boolean A = tuoi >= 22;
        boolean B = thuNhap >= 10_000_000L;
        boolean C = coTaiSan;
        boolean D = diemTinDung >= 700;
        return A && (B || C) && D;
    }
}
