package stepdefinitionsreal;

import context.TestContext;
import io.cucumber.java.en.Then;
import pagesreal.AccountPage;

public class MyAccountPageStepDef {
    AccountPage accountPage;
    TestContext testContext;


    public MyAccountPageStepDef(TestContext testContext) {
        this.testContext = testContext;
        accountPage=new AccountPage(testContext.getDriverManager().getDriver());
    }

    @Then(": My account section is displayed")
    public void myAccountSectionIsDisplayed() {
        System.out.println("On My accout page");
    }
}
