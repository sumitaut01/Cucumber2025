package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginwithparams {


    @Given("When I am login page for my site")
    public void when_i_am_login_page_for_my_site() {

        System.out.println("I am on login page");
    }
    @When("User enters {string} and {string}")
    public void user_enters_and(String string, String string2) {
        System.out.println("I  entering uername"+string+ "password"+string2);
    }
    @When("Clicks Submit button")
    public void clicks_submit_button() {
        System.out.println("user has clicked submit");
    }
    @Then("User sees my account page")
    public void user_sees_my_account_page() {
        System.out.println("user has clicked my account page");
    }

    @When("User enters login data \\(username:{string} Password:{string}")
    public void user_enters_login_data_username_password(String string, String string2) {
        System.out.println("test");
    }

}
