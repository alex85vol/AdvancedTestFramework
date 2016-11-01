package reg.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reg.pages.ATopPage.ChangeLanguageFields;
import reg.pages.LoginPage;

public class I18nTest {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\drivers\\chromedriver.jar");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		driver.get("http://registrator.herokuapp.com/login");
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		System.out.println("@AfterMethod");
		driver.get("http://registrator.herokuapp.com/logout");
	}

	@DataProvider//(parallel = true)
	public Object[][] localization() {
		return new Object[][] {
			{ ChangeLanguageFields.UKRAINIAN },
			{ ChangeLanguageFields.RUSSIAN },
			{ ChangeLanguageFields.ENGLISH }
			};
	}

	@Test(dataProvider = "localization")
	public void checkLocalization(ChangeLanguageFields language) throws Exception {
		// Precondition
		// TODO Remove from test
//		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.jar");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.get("http://registrator.herokuapp.com/login");
		//
		// Steps
		LoginPage loginPage = new LoginPage(driver);
		loginPage = loginPage.changeLanguage(language);
		//
		// Check
		Assert.assertEquals(loginPage.getLoginLabelText(),
				LoginPage.LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		Assert.assertEquals(loginPage.getPasswordLabelText(),
				LoginPage.LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
		Assert.assertEquals(loginPage.getSignintText(),
				LoginPage.LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		//
		// MUST BE DELETE
		Thread.sleep(5000);
		//
		// Return to previous state
		//driver.quit();
	}

}
