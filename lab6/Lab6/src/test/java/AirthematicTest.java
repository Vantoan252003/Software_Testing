import org.example.JunitMessage;
import org.junit.Test;

/**
 * BÀI 1 - Test exception with @Test(expected)
 * Tests the JunitMessage class for ArithmeticException when dividing by zero
 */
public class AirthematicTest {

    /**
     * Test that verifies ArithmeticException is thrown when dividing by zero
     * The test passes if the expected exception is thrown
     */
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        JunitMessage message = new JunitMessage();
        // This should throw ArithmeticException
        message.divide(10, 0);
    }
}
