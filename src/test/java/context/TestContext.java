package context;

import managers.DriverManager;

public class TestContext {
private DriverManager driverManager;
private ScenarioContext scenarioContext;
    public TestContext(DriverManager driverManager, ScenarioContext scenarioContext) {
        this.driverManager = driverManager;
        this.scenarioContext = scenarioContext;
        System.out.println("TestContext constructor");
    }
    public DriverManager getDriverManager() {
        return driverManager;
    }
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

}
