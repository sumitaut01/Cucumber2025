package context;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {

    private final DriverManager driverManager;
    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;

    public TestContext() {
        this.driverManager = new DriverManager();
        this.scenarioContext = new ScenarioContext();
        this.pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}

