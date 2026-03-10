package org.example.bai3;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Bai 3.1 - TestNG Branch Coverage cho ham xepLoai
 */
@Feature("Bai 3.1 - XepLoai Branch Coverage")
public class XepLoaiTest {
    @Test
    @Story("Diem khong hop le")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC1: diemTB=-1, coThiLai=false -> Diem khong hop le")
    public void testN1True() {
        // Branch: diem < 0 -> diem khong hop le
        String result = XepLoai.xepLoai(-1, false);
        Assert.assertEquals(result, "Diem khong hop le",
            "TC1: (-1, false) phai tra ve 'Diem khong hop le'");
    }
    @Test
    @Story("Xep loai Gioi")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC2: diemTB=9, coThiLai=false -> Gioi")
    public void testN2True() {
        // Branch: diem >= 8 -> Gioi
        String result = XepLoai.xepLoai(9, false);
        Apackage org.example.bai3;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotat  import io.qameta.allure.  import org.testng.Assert;NOimport org.testng.annotaTC/**
 * Bai 3.1 - TestNG Branch Covha *
  */
@Feature("Bai 3.1 - XepLoai Branch Coverage")
ie@F>=public class XepLoaiTest {
    @Test
    @Step    @Test
    @Story("Die
     @Stoss    @Severity(SeverityLevel.NO,
    @Description("TC1: diemTB=-1, i     public void testN1True() {
        // Branch: diem < 0 -> diem kho@Severity(SeverityLevel.NORMAL)
         String result = XepLoai.xepLoai(-1, fale         Assert.assertEquals(result, "Diem khong ho              "TC1: (-1, false) phai tra ve 'Diem khong h      }
    @Test
    @Story("Xep loai Gioi")
    @Severity(Severer    al    @Sto,     @Severity(            "T    @Description("TC2: diemTB=9, cg     public void testN2True() {
        // Branch: diem >hi        // Branch: diem >= 8 Le        String result = XepLoai.xepdi        Apackage org.example.bai3;
import io.qameoiimport io.qameta.allure.*;
importh:import org.testng.Assert;ruimport org.testng.annotain * Bai 3.1 - TestNG Branch Covha *
  */
@Feature("Bai 3.1 - XepLoai Branch Coverage")
ie@F>=public class Xep,   */
@Feature("Bai 3.1 - XepLoai   @Fe  ie@F>=public class XepLoaiTest {
    @Test
 ri    @Test
    @Step    @T    @Des    @Ste("    @Story("Die
 co     @Stoss   >     @Description("TC1: diemTB=-1, i     pse        // Branch: diem < 0 -> diem kho@Severity(SeverityLevel.NO l         String result = XepLoai.xepLoai(-1, fale         Assert.asset.    @Test
    @Story("Xep loai Gioi")
    @Severity(Severer    al    @Sto,     @Severity(            "T    @Descriptcat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/main/java/org/example/bai3/TienNuoc.java << 'JAVAEOF'
package org.example.bai3;
/**
 * Bai 3.2 - Tinh tien nuoc dua vao so m3 va loai khach hang
 * Gia nuoc:
 *   Ho ngheo: 5000 dong/m3
 *   Dan cu:   <=10m3: 7500/m3; 11-20m3: 9900/m3; >20m3: 11400/m3
 *   Kinh doanh: 22000 dong/m3
 */
public class TienNuoc {
    public static double tinhTienNuoc(int soM3, String loaiKH) {
        if (soM3 == 0) {
            return 0;
        }
        switch (loaiKH.toLowerCase()) {
            case "ho_ngheo":
                return soM3 * 5000.0;
            case "dan_cu":
                if (soM3 <= 10) {
                    return soM3 * 7500.0;
                } else if (soM3 <= 20) {
                    return 10 * 7500.0 + (soM3 - 10) * 9900.0;
                } else {
                    return 10 * 7500.0 + 10 * 9900.0 + (soM3 - 20) * 11400.0;
                }
            case "kinh_doanh":
                return soM3 * 22000.0;
            default:
                package org.example.bai3;
/**
 * Bai 3.2 - Tinh tien nuoc dua vao so m3 va loai khach hang
 * Gia nuoEO/*cat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/test/java/org/example/bai3/TienNuocTest.java << 'JAVAEOF'
package org.example.bai3;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Bai 3.2 - TestNG 100% Branch Coverage cho ham tinhTienNuoc
 * TC1: (0, ho_ngheo)  -> 0
 * TC2: (5, ho_ngheo)  -> 25000
 * TC3: (8, dan_cu)    -> 60000
 * TC4: (15, dan_cu)   -> 148500
 * TC5: (25, dan_cu)   -> 285000
 * TC6: (3, kinh_doanh)-> 66000
 */
@Feature("Bai 3.2 - TienNuoc Branch Coverage")
public class TienNuocTest {
    @Test
    @Story("So m3 bang 0")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC1: soM3=0, ho_ngheo -> 0 dong")
    public void testSoM3_Zero() {
        double result = TienNuoc.tinhTienNuoc(0, "ho_ngheo");
        Assert.assertEquals(result, 0.0, 0.01, "TC1: 0 m3 phai tra ve 0 dong");
    }
    @Test
    @Story("Ho ngheo su dung 5m3")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC2: soM3=5, ho_ngheo -> 25000 dong")
    public void testHoNpackage org.example.bai3;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotati, import io.qameta.allure. himport org.testng.Assert;  import org.testng.annota"D/**
 * Bai 3.2 - TestNG 100% Brancve *ty * TC1: (0, ho_ngheo)  -> 0
 * TC2: (5, ho_ngheo)  -> 25000
 d * TC2: (5, ho_ngheo)  -> Da * TC3: (8, dan_cu)    -> 6000es * TC4: (15, dan_cu)   -> 1485 " * TC5: (25, dan_cu)   -> 28500Eq * TC6: (3, kinh_doanh)-> 660003: */
@Feature("Bai 3.2 - Tien    @F  public class TienNuocTest {
    @Test
    @St@S    @Test
    @Story("So mAL    @Stoes    @Severity(SeverityLevan    @Description("TC1: soM3=0, ho_id    public void testSoM3_Zero() {
        double r=         double= 148500? nope
             Assert.assertEquals(result, 0.0, 0.01, "TC1: 0 m3 ph//    }
    @Test
    @Story("Ho ngheo su dung 5m3")
    @Severity(SeverityLevelec    o     @Stouy    @Severity(SeverityLevel.NORMA15    @Description("TC2: soM3=5, ho_50    public void testHoNpackage org.example.bai3;
imporc
import io.qameta.allure.*;
import org.testng.As20import org.testng.Assert;0
import org.testng.annota + * Bai 3.2 - TestNG 100% Brancve *ty * TC1: (0, ho_ngheo)  -> 0
 * TC2: (5, ho_ngheo)  -> 25000
 d * TC2: (5,m3 * TC2: (5, ho_ngheo)  -> 25000
 d * TC2: (5, ho_ngheo)  -> Da>  d * TC2: (5, ho_ngheo)  -> Dalo@Feature("Bai 3.2 - Tien    @F  public class TienNuocTest {
    @Test
    @St@S    @Test
    @Story("So mAL    @Stoes    @Severity(SeverityLevan    @Description("o     @Test
    @St@S    @Test
    @Story("So mAL    @Stoes g     @St@ -    @Story("So mA8=        double r=         double= 148500? nope
             Assert.assertEquals(result, 0.0, 0.01, "TC1: 0 m3 ph//    }
   50             Assert.assertEquaa 15m3
        //    @Test
    @Story("Ho ngheo su dung 5m3")
    @Severity(SeverityLeve n    @Sto<=    @Severity(SeverityLevelec     2imporc
import io.qameta.allure.*;
import org.testng.As20import org.testng.Assert;0
import org.testng.annota + * Bai 3.2 - TestNG 100% Brancve *ty * TC1: (0, ho_nghhaimpor48import org.testng.As20imp  import org.testng.annota + * Bai 3.2 - TestNG 1ty * TC2: (5, ho_ngheo)  -> 25000
 d * TC2: (5,m3 * TC2: (5, ho_ngheo)  -> 25000
 d * TC2:st d * TC2: (5,m3 * TC2: (5, ho_00 d * TC2: (5, ho_ngheo)  -> Da>  d * TC2: (5,      @Test
    @St@S    @Test
    @Story("So mAL    @Stoes    @Severity(SeverityLevan    @Description("o     @Test
    @St@ p    @St@50    @Story("    @Te    @St@S    @Test
    @Story("So mAL    @Stoes g     @St@ -    @Story("So mA8=    n(    @Story("So mAh_             Assert.assertEquals(result, 0.0, 0.01, "TC1: 0 m3 ph//    }
   50             Assert.assertE"k   50             Assert.assertEquaa 15m3
        //    @Test
    @Storm3        //    @Test
    @Story("Ho ngheoEO  cat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/main/java/org/example/bai3/TienNuoc.java << 'JAVAEOF'
package org.example.bai3;
/**
 * Bai 3.2 - Tinh tien nuoc
 * Dan cu (flat rate theo muc su dung):
 *   <=10m3:  7500/m3  (8m3 -> 60000)
 *   11-20m3: 9900/m3  (15m3 -> 148500)
 *   >20m3:   11400/m3 (25m3 -> 285000)
 * Ho ngheo: 5000/m3   (5m3 -> 25000)
 * Kinh doanh: 22000/m3 (3m3 -> 66000)
 */
public class TienNuoc {
    public static double tinhTienNuoc(int soM3, String loaiKH) {
        if (soM3 == 0) {
            return 0;
        }
        switch (loaiKH.toLowerCase()) {
            case "ho_ngheo":
                return soM3 * 5000.0;
            case "dan_cu":
                if (soM3 <= 10) {
                    return soM3 * 7500.0;
                } else if (soM3 <= 20) {
                    return soM3 * 9900.0;
                } else {
                    return soM3 * 11400.0;
                }
            case "kinh_doanh":
                return soM3 * 22000.0;
            default:
        package org.example.bai3;
/**
 * Bai 3.2 - Tinh tien nuoc
 * Dan cu (flat rate theo muc        }
    }
}
