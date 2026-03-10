package org.example.bai3;

/**
 * Bai 3.2 - Tinh tien nuoc
 * Dan cu (flat rate theo muc su dung):
 *   soM3 <= 10: 7500/m3  (TC3: 8m3 -> 60000)
 *   10 < soM3 <= 20: 9900/m3  (TC4: 15m3 -> 148500)
 *   soM3 > 20: 11400/m3  (TC5: 25m3 -> 285000)
 * Ho ngheo: 5000/m3 (TC2: 5m3 -> 25000)
 * Kinh doanh: 22000/m3 (TC6: 3m3 -> 66000)
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
                throw new IllegalArgumentException("Loai khach hang khong hop le: " + loaiKH);
        }
    }
}
