package managers;

import org.openqa.selenium.WebDriver;
import pagesreal.AccountPage;
import pagesreal.LoginPage;
public class PageObjectManager {

	private final WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;

	public PageObjectManager(WebDriver driver) {
		// ✅ driverManager.getDriver() should return the ThreadLocal driver
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}

	public AccountPage getAccountPage() {
		if (accountPage == null) {
			accountPage = new AccountPage(driver);
		}
		return accountPage;
	}
}