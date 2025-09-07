package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepdefinitions.ScenarioOutLine;

public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {
      if(driver==null){
            driver=new ChromeDriver();
      }
      return driver;
    }
}
