import org.junit.Test;
import org.junit.Assert;

public class HinhChuNhatTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRectangle_SameX() {
        // topLeft.x >= bottomRight.x
        Diem topLeft = new Diem(5, 10);
        Diem bottomRight = new Diem(5, 5);
        HinhChuNhat hcn = new HinhChuNhat(topLeft, bottomRight);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRectangle_SameY() {
        // topLeft.y <= bottomRight.y
        Diem topLeft = new Diem(0, 5);
        Diem bottomRight = new Diem(5, 5);
        HinhChuNhat hcn = new HinhChuNhat(topLeft, bottomRight);
    }
    
    @Test
    public void testTinhDienTich_HinhVuong() {
        // Hình vuông 5x5
        Diem topLeft = new Diem(0, 5);
        Diem bottomRight = new Diem(5, 0);
        HinhChuNhat hcn = new HinhChuNhat(topLeft, bottomRight);
        Assert.assertEquals(25.0, hcn.tinhDienTich(), 0.0001);
    }
    
    @Test
    public void testTinhDienTich_HinhChuNhat() {
        // Hình chữ nhật 4x6
        Diem topLeft = new Diem(1, 7);
        Diem bottomRight = new Diem(5, 1);
        HinhChuNhat hcn = new HinhChuNhat(topLeft, bottomRight);
        Assert.assertEquals(24.0, hcn.tinhDienTich(), 0.0001);
    }
    
    @Test
    public void testTinhDienTich_SoThapPhan() {
        // Test với tọa độ thập phân
        Diem topLeft = new Diem(1.5, 5.5);
        Diem bottomRight = new Diem(4.5, 2.5);
        HinhChuNhat hcn = new HinhChuNhat(topLeft, bottomRight);
        Assert.assertEquals(9.0, hcn.tinhDienTich(), 0.0001);
    }
    
    @Test
    public void testGiaoNhau_HaiHinhTrungNhau() {
        // Hai hình trùng nhau hoàn toàn
        Diem topLeft1 = new Diem(0, 5);
        Diem bottomRight1 = new Diem(5, 0);
        HinhChuNhat hcn1 = new HinhChuNhat(topLeft1, bottomRight1);
        
        Diem topLeft2 = new Diem(0, 5);
        Diem bottomRight2 = new Diem(5, 0);
        HinhChuNhat hcn2 = new HinhChuNhat(topLeft2, bottomRight2);
        
        Assert.assertTrue(hcn1.kiemTraGiaoNhau(hcn2));
    }
    
    @Test
    public void testGiaoNhau_MotPhan() {
        // Hai hình giao nhau một phần
        Diem topLeft1 = new Diem(0, 4);
        Diem bottomRight1 = new Diem(4, 0);
        HinhChuNhat hcn1 = new HinhChuNhat(topLeft1, bottomRight1);
        
        Diem topLeft2 = new Diem(2, 6);
        Diem bottomRight2 = new Diem(6, 2);
        HinhChuNhat hcn2 = new HinhChuNhat(topLeft2, bottomRight2);
        
        Assert.assertTrue(hcn1.kiemTraGiaoNhau(hcn2));
    }
    
    @Test
    public void testKhongGiaoNhau_BenTrai() {
        // HCN1 nằm hoàn toàn bên trái HCN2
        Diem topLeft1 = new Diem(0, 4);
        Diem bottomRight1 = new Diem(2, 0);
        HinhChuNhat hcn1 = new HinhChuNhat(topLeft1, bottomRight1);
        
        Diem topLeft2 = new Diem(5, 4);
        Diem bottomRight2 = new Diem(7, 0);
        HinhChuNhat hcn2 = new HinhChuNhat(topLeft2, bottomRight2);
        
        Assert.assertFalse(hcn1.kiemTraGiaoNhau(hcn2));
    }
    
    @Test
    public void testKhongGiaoNhau_PhiaTren() {
        // HCN1 nằm hoàn toàn phía trên HCN2
        Diem topLeft1 = new Diem(0, 8);
        Diem bottomRight1 = new Diem(4, 5);
        HinhChuNhat hcn1 = new HinhChuNhat(topLeft1, bottomRight1);
        
        Diem topLeft2 = new Diem(0, 4);
        Diem bottomRight2 = new Diem(4, 0);
        HinhChuNhat hcn2 = new HinhChuNhat(topLeft2, bottomRight2);
        
        Assert.assertFalse(hcn1.kiemTraGiaoNhau(hcn2));
    }
    
    @Test
    public void testKhongGiaoNhau_ChiChamCanh() {
        // Hai hình chỉ chạm cạnh (không coi là giao nhau)
        Diem topLeft1 = new Diem(0, 4);
        Diem bottomRight1 = new Diem(2, 0);
        HinhChuNhat hcn1 = new HinhChuNhat(topLeft1, bottomRight1);
        
        Diem topLeft2 = new Diem(2, 4);
        Diem bottomRight2 = new Diem(4, 0);
        HinhChuNhat hcn2 = new HinhChuNhat(topLeft2, bottomRight2);
        
        Assert.assertFalse(hcn1.kiemTraGiaoNhau(hcn2));
    }
    
    @Test
    public void testGiaoNhau_HinhNhoNamTrongHinhLon() {
        // HCN nhỏ nằm hoàn toàn trong HCN lớn
        Diem topLeft1 = new Diem(0, 10);
        Diem bottomRight1 = new Diem(10, 0);
        HinhChuNhat hcn1 = new HinhChuNhat(topLeft1, bottomRight1);
        
        Diem topLeft2 = new Diem(2, 8);
        Diem bottomRight2 = new Diem(8, 2);
        HinhChuNhat hcn2 = new HinhChuNhat(topLeft2, bottomRight2);
        
        Assert.assertTrue(hcn1.kiemTraGiaoNhau(hcn2));
        Assert.assertTrue(hcn2.kiemTraGiaoNhau(hcn1));
    }
}