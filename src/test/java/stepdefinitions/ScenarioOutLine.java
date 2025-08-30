package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioOutLine {

    @Given("User on Particular page")
    public void user_on_particular_page() {
        System.out.println("user_on_particular_page");
    }
    @When("he enter {string} and {string}")
    public void he_enter_and(String string, String string2) {

        System.out.println("Entered "+string +" and "+string2);
    }
    @Then("he is logged in")
    public void he_is_logged_in() {
        System.out.println("he_is_logged_in");
    }
}
