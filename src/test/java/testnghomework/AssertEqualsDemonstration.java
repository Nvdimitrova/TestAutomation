package testnghomework;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AssertEquals {
    @Test
    public void verifyExpectedPaymentIsTheSameAsActual(){
        int expectedPayment = 2700;
        int contractSalary = 2700;

        assertEquals(contractSalary,expectedPayment,
                "Expected payment does not match the contract!");
    }


    @Test
    public void verifyStringLengthMatchesExpectedValue(){
        String greeting = "Hello";
        int stringLength = greeting.length();
        int expectedLength = 5;

        assertEquals(stringLength, expectedLength, "String length does not match!");
    }


    @Test
    public void verifySuccessfulLoginWhenGivenValidPassword(){
        String userPassword = "S3cr3t password";
        String inputPassword = "S3cr3t password";

        assertEquals(inputPassword, userPassword, "Wrong password!");
    }




}
