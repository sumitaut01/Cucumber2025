package hooks;

import context.TestContext;
import io.cucumber.java.*;
import managers.DriverManager;



public class HooksReal {
    DriverManager driverManager;

    public HooksReal(TestContext context) {
        this.driverManager = context.getDriverManager();

    }
    @Before
    public void beforeHook() {
        System.out.println("Inside Before Hooks");
        driverManager.getDriver().manage().window().maximize();
    }
    @After
    public void afterHook() {
        System.out.println("Inside Hooks After");
        driverManager.getDriver().quit();
        System.out.println("Inside Hooks After. Driver destroyed");
    }
    @BeforeAll
    public static void before_all(){
        System.out.println("Calling before all");

    }
    @AfterAll
    public static void after_all(){
        System.out.println("Calling after all");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("Calling beforeStep ");

    }
    @AfterStep
    public void afterStep(){
        System.out.println("Calling afterStep ");

    }
}


