package priority;

import org.testng.annotations.Test;

public class PriorityDemonstration {
    @Test(priority = 1)
    public void createUser() {
        System.out.println("Step 1: Creating a new user.");
    }

    @Test(priority = 2)
    public void updateUserInformation() {
        System.out.println("Step 2: Updating user information.");
    }

    @Test(priority = 3)
    public void deleteUser() {
        System.out.println("Step 3: Deleting the user.");
    }

    @Test(priority = 0)
    public void setUp() {
        System.out.println("Setting up the test environment...");
    }

    @Test(priority = 4)
    public void cleanUp() {
        System.out.println("Cleaning up the test environment...");
    }
}