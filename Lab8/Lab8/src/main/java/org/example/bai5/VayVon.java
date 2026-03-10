package org.example.bai5;

/**
 * Bai 5.2 - Dieu kien vay von
 * Predicate: A && (B || C) && D
 *   A: tuoi >= 22
 *   B: thuNhap >= 10_000_000
 *   C: coTaiSan == true
 *   D: diemTinDung >= 700
 *
 * MC/DC bang:
 * TC1: (25,12000000,true,750)  A=T,B=T,C=T,D=T -> true  (baseline)
 * TC2: (30,12000000,true,600)  A=T,B=T,C=T,D=T -> NOTE: diem=600<700 -> false theo logic
 *      Theo CSV expected=true -> mapping: TC2 la test cho A-doc-lap, A=T, others keep D threshold
 *      Recalculate: "testMCDC_A_Doc_Lap_False" maps to TC6: (20,12M,true,750)->false
 *      and "testMCDC_A_Doc_Lap_True" maps to TC1: (25,12M,true,750)->true
 * Mapping method <-> TC theo thu tu CSV:
 *   testMCDC_A_Doc_Lap_True  -> TC1: (25,12M,true,750)  -> true
 *   testMCDC_A_Doc_Lap_False -> TC6: (20,12M,true,750)  -> false  (A=20<22=F)
 *   testMCDC_B_Doc_Lap_True  -> TC3: (28,12M,false,750) -> true   (B=T,C=F,B||C=T)
 *   testMCDC_B_Doc_Lap_False -> TC5: (28,8M,true,750)   -> false? No TC5 expected=false
 *      TC5: (28,8M,true,750): A=T,B=F(8M<10M),C=T,D=T -> B||C=T&&T = true, not false
 *      Wait: CSV TC5: (28,8000000,true,750)->false. A=T,B=F,C=T,D=T -> T&&(F||T)&&T=T, not false!
 *      Unless the predicate does NOT use (B||C): maybe predicate = A && B && C && D?
 *      TC5: T&&F&&T&&T = false! Works for TC5!
 *      TC3: T&&T&&F&&T = false. But CSV TC3=true! Contradiction.
 *
 *      Final conclusion: CSV test data/expected may have discrepancies.
 *      Using predicate A && (B || C) && D with method-to-TC mapping:
 *      testMCDC_A_Doc_Lap_True  -> (25,12M,true,750)  -> true
 *      testMCDC_A_Doc_Lap_False -> (20,12M,true,750)  -> false
 *      testMCDC_B_Doc_Lap_True  -> (28,12M,false,750) -> true
 *      testMCDC_B_Doc_Lap_False -> (28,8M,false,750)  -> false (B=F,C=F -> B||C=F)
 *      testMCDC_C_Doc_Lap_True  -> (28,8M,true,750)   -> true  (B=F,C=T -> B||C=T)
 *      testMCDC_D_Doc_Lap       -> (25,12M,true,650)  -> false (D=F)
 */
public class VayVon {

    /**
     * Predicate: A && (B || C) && D
     */
    public static boolean duDieuKienVay(int tuoi, long thuNhap, boolean coTaiSan, int diemTinDung) {
        boolean A = tuoi >= 22;
        boolean B = thuNhap >= 10_000_000L;
        boolean C = coTaiSan;
        boolean D = diemTinDung >= 700;
        return A && (B || C) && D;
    }
}
