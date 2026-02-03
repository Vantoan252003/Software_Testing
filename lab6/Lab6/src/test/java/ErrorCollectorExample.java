import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * BÀI 3 - ErrorCollector Rule Example
 * Demonstrates how to collect multiple errors in a single test
 */
public class ErrorCollectorExample {

    /**
     * ErrorCollector rule allows a test to continue after the first error is found
     * and report all errors at the end
     */
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    /**
     * Test method that collects multiple errors
     * Even if some assertions fail, all will be checked and reported
     */
    @Test
    public void testMultipleErrors() {
        // Test 1: This will pass
        collector.checkThat("Expected 5", 5, equalTo(5));

        // Test 2: This will fail - but test continues
        collector.checkThat("Expected 10 but got 5", 5, equalTo(10));

        // Test 3: This will fail - but test continues
        collector.checkThat("Expected 'hello' but got 'world'", "world", equalTo("hello"));

        // Test 4: This will pass
        collector.checkThat("Expected 'test'", "test", equalTo("test"));

        // Test 5: Adding error directly
        collector.addError(new Throwable("This is a custom error message"));

        // All failures will be collected and reported at the end
    }

    /**
     * Another test method demonstrating mathematical checks
     */
    @Test
    public void testMathematicalOperations() {
        int a = 10;
        int b = 5;

        // Check addition - will pass
        collector.checkThat("10 + 5 = 15", a + b, equalTo(15));

        // Check subtraction - will fail
        collector.checkThat("10 - 5 = 3 (wrong)", a - b, equalTo(3));

        // Check multiplication - will pass
        collector.checkThat("10 * 5 = 50", a * b, equalTo(50));

        // Check division - will fail
        collector.checkThat("10 / 5 = 3 (wrong)", a / b, equalTo(3));
    }
}
