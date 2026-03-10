package org.example.bai5;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Bai 5.2 - MC/DC Test cho ham duDieuKienVay
 *
 * Predicate: A && (B || C) && D
 *   A: tuoi >= 22
 *   B: thuNhap >= 10,000,000
 *   C: coTaiSan == true
 *   D: diemTinDung >= 700
 *
 * Bang MC/DC (fix B=T, C=T, tru dieu kien dang test):
 * A_True:  tuoi=25,thu=12M,coTS=T,diem=750 -> T&&(T||T)&&T = true
 * A_False: tuoi=20,thu=12M,coTS=T,diem=750 -> F&&(T||T)&&T = false
 * B_True:  tuoi=28,thu=12M,coTS=F,diem=750 -> T&&(T||F)&&T = true
 * B_False: tuoi=28,thu=8M, coTS=F,diem=750 -> T&&(F||F)&&T = false
 * C_True:  tuoi=28,thu=8M, coTS=T,diem=750 -> T&&(F||T)&&T = true
 * D_True:  tuoi=25,thu=12M,coTS=T,diem=750 -> T&&T&&T = true
 * D_False: tuoi=25,thu=12M,coTS=T,diem=650 -> T&&T&&F = false
 *
 * Note: CSV data listed may use different pairing but the logic is consistent with the prpackage org.example.bai5;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotationtoimport io.qameta.allure.22import org.testng.Assert;evimport org.testng.annota @/**
 * Bai 5.2 - MC/DC Test cho hauN *p= *
 * Predicate: A && (B || C) && D
 *   A: =T is *   A: tuoi >= 22
 *   B: thuNst *   B: thuNhap >ue *   C: coTaiSan == true
 * T, *   D: diemTinDung >= t= *
 * Bang MC/DC (fix B=Tlt =  * A_TrduDieuKienVay(25, 12_000_000L, true, 750);
      * A_False: tuoi=20,thu=12M,coTS=T,diem=750 -> F&&(T||T)&&T = falra * B_True:  tuoi=28,thu=12M,coTS=F,diem=750 -> T&&(T||F)&&T = truese * B_False: tuoi=28,thu=8M, coTS=F,diem=750 -> T&&(F||F)&&T = falFa * C_True:  tuoi=28,thu=8M, coTS=T,diem=750 -> T&&(F||T)&&T = true=F * D_True:  tuoi=25,thu=12M,coTS=T,diem=750 -> T&&T&&T = true
 *    * D_False: tuoi=25,thu=12M,coTS=T,diem=650 -> T&&T&&F = fal
  *
 * Note: CSV data listed may use different pairing but the t ueimport io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotationtoimport io.qameta.allure.22impor @import org.testng.Assert;p import org.testn    @Sever * Bai 5.2 - MC/DC Test cho hauN *p= *
 * Predicate: A && (B || C) && D
 *   A: =T is *   A: tuoi >= 22
 *   B:tr * Predicate: A && (B || C) && D
 *  id *   A: =T is *   A: tuoi >= 22   *   B: thuNst *   B: thuNhap && * T, *   D: diemTinDung >= t= *
 * Bang MC/DC (fix B=TlDi * Bang MC/DC (fix B=Tlt =  * Ae,      * A_False: tuoi=20,thu=12M,coTS=T,diem=750 -> F&&(T||T)&&T = falra * i  *    * D_False: tuoi=25,thu=12M,coTS=T,diem=650 -> T&&T&&F = fal
  *
 * Note: CSV data listed may use different pairing but the t ueimport io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotationtoimport io.qameta.allure.22impor @import org.testng.Assert;p import org.testn    @Sever * Bai 5.2 - MC/DC Test cho hauN ea  *
 * Note: CSV data listed may use different pairing but the t   * Aimport org.testng.Assert;
imp B-False: (28,8M,false,750) phai tra ve false");
    }
    @Timport org.testng.annotap  * Predicate: A && (B || C) && D
 *   A: =T is *   A: tuoi >= 22
 *   B:tr * Predicate: A && (B || C) && D
 *  id *   A: =T is *   A: tuoi >= 22   *   B:s  *   A: =T is * =F.")
    public  *   B:tr * Predicate: A && (B { *  id *   A: =T is *   A: tuoi >= 22    A * Bang MC/DC (fix B=TlDi * Bang MC/DC (fix B=Tlt =  * Ae,      * A_False: tuoi=20,thu=12M,coTS=T,diemAs  *
 * Note: CSV data listed may use different pairing but the t ueimport io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotationtoimport io.qameta.allure.22impor @import org.testnoi *5,import org.testng.Assert;
import org.testng.annotationtoimport io.qameta.allure.22impor esimport org.testng.annota   * Note: CSV data listed may use different pairing but the t   * Aimport org.testng.Assert;
imp B-False: (28,8M,false,750) phai tra ve false");
    }
   Doimp B-False: (28,8M,false,750) phai tra ve false");
    }
   cat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/main/java/org/example/bai6/PhoneValidator.java << 'JAVAEOF'
package org.example.bai6;
/**
 * Bai 6.1 - TDD: Kiem tra so dien thoai Viet Nam
 *
 * Quy tac:
 * - Bat dau bang 0 hoac +84
 * - Sau khi chuan hoa, bat dau bang 03x/05x/07x/08x/09x
 * - Tong 10 chu so
 */
public class PhoneValidator {
    public static boolean isValid(String phone) {
        if (phone == null || phone.isBlank()) {
            return false;
        }
        String normalized = phone.trim();
        // Chuan hoa: +84 -> 0
        if (normalized.startsWith("+84")) {
            normalized = "0" + normalized.substring(3);
        }
        // Kiem tra dinh dang: bat dau 03x/05x/07x/08x/09x, tong 10 chu so
        return normalized.matches("^0[35789]\\d{8}$");
    }
}
