//package hooks;
//
//import io.cucumber.java.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Hooks {
//
//
//    WebDriver driver;
//    @Before
//    public void b(){
//        driver=new ChromeDriver();
//        System.out.println("Inside Hooks before");
//    }
//
//    @After
//    public void a(){
//
//        System.out.println("Inside Hooks After");
//    }
//
//    @BeforeStep
//    public void bs(){
//
//        System.out.println("Inside Hooks BeforeStep");
//        driver.quit();
//    }
//
//    @AfterStep
//    public void as(Scenario scenario){
//
//        // maybe know the status of step and add some screen hsot if required bfor faulire
//        System.out.println("Inside Hooks AfterStep");
//    }
//}
