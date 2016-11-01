package com.softserve.edu.reg.apps;

public final class ApplicationSourcesRepository {

	private ApplicationSourcesRepository() {
	}

	public static ApplicationSources getDefault() {
		return getChromeHeroku();
	}

	// Application for Firefox browser

	public static ApplicationSources getFirefoxHeroku() {
		return ApplicationSources.get()
				.setBrowserName("Firefox")
				.setDriverPath("src\\main\\resources\\drivers\\geckodriver.jar")
				.setBrowserPath(" ")
				.setDefaultProfile(" ")
				.setImplicitTimeOut(5L)
				.setExplicitTimeOut(5L)
				.setLanguage(" ")
				.setSearchStrategy(" ")
				.setLoggerStrategy(" ")
				.setLoginUrl("http://registrator.herokuapp.com/login")
				.setLogoutUrl("http://registrator.herokuapp.com/logout")
				.setServerUrl(" ")
				.build();
	}

	// Application for Chrome browser

	public static ApplicationSources getChromeHeroku() {
		return ApplicationSources.get()
				.setBrowserName("Chrome")
				.setDriverPath("src\\main\\resources\\drivers\\chromedriver.jar")
				.setBrowserPath(" ")
				.setDefaultProfile(" ")
				.setImplicitTimeOut(5L)
				.setExplicitTimeOut(5L)
				.setLanguage(" ")
				.setSearchStrategy(" ")
				.setLoggerStrategy("")
				.setLoginUrl("http://registrator.herokuapp.com/login")
				.setLogoutUrl("http://registrator.herokuapp.com/logout")
				.setServerUrl("")
				.build();
	}

	// Application for IE browser

	public static ApplicationSources getIEHeroku() {
		return ApplicationSources.get()
				.setBrowserName("IE")
				.setDriverPath("src\\main\\resources\\drivers\\chromedriver.jar")
				.setBrowserPath(" ")
				.setDefaultProfile(" ")
				.setImplicitTimeOut(5L)
				.setExplicitTimeOut(5L)
				.setLanguage(" ")
				.setSearchStrategy(" ")
				.setLoggerStrategy("")
				.setLoginUrl("http://registrator.herokuapp.com/login")
				.setLogoutUrl("http://registrator.herokuapp.com/logout")
				.setServerUrl("")
				.build();
	}

	// Application for HTMLUnit browser

	public static ApplicationSources getHtmlUnitHeroku() {
		return ApplicationSources.get()
				.setBrowserName("HtmlUnit")
				.setDriverPath(" ")
				.setBrowserPath(" ")
				.setDefaultProfile(" ")
				.setImplicitTimeOut(5L)
				.setExplicitTimeOut(5L)
				.setLanguage("")
				.setSearchStrategy(" ")
				.setLoggerStrategy(" ")
				.setLoginUrl("http://registrator.herokuapp.com/login")
				.setLogoutUrl("http://registrator.herokuapp.com/logout")
				.setServerUrl("")
				.build();
	}

}
