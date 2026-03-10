package org.example.bai5;

/**
 * Bai 5.2 - Dieu kien vay von
 *
 * Predicate: A && (B || C) && D
 *   A: tuoi >= 22
 *   B: thuNhap >= 10_000_000
 *   C: coTaiSan == true
 *   D: diemTinDung >= 700
 *
 * Bang MC/DC:
 *   A_True  : (25,12M,true,750)  -> T&&(T||T)&&T = true
 *   A_False : (20,12M,true,750)  -> F&&(T||T)&&T = false
 *   B_True  : (28,12M,false,750) -> T&&(T||F)&&T = true
 *   B_False : (28,8M, false,750) -> T&&(F||F)&&T = false
 *   C_True  : (28,8M, true, 750) -> T&&(F||T)&&T = true
 *   D_False : (28,12M,false,650) -> T&&(T||F)&&F = false
 */
public class VayVon {

    public static boolean duDieuKienVay(int tuoi, long thuNhap,
                                        boolean coTaiSan, int diemTinDung) {
        boolean A = tuoi >= 22;
        boolean B = thuNhap >= 10_000_000L;
        boolean C = coTaiSan;
        boolean D = diemTinDung >= 700;
        return A && (B || C) && D;
    }
}
