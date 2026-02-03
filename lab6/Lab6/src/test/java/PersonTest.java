import org.example.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

/**
 * BÀI 2 - Test exception with 3 techniques
 * Demonstrates three different ways to test for exceptions in JUnit 4
 */
public class PersonTest {

    /**
     * Rule for testing exceptions with ExpectedException
     * Must be declared as public
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Technique 1: Using @Test(expected = IllegalArgumentException.class)
     * This is the simplest way to test for exceptions
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAge_UsingExpectedAttribute() {
        // This should throw IllegalArgumentException because age is negative
        new Person("John", -5);
    }

    /**
     * Technique 2: Using ExpectedException Rule
     * This allows more detailed assertions about the exception
     */
    @Test
    public void testNegativeAge_UsingExpectedExceptionRule() {
        // Set up the expectation that IllegalArgumentException will be thrown
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Age cannot be negative");

        // This should throw the expected exception
        new Person("Jane", -10);
    }

    /**
     * Technique 3: Using try-catch block
     * This gives the most control but requires more boilerplate code
     */
    @Test
    public void testNegativeAge_UsingTryCatch() {
        try {
            // Try to create a Person with negative age
            new Person("Bob", -1);

            // If we reach this line, no exception was thrown
            // The test should fail
            fail("Expected IllegalArgumentException to be thrown");

        } catch (IllegalArgumentException e) {
            // Exception was thrown as expected
            // Test passes
            // Optionally, we can verify the exception message
            assert e.getMessage().equals("Age cannot be negative");
        }
    }

    /**
     * Additional test: Verify that valid age works correctly
     */
    @Test
    public void testValidAge() {
        Person person = new Person("Alice", 25);
        assert person.getName().equals("Alice");
        assert person.getAge() == 25;
    }
}
