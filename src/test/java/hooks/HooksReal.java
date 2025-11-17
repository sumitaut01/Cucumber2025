package hooks;

import context.TestContext;
import io.cucumber.java.*;
import managers.DriverManager;
import managers.ConfigReader;
import org.openqa.selenium.WebDriver;

public class HooksReal {

    private final DriverManager driverManager;

    public HooksReal(TestContext context) {
        this.driverManager = context.getDriverManager();
    }

    @BeforeAll
    public static void before_all() {
        System.out.println("=== Global Setup: Starting test suite ===");
    }

    @AfterAll
    public static void after_all() {
        System.out.println("=== Global Teardown: Test suite finished ===");
    }

    @Before
    public void beforeHook() {
        System.out.println("Inside Before Hook (Thread " + Thread.currentThread().getId() + ")");
        WebDriver driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        String browser = ConfigReader.get("browser");
        String execution = ConfigReader.get("execution");
        long threadId = Thread.currentThread().getId();
        //scenario.log   adds in cucumber record
        scenario.log("🌐 Scenario: " + scenario.getName());
        scenario.log("🧭 Browser: " + browser+" "+"Execution Type: " + execution+" "+"🧵 Thread ID: " + threadId);
    }


    @After
    public void afterHook() {
        System.out.println("Inside After Hook (Thread " + Thread.currentThread().getId() + ")");
        driverManager.quitDriver(); // ✅ better than driver.get().quit()
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("→ Before Step");
    }

    // so if step fails then we may need to add some screenshot. After step with scenario.isFailed() can work fine

    @AfterStep
    public void afterStep(Scenario scenario) {

        System.out.println("← After Step");

        if(scenario.isFailed()){
            System.out.println("Step has failed. Add Screenshot code below");
        }
    }
}
