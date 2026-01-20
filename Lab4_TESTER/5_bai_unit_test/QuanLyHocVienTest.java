import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import java.util.List;

public class QuanLyHocVienTest {
    private QuanLyHocVien qlhv;
    
    @Before
    public void setUp() {
        qlhv = new QuanLyHocVien();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHocVien_MaSoRong() {
        HocVien hv = new HocVien("", "Nguyen Van A", "Ha Noi", 8, 9, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHocVien_HoTenNull() {
        HocVien hv = new HocVien("HV001", null, "Ha Noi", 8, 9, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHocVien_DiemAm() {
        HocVien hv = new HocVien("HV001", "Nguyen Van A", "Ha Noi", -1, 9, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHocVien_DiemLonHon10() {
        HocVien hv = new HocVien("HV001", "Nguyen Van A", "Ha Noi", 8, 11, 10);
    }
    
    @Test
    public void testTinhDiemTrungBinh() {
        HocVien hv = new HocVien("HV001", "Nguyen Van A", "Ha Noi", 8, 9, 10);
        Assert.assertEquals(9.0, hv.tinhDiemTrungBinh(), 0.01);
        
        HocVien hv2 = new HocVien("HV002", "Tran Thi B", "HCM", 7, 8, 6);
        Assert.assertEquals(7.0, hv2.tinhDiemTrungBinh(), 0.01);
    }
    
    @Test
    public void testDuDieuKienNhanHocBong_DatYeuCau() {
        // Điểm TB >= 8.0 và tất cả môn >= 5
        HocVien hv1 = new HocVien("HV001", "Nguyen Van A", "Ha Noi", 8, 9, 10);
        Assert.assertTrue(hv1.duDieuKienNhanHocBong());
        
        HocVien hv2 = new HocVien("HV002", "Tran Thi B", "HCM", 7, 8, 9);
        Assert.assertTrue(hv2.duDieuKienNhanHocBong());
    }
    
    @Test
    public void testDuDieuKienNhanHocBong_DiemTBThap() {
        // Điểm TB < 8.0
        HocVien hv = new HocVien("HV003", "Le Van C", "Da Nang", 6, 7, 8);
        Assert.assertFalse(hv.duDieuKienNhanHocBong());
    }
    
    @Test
    public void testDuDieuKienNhanHocBong_CoMonDuoi5() {
        // Có môn < 5
        HocVien hv = new HocVien("HV004", "Pham Thi D", "Hue", 10, 10, 4);
        Assert.assertFalse(hv.duDieuKienNhanHocBong());
    }
    
    @Test
    public void testDuDieuKienNhanHocBong_DiemTBDung8() {
        // Điểm TB = 8.0 (biên)
        HocVien hv = new HocVien("HV005", "Hoang Van E", "Can Tho", 8, 8, 8);
        Assert.assertTrue(hv.duDieuKienNhanHocBong());
    }
    
    @Test
    public void testThemHocVien() {
        HocVien hv1 = new HocVien("HV001", "Nguyen Van A", "Ha Noi", 8, 9, 10);
        qlhv.themHocVien(hv1);
        Assert.assertEquals(1, qlhv.soLuongHocVien());
        
        HocVien hv2 = new HocVien("HV002", "Tran Thi B", "HCM", 7, 8, 9);
        qlhv.themHocVien(hv2);
        Assert.assertEquals(2, qlhv.soLuongHocVien());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testThemHocVien_TrungMaSo() {
        HocVien hv1 = new HocVien("HV001", "Nguyen Van A", "Ha Noi", 8, 9, 10);
        qlhv.themHocVien(hv1);
        
        HocVien hv2 = new HocVien("HV001", "Tran Thi B", "HCM", 7, 8, 9);
        qlhv.themHocVien(hv2);  // Ném ngoại lệ
    }
    
    @Test
    public void testLayDanhSachNhanHocBong() {
        // Thêm học viên đạt điều kiện
        HocVien hv1 = new HocVien("HV001", "Nguyen Van A", "Ha Noi", 8, 9, 10);
        qlhv.themHocVien(hv1);
        
        // Thêm học viên không đạt (điểm TB thấp)
        HocVien hv2 = new HocVien("HV002", "Tran Thi B", "HCM", 6, 7, 8);
        qlhv.themHocVien(hv2);
        
        // Thêm học viên đạt điều kiện
        HocVien hv3 = new HocVien("HV003", "Le Van C", "Da Nang", 9, 8.5, 8);
        qlhv.themHocVien(hv3);
        
        // Thêm học viên không đạt (có môn < 5)
        HocVien hv4 = new HocVien("HV004", "Pham Thi D", "Hue", 10, 10, 4);
        qlhv.themHocVien(hv4);
        
        List<HocVien> dsNhanHocBong = qlhv.layDanhSachNhanHocBong();
        Assert.assertEquals(2, dsNhanHocBong.size());
        Assert.assertTrue(dsNhanHocBong.contains(hv1));
        Assert.assertTrue(dsNhanHocBong.contains(hv3));
    }
    
    @Test
    public void testLayDanhSachNhanHocBong_KhongCoAi() {
        HocVien hv1 = new HocVien("HV001", "Nguyen Van A", "Ha Noi", 6, 7, 8);
        qlhv.themHocVien(hv1);
        
        HocVien hv2 = new HocVien("HV002", "Tran Thi B", "HCM", 5, 6, 7);
        qlhv.themHocVien(hv2);
        
        List<HocVien> dsNhanHocBong = qlhv.layDanhSachNhanHocBong();
        Assert.assertEquals(0, dsNhanHocBong.size());
    }
    
    @Test
    public void testTimHocVienTheoMa() {
        HocVien hv1 = new HocVien("HV001", "Nguyen Van A", "Ha Noi", 8, 9, 10);
        qlhv.themHocVien(hv1);
        
        HocVien found = qlhv.timHocVienTheoMa("HV001");
        Assert.assertNotNull(found);
        Assert.assertEquals("Nguyen Van A", found.getHoTen());
        
        HocVien notFound = qlhv.timHocVienTheoMa("HV999");
        Assert.assertNull(notFound);
    }
}