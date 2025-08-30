package stepdefinitions;

import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;


public class Passingmultiplevaluetostep {
    @Given("User on registration page")
    public void user_on_registration_page() {
        System.out.println("Inside user_on_registration_page");
    }
    @When("user enters data")
    public void user_enters_data(io.cucumber.datatable.DataTable dataTable) {
        //List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);// when we have header

        Map<String, String> row = dataTable.asMap(String.class, String.class);// when no header
        System.out.println(row.get("firstname") +" "+row.get("lastname")+" "+row.get("age"));
        }


    @When("Submits form")
    public void submits_form(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows=  dataTable.asMaps(String.class, String.class);
        System.out.println(rows);
    }

    @Then("success message is shown")
    public void success_message_is_shown() {
        System.out.println("Inside success_message_is_shown");
    }






}