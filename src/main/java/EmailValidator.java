/*
 * Author: Ashish Srivastava
 * Date: 31-10-2026
 */
public class EmailValidator {

    // Regular expression pattern for validating RFC-compliant email formats
    private static final String PATTERN_EMAIL =
            "^[A-Za-z0-9]+(?:[._+-][A-Za-z0-9]+)*"
                    + "@[A-Za-z0-9]+\.[A-Za-z]{2,}"
                    + "(?:\.[A-Za-z]{2,})?$";

    // Validates whether the given email string conforms to standard format rules
    public static boolean isValidEmail(String emailInput) {
        if (emailInput == null || emailInput.trim().isEmpty()) {
            return false;
        }
        return emailInput.matches(PATTERN_EMAIL);
    }
}
