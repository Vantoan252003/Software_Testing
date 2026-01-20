package validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OrganizationValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^[0-9]{9,12}$");

    public static class ValidationResult {
        private boolean valid;
        private List<String> errors;

        public ValidationResult() {
            this.valid = true;
            this.errors = new ArrayList<>();
        }

        public void addError(String error) {
            this.valid = false;
            this.errors.add(error);
        }

        public boolean isValid() {
            return valid;
        }

        public List<String> getErrors() {
            return errors;
        }

        public String getErrorMessage() {
            return String.join("\n", errors);
        }
    }

    public static ValidationResult validate(String orgName, String address,
                                            String phone, String email) {
        ValidationResult result = new ValidationResult();

        // Validate OrgName
        if (orgName == null || orgName.trim().isEmpty()) {
            result.addError("Organization Name is required");
        } else if (orgName.trim().length() < 3) {
            result.addError("Organization Name must be at least 3 characters");
        } else if (orgName.trim().length() > 255) {
            result.addError("Organization Name must not exceed 255 characters");
        }

        // Validate Email (if provided)
        if (email != null && !email.trim().isEmpty()) {
            if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
                result.addError("Email format is invalid");
            }
        }

        // Validate Phone (if provided)
        if (phone != null && !phone.trim().isEmpty()) {
            if (!PHONE_PATTERN.matcher(phone.trim()).matches()) {
                result.addError("Phone must contain only digits and be 9-12 characters long");
            }
        }

        return result;
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return true; // Email is optional
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return true; // Phone is optional
        }
        return PHONE_PATTERN.matcher(phone.trim()).matches();
    }
}