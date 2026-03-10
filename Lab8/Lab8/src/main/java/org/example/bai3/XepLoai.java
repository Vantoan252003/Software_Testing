package org.example.bai3;

/**
 * Bai 3.1 - Xep loai hoc tap
 */
public class XepLoai {

    /**
     * Xep loai hoc tap
     * @param diemTB diem trung binh (0-10)
     * @param coThiLai co duoc thi lai hay khong
     * @return ket qua xep loai
     */
    public static String xepLoai(double diemTB, boolean coThiLai) {
        if (diemTB < 0 || diemTB > 10) {
            return "Diem khong hop le";
        }
        if (diemTB >= 8.0) {
            return "Gioi";
        }
        if (diemTB >= 6.5) {
            return "Kha";
        }
        if (diemTB >= 5.0) {
            return "Trung Binh";
        }
        if (coThiLai) {
            return "Thi lai";
        }
        return "Yeu - Hoc lai";
    }
}
