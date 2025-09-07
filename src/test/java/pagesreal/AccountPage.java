package pagesreal;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
   // TestContext testContext;
    private WebDriver driver;

    By lnkMyAccount= By.xpath("//div/a[contains(text(),'My Account')]");

    public AccountPage(WebDriver driver) {
        this.driver=driver;
    }

//    public AccountPage(TestContext testContext) {
//        this.testContext = testContext;
//    }

    public boolean isMyAccountLoaded(){
        return driver.findElement(lnkMyAccount).isDisplayed();
    }


}
