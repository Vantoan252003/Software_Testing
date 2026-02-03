
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * BÀI 3 - TestRuner (Runner) class
 * Runs the ErrorCollectorExample test class and prints results
 */
public class TestRuner {

    public static void main(String[] args) {
        // Run the ErrorCollectorExample test class
        Result result = JUnitCore.runClasses(ErrorCollectorExample.class);

        System.out.println("====================================");
        System.out.println("ERROR COLLECTOR TEST RESULTS");
        System.out.println("====================================");

        // Print number of tests run
        System.out.println("Number of tests run: " + result.getRunCount());

        // Print number of failures
        System.out.println("Number of failures: " + result.getFailureCount());

        // Print whether all tests passed
        System.out.println("All tests passed: " + result.wasSuccessful());

        System.out.println("\n====================================");
        System.out.println("FAILURE DETAILS");
        System.out.println("====================================");

        // Print detailed failure messages
        if (result.getFailureCount() > 0) {
            int failureNumber = 1;
            for (Failure failure : result.getFailures()) {
                System.out.println("\nFailure #" + failureNumber + ":");
                System.out.println("Test: " + failure.getTestHeader());
                System.out.println("Message: " + failure.getMessage());
                System.out.println("Exception: " + failure.getException());
                System.out.println("Trace: " + failure.getTrace());
                failureNumber++;
            }
        } else {
            System.out.println("\nNo failures - all tests passed!");
        }

        System.out.println("\n====================================");
        System.out.println("Execution time: " + result.getRunTime() + " ms");
        System.out.println("====================================");
    }
}
