package assertions;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class AssertNotNullDemonstration {
    @Test
    public void verifyUserObjectIsNotNull() {
        String userEmail = "userEmail@abv.bg";

        boolean isEmpty = userEmail.isEmpty();

        assertFalse(isEmpty, "User cannot proceed without entering an email");
    }
}