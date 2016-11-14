package com.softserve.edu.reg.pages;

import com.softserve.edu.reg.apps.ApplicationSources;
import com.softserve.edu.reg.apps.ApplicationSourcesRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Application {

	private interface IBrowser {
		WebDriver getBrowser(Application application);
	}

	private static class FirefoxTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			System.setProperty("webdriver.gecko.driver",
					application.applicationSources.getDriverPath());
			return new FirefoxDriver();
		}
	}

	private static class ChromeTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			System.setProperty("webdriver.chrome.driver",
					application.applicationSources.getDriverPath());
			return new ChromeDriver();
		}
	}

	private static class HtmlUnitTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			WebDriver driver = null;
			return driver;
		}
	}

	public static enum Browsers {
		DEFAULT_TEMPORARY("ChromeTemporary", new ChromeTemporary()),
		FIREFOX_TEMPORARY("FireFoxTemporary", new FirefoxTemporary()),
		CHROME_TEMPORARY("ChromeTemporary", new ChromeTemporary()),
		HTMLUNIT_TEMPORARY("HtmlUnitTemporary", new HtmlUnitTemporary());
		//
		private String browserName;
		private IBrowser browser;

		private Browsers(String browserName, IBrowser browser) {
			this.browserName = browserName;
			this.browser = browser;
		}

		public WebDriver runBrowser(Application application) {

			return browser.getBrowser(application);
		}

		@Override
		public String toString() {
			return browserName;
		}
	}

	// fields
	
	private static volatile Application instance;
	private WebDriver driver;
	private ApplicationSources applicationSources;

	private Application(ApplicationSources applicationSources) {
		this.applicationSources = applicationSources;
	}

	public static Application get() {
		return get(null);
	}

	public static Application get(ApplicationSources applicationSources) {
		if (instance == null) {
			synchronized (Application.class) {
				if (instance == null) {
					if (applicationSources == null) {
						applicationSources = ApplicationSourcesRepository.getDefault();
					}
					instance = new Application(applicationSources);
					instance.init();
				}
			}
		}
		return instance;
	}

	public static void remove() {
		if (instance != null) {
			instance.quit();
		}
		instance = null;
	}

	public void init() {
		initWebDriver();
		// TODO
	}

	public LoginPage load() {
		//logout();
		driver.get(applicationSources.getLoginUrl());
		return new LoginPage(driver);
	}

	public LoginPage logout() {
		driver.get(applicationSources.getLogoutUrl());
		return new LoginPage(driver);
	}

	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	private void initWebDriver() {
		Browsers currentBrowser = Browsers.DEFAULT_TEMPORARY;
		for (Browsers browser : Browsers.values()) {
			if (browser.toString().toLowerCase()
					.contains(applicationSources.getBrowserName().toLowerCase())) {
				currentBrowser = browser;
				break;
			}
		}
		driver = currentBrowser.runBrowser(this);
		driver.manage().timeouts()
			.implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
	}

}
