package annotations;

import org.testng.annotations.*;

public class AnnotationsDemonstration {
    @BeforeSuite
    public void setUpTestSuite() {
        System.out.println("Initializing a database");
        System.out.println("========================");
    }

    @BeforeTest
    public void setUpBeforeTest() {
        System.out.println("Setting up before test...");
        System.out.println("        = = =");
    }

    @Test
    public void firstTest() {
        System.out.println("Executing first test...");
    }

    @Test
    public void secondTest() {
        System.out.println("Executing second test...");
    }

    @Test
    public void thirdTest() {
        System.out.println("Executing third test...");
    }

    @AfterTest
    public void cleaningUpAfterTest() {
        System.out.println("        = = =");
        System.out.println("Cleaning up after test...");
    }

    @AfterSuite
    public void cleaningUpAfterTestSuite() {
        System.out.println("=========================");
        System.out.println("Generating report");
    }
}