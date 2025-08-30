#AND is just syntactic sugar
# ** we can modify the method name in step def. We just cant change corresponding Keyword description
# we will see below if steps are missing io.cucumber.java.PendingException();
Feature: First feature file
  @sanity
  Scenario: Valid Login
    Given When I am login page for my site
    # below creates user_enters_and(String string, String string2)

    When  User enters "username" and "password"
    #void clicks_submit_button()
    And  Clicks Submit button
    #void user_sees_my_account_page()
    Then User sees my account page
  @regression
  Scenario: Valid Login with login data
    Given When I am login page for my site
    #@When("User enters login data \\(username:{string} Password:{string}")
   #public void user_enters_login_data_username_password(String string, String string2)
    When  User enters login data (username:"username" Password:"password"
    #void clicks_submit_button()
    And  Clicks Submit button
    #void user_sees_my_account_page()
    Then User sees my account page