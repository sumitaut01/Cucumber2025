package managers;

import org.openqa.selenium.WebDriver;
import pagesreal.AccountPage;
import pagesreal.LoginPage;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;

	private AccountPage accountPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage(){
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public AccountPage getAccountPage(){
		return (accountPage == null) ? accountPage = new AccountPage(driver) : accountPage;
	}







}