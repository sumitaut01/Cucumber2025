package pagesreal;

import context.TestContext;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage {
    //TestContext testContext;
    private WebDriver driver;
    private By username = By.name("email");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//input[@value='Login']");

    public LoginPage(WebDriver driver) {
        this.driver =  driver;
    }



    public AccountPage login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
        return new AccountPage(driver);
    }


    public void launchApp(){
//        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();

        System.out.println("Lauch handled in hooks");
    }
}
