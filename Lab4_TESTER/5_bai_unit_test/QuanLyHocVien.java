import java.util.ArrayList;
import java.util.List;

public class QuanLyHocVien {
    private List<HocVien> danhSachHocVien;
    
    public QuanLyHocVien() {
        this.danhSachHocVien = new ArrayList<>();
    }
    
    public void themHocVien(HocVien hv) {
        if (hv == null) {
            throw new IllegalArgumentException("Hoc vien khong hop le");
        }
        // Kiểm tra trùng mã số
        for (HocVien h : danhSachHocVien) {
            if (h.getMaSo().equals(hv.getMaSo())) {
                throw new IllegalArgumentException("Ma so hoc vien da ton tai");
            }
        }
        danhSachHocVien.add(hv);
    }
    
    public List<HocVien> layDanhSachNhanHocBong() {
        List<HocVien> result = new ArrayList<>();
        for (HocVien hv : danhSachHocVien) {
            if (hv.duDieuKienNhanHocBong()) {
                result.add(hv);
            }
        }
        return result;
    }
    
    public int soLuongHocVien() {
        return danhSachHocVien.size();
    }
    
    public HocVien timHocVienTheoMa(String maSo) {
        for (HocVien hv : danhSachHocVien) {
            if (hv.getMaSo().equals(maSo)) {
                return hv;
            }
        }
        return null;
    }
    
    public List<HocVien> getDanhSachHocVien() {
        return new ArrayList<>(danhSachHocVien);
    }
}