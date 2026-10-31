/*
 * Author: Ashish Srivastava
 * Date: 31-10-2026
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegistrationTest {

    // UC10: Happy-path test for valid first name.
    @Test
    void testValidFirstName() {

        assertTrue(UserRegistration.validateFirstName("Ashish"));
    }

    // UC10: Sad-path test for invalid first name.
    @Test
    void testInvalidFirstName() {

        assertFalse(UserRegistration.validateFirstName("ashish"));
        assertFalse(UserRegistration.validateFirstName("Na"));
        assertFalse(UserRegistration.validateFirstName("12345"));
    }

    // UC10: Happy-path test for valid last name.
    @Test
    void testValidLastName() {

        assertTrue(UserRegistration.validateLastName("Sharma"));
    }

    // UC10: Sad-path test for invalid last name.
    @Test
    void testInvalidLastName() {

        assertFalse(UserRegistration.validateLastName("sharma"));
        assertFalse(UserRegistration.validateLastName("Ra"));
        assertFalse(UserRegistration.validateLastName("12345"));
    }

    // UC10: Happy-path test for valid email.
    @Test
    void testValidEmail() {

        assertTrue(UserRegistration.validateEmail("abc.xyz@bl.co.in"));
    }

    // UC10: Sad-path test for invalid email.
    @Test
    void testInvalidEmail() {

        assertFalse(UserRegistration.validateEmail("abc"));
        assertFalse(UserRegistration.validateEmail("abc@.com"));
        assertFalse(UserRegistration.validateEmail("abc@gmail.a"));
    }

    // UC10: Happy-path test for valid mobile number.
    @Test
    void testValidMobile() {

        assertTrue(UserRegistration.validateMobile("91 9919819801"));
    }

    // UC10: Sad-path test for invalid mobile number.
    @Test
    void testInvalidMobile() {

        assertFalse(UserRegistration.validateMobile("9919819801"));
        assertFalse(UserRegistration.validateMobile("91 991981980"));
        assertFalse(UserRegistration.validateMobile("91-9919819801"));
        assertFalse(UserRegistration.validateMobile("91 99198198012"));
    }

    // UC10: Happy-path test for valid password.
    @Test
    void testValidPassword() {

        assertTrue(UserRegistration.validatePassword("Ashish@123"));
    }

    // UC10: Sad-path test for invalid password.
    @Test
    void testInvalidPassword() {

        assertFalse(UserRegistration.validatePassword("nav@123"));
        assertFalse(UserRegistration.validatePassword("Ashish123"));
        assertFalse(UserRegistration.validatePassword("Ashish@abc"));
        assertFalse(UserRegistration.validatePassword("Ashish@@123"));
    }

    // UC10: Happy-path test for complete user registration.
    @Test
    void testValidUserRegistration() {

        assertTrue(UserRegistration.validateUser(
                "Ashish",
                "Raj",
                "abc.xyz@bl.co.in",
                "91 9919819801",
                "Ashish@123"
        ));
    }

    // UC10: Sad-path test for complete user registration.
    @Test
    void testInvalidUserRegistration() {

        assertFalse(UserRegistration.validateUser(
                "ashish",
                "Raj",
                "abc.xyz@bl.co.in",
                "91 9919819801",
                "Ashish@123"
        ));
    }

    // UC11: Parameterized test for all valid and invalid email samples.
    @ParameterizedTest
    @CsvSource({
            "abc@yahoo.com, true",
            "abc-100@yahoo.com, true",
            "abc.100@yahoo.com, true",
            "abc111@abc.com, true",
            "abc-100@abc.net, true",
            "abc.100@abc.com.au, true",
            "abc@1.com, true",
            "abc@gmail.com.com, true",
            "abc+100@gmail.com, true",
            "abc, false",
            "abc@.com.my, false",
            "abc123@gmail.a, false",
            "abc123@.com, false",
            "abc123@.com.com, false",
            ".abc@abc.com, false",
            "abc()*@gmail.com, false",
            "abc@%*.com, false",
            "abc..2002@gmail.com, false",
            "abc.@gmail.com, false",
            "abc@abc@gmail.com, false",
            "abc@gmail.com.1a, false",
            "abc@gmail.com.aa.au, false"
    })
    void testEmailSamples(String email, boolean expectedResult) {

        assertTrue(
                UserRegistration.validateEmail(email) == expectedResult,
                "Email validation failed for: " + email
        );
    }

    // Additional test for null email.
    @Test
    void testNullEmail() {

        assertFalse(UserRegistration.validateEmail(null));
    }
}
