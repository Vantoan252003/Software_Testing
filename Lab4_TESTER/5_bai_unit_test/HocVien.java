public class HocVien {
    private String maSo;
    private String hoTen;
    private String queQuan;
    private double diemMon1;
    private double diemMon2;
    private double diemMon3;
    
    public HocVien(String maSo, String hoTen, String queQuan, 
                   double diemMon1, double diemMon2, double diemMon3) {
        if (maSo == null || maSo.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma so khong hop le");
        }
        if (hoTen == null || hoTen.trim().isEmpty()) {
            throw new IllegalArgumentException("Ho ten khong hop le");
        }
        if (diemMon1 < 0 || diemMon1 > 10 || 
            diemMon2 < 0 || diemMon2 > 10 || 
            diemMon3 < 0 || diemMon3 > 10) {
            throw new IllegalArgumentException("Diem khong hop le");
        }
        
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
        this.diemMon3 = diemMon3;
    }
    
    public double tinhDiemTrungBinh() {
        return (diemMon1 + diemMon2 + diemMon3) / 3.0;
    }
    
    public boolean duDieuKienNhanHocBong() {
        // Điều kiện: điểm TB >= 8.0 và không có môn nào < 5
        return tinhDiemTrungBinh() >= 8.0 && 
               diemMon1 >= 5.0 && 
               diemMon2 >= 5.0 && 
               diemMon3 >= 5.0;
    }
    
    // Getters
    public String getMaSo() { return maSo; }
    public String getHoTen() { return hoTen; }
    public String getQueQuan() { return queQuan; }
    public double getDiemMon1() { return diemMon1; }
    public double getDiemMon2() { return diemMon2; }
    public double getDiemMon3() { return diemMon3; }
}