package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioOutLine {
    ScenarioContext context;
    public ScenarioOutLine(ScenarioContext context) {
        this.context = context;
    }

    @Given("User on Particular page")
    public void user_on_particular_page() {
        System.out.println("user_on_particular_page");
        context.set("new key", "somenewvalue");
        System.out.println(context.get("new key") + "is set from Contenxt");

    }
    @When("he enter {string} and {string}")
    public void he_enter_and(String string, String string2) {

        System.out.println("Entered "+string +" and "+string2);
        System.out.println(context.get("new key") + "is retirved in step 2 from Contenxt");

    }
    @Then("he is logged in")
    public void he_is_logged_in() {
        System.out.println("he_is_logged_in");
    }
}
