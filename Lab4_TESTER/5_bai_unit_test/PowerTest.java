import org.junit.Test;
import org.junit.Assert;

public class PowerTest {
    
    @Test
    public void testPowerWithZeroExponent() {
        // x^0 = 1 với mọi x
        Assert.assertEquals(1.0, Power.calculate(5.0, 0), 0.0001);
        Assert.assertEquals(1.0, Power.calculate(-3.0, 0), 0.0001);
        Assert.assertEquals(1.0, Power.calculate(0.0, 0), 0.0001);
    }
    
    @Test
    public void testPowerWithPositiveExponent() {
        // Test x^n với n > 0
        Assert.assertEquals(8.0, Power.calculate(2.0, 3), 0.0001);
        Assert.assertEquals(25.0, Power.calculate(5.0, 2), 0.0001);
        Assert.assertEquals(27.0, Power.calculate(3.0, 3), 0.0001);
        Assert.assertEquals(-8.0, Power.calculate(-2.0, 3), 0.0001);
    }
    
    @Test
    public void testPowerWithNegativeExponent() {
        // Test x^n với n < 0
        Assert.assertEquals(0.5, Power.calculate(2.0, -1), 0.0001);
        Assert.assertEquals(0.25, Power.calculate(2.0, -2), 0.0001);
        Assert.assertEquals(0.04, Power.calculate(5.0, -2), 0.0001);
    }
    
    @Test
    public void testPowerWithDecimalBase() {
        // Test với x là số thập phân
        Assert.assertEquals(0.25, Power.calculate(0.5, 2), 0.0001);
        Assert.assertEquals(2.25, Power.calculate(1.5, 2), 0.0001);
    }
}