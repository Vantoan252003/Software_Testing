import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.List;

public class PolynomialTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDataWithFewerCoefficients() {
        // n = 2 nhưng chỉ có 2 hệ số (cần 3)
        List<Integer> coeffs = Arrays.asList(1, 2);
        Polynomial p = new Polynomial(2, coeffs);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDataWithMoreCoefficients() {
        // n = 1 nhưng có 3 hệ số (chỉ cần 2)
        List<Integer> coeffs = Arrays.asList(1, 2, 3);
        Polynomial p = new Polynomial(1, coeffs);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDegree() {
        // n âm
        List<Integer> coeffs = Arrays.asList(1, 2);
        Polynomial p = new Polynomial(-1, coeffs);
    }
    
    @Test
    public void testConstantPolynomial() {
        // P(x) = 5, n = 0
        List<Integer> coeffs = Arrays.asList(5);
        Polynomial p = new Polynomial(0, coeffs);
        Assert.assertEquals(5, p.calculate(0));
        Assert.assertEquals(5, p.calculate(10));
    }
    
    @Test
    public void testLinearPolynomial() {
        // P(x) = 3 + 2x, n = 1
        List<Integer> coeffs = Arrays.asList(3, 2);
        Polynomial p = new Polynomial(1, coeffs);
        Assert.assertEquals(3, p.calculate(0));   // 3 + 2*0 = 3
        Assert.assertEquals(5, p.calculate(1));   // 3 + 2*1 = 5
        Assert.assertEquals(13, p.calculate(5));  // 3 + 2*5 = 13
    }
    
    @Test
    public void testQuadraticPolynomial() {
        // P(x) = 1 + 2x + 3x^2, n = 2
        List<Integer> coeffs = Arrays.asList(1, 2, 3);
        Polynomial p = new Polynomial(2, coeffs);
        Assert.assertEquals(1, p.calculate(0));   // 1 + 0 + 0 = 1
        Assert.assertEquals(6, p.calculate(1));   // 1 + 2 + 3 = 6
        Assert.assertEquals(17, p.calculate(2));  // 1 + 4 + 12 = 17
    }
    
    @Test
    public void testCubicPolynomial() {
        // P(x) = 2 + 0x + 1x^2 + 1x^3, n = 3
        List<Integer> coeffs = Arrays.asList(2, 0, 1, 1);
        Polynomial p = new Polynomial(3, coeffs);
        Assert.assertEquals(2, p.calculate(0));   // 2
        Assert.assertEquals(4, p.calculate(1));   // 2 + 0 + 1 + 1 = 4
        Assert.assertEquals(14, p.calculate(2));  // 2 + 0 + 4 + 8 = 14
    }
}