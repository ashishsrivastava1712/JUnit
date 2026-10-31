/*
 * Author: Ashish Srivastava
 * Date: 31-10-2026
 */
public class UserRegistration {

    // UC1: Validates first name (starts with uppercase, minimum 3 characters)
    public static boolean validateFirstName(String fName) {
        return fName != null && fName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC2: Validates last name (starts with uppercase, minimum 3 characters)
    public static boolean validateLastName(String lName) {
        return lName != null && lName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC3: Validates email address with optional special parts and domain extensions
    public static boolean validateEmail(String userEmail) {
        String regexPattern =
                "^[A-Za-z0-9]+(?:[._+-][A-Za-z0-9]+)*"
                        + "@[A-Za-z0-9]+\.[A-Za-z]{2,}"
                        + "(?:\.[A-Za-z]{2,})?$";
        return userEmail != null && userEmail.matches(regexPattern);
    }

    // UC4: Validates mobile number with country code and 10 digits separated by space
    public static boolean validateMobile(String phoneNum) {
        return phoneNum != null && phoneNum.matches("^[0-9]{1,3} [0-9]{10}$");
    }

    // UC5: Confirms password length is at least 8 characters
    public static boolean validatePasswordLength(String passCode) {
        return passCode != null && passCode.length() >= 8;
    }

    // UC6: Confirms password has at least one uppercase letter
    public static boolean validatePasswordUppercase(String passCode) {
        return passCode != null && passCode.matches(".*[A-Z].*");
    }

    // UC7: Confirms password contains at least one numeric digit
    public static boolean validatePasswordDigit(String passCode) {
        return passCode != null && passCode.matches(".*[0-9].*");
    }

    // UC8: Confirms password has exactly one special character
    public static boolean validatePasswordSpecialCharacter(String passCode) {
        if (passCode == null) {
            return false;
        }

        int specialSymbolCount = 0;
        for (char ch : passCode.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                specialSymbolCount++;
            }
        }
        return specialSymbolCount == 1;
    }

    // Composite check for UC5 through UC8
    public static boolean validatePassword(String passCode) {
        return validatePasswordLength(passCode)
                && validatePasswordUppercase(passCode)
                && validatePasswordDigit(passCode)
                && validatePasswordSpecialCharacter(passCode);
    }

    // UC9: Composite validation verifying all user parameters together
    public static boolean validateUser(
            String fName,
            String lName,
            String userEmail,
            String phoneNum,
            String passCode) {
        return validateFirstName(fName)
                && validateLastName(lName)
                && validateEmail(userEmail)
                && validateMobile(phoneNum)
                && validatePassword(passCode);
    }

    public static void main(String[] args) {
        String testFirst = "Ashish";
        String testLast = "Srivastava";
        String testEmail = "abc.xyz@bl.co.in";
        String testMobile = "91 9919819801";
        String testPass = "Ashish@123";

        if (validateUser(testFirst, testLast, testEmail, testMobile, testPass)) {
            System.out.println("User registration successful!");
        } else {
            System.out.println("User registration failed!");
        }
    }
}
