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
}


