import org.junit.Test;
import org.junit.Assert;

public class RadixTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumber() {
        // Số âm phải ném ngoại lệ
        Radix r = new Radix(-5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRadixTooSmall() {
        // Cơ số < 2 phải ném ngoại lệ
        Radix r = new Radix(10);
        r.convertDecimalToAnother(1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRadixTooLarge() {
        // Cơ số > 16 phải ném ngoại lệ
        Radix r = new Radix(10);
        r.convertDecimalToAnother(17);
    }
    
    @Test
    public void testConvertToBinary() {
        // Test chuyển sang nhị phân (cơ số 2)
        Radix r1 = new Radix(10);
        Assert.assertEquals("1010", r1.convertDecimalToAnother(2));
        
        Radix r2 = new Radix(15);
        Assert.assertEquals("1111", r2.convertDecimalToAnother(2));
        
        Radix r3 = new Radix(8);
        Assert.assertEquals("1000", r3.convertDecimalToAnother(2));
    }
    
    @Test
    public void testConvertToOctal() {
        // Test chuyển sang bát phân (cơ số 8)
        Radix r1 = new Radix(64);
        Assert.assertEquals("100", r1.convertDecimalToAnother(8));
        
        Radix r2 = new Radix(255);
        Assert.assertEquals("377", r2.convertDecimalToAnother(8));
    }
    
    @Test
    public void testConvertToHexadecimal() {
        // Test chuyển sang thập lục phân (cơ số 16)
        Radix r1 = new Radix(255);
        Assert.assertEquals("FF", r1.convertDecimalToAnother(16));
        
        Radix r2 = new Radix(171);
        Assert.assertEquals("AB", r2.convertDecimalToAnother(16));
        
        Radix r3 = new Radix(4095);
        Assert.assertEquals("FFF", r3.convertDecimalToAnother(16));
    }
    
    @Test
    public void testConvertZero() {
        // Test số 0
        Radix r = new Radix(0);
        Assert.assertEquals("0", r.convertDecimalToAnother(2));
        Assert.assertEquals("0", r.convertDecimalToAnother(8));
        Assert.assertEquals("0", r.convertDecimalToAnother(16));
    }
    
    @Test
    public void testVariousRadixes() {
        // Test các cơ số khác nhau
        Radix r = new Radix(100);
        
        Assert.assertEquals("1100100", r.convertDecimalToAnother(2));  // Nhị phân
        Assert.assertEquals("1121", r.convertDecimalToAnother(3));     // Tam phân
        Assert.assertEquals("310", r.convertDecimalToAnother(4));      // Tứ phân
        Assert.assertEquals("144", r.convertDecimalToAnother(8));      // Bát phân
        Assert.assertEquals("64", r.convertDecimalToAnother(16));      // Thập lục phân
    }
}