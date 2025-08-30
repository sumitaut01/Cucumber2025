package hooks;

import io.cucumber.java.*;

public class Hooks {


    @Before
    public void b(){

        System.out.println("Inside Hooks before");
    }

    @After
    public void a(){

        System.out.println("Inside Hooks After");
    }

    @BeforeStep
    public void bs(){

        System.out.println("Inside Hooks BeforeStep");
    }

    @AfterStep
    public void as(Scenario scenario){

        // maybe know the status of step and add some screen hsot if required bfor faulire
        System.out.println("Inside Hooks AfterStep");
    }
}
