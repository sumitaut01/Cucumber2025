package stepdefinitionsreal;

import context.TestContext;
import io.cucumber.java.en.*;
import pagesreal.LoginPage;

public class LoginPageStepDef {

    TestContext testContext;
    LoginPage loginPage;

    public LoginPageStepDef(TestContext testContext) {
        this.testContext = testContext;
        loginPage=new LoginPage(testContext.getDriverManager().getDriver());
    }

    @Given(": Give user on HomePage")
    public void give_user_on_home_page() {
        loginPage.launchApp();
    }
    @When(": Enters {string} and {string}")
    public void enters_and(String string, String string2) {
       loginPage.login(string,string2);

        System.out.println("Setting some context in this step:");
        testContext.getScenarioContext().getMap().put("myKey", "myvalue");


    }
    @When(": Clicks Login link")
    public void clicks_login_link() {
        System.out.println("User on dummy page. Reading context from last step");
        System.out.println(testContext.getScenarioContext().getMap());
    }






}
