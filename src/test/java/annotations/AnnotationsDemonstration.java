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

    @BeforeClass
    public void executingBeforeClass() {
        System.out.println("     BEFORE CLASS");
        System.out.println();
    }

    @BeforeMethod
    public void executingBeforeMethod() {
        System.out.println("Executing BEFORE method!");
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

    @AfterMethod
    public void executingAfterMethod() {
        System.out.println("Executing AFTER method!");
        System.out.println();
    }

    @AfterClass
    public void executingaAfterClass() {
        System.out.println("     AFTER CLASS");
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