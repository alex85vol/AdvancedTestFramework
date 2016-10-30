package com.softserve.edu.reg.apps;

public final class ApplicationSourcesRepository {

	private ApplicationSourcesRepository() {
	}

	public static ApplicationSources getDefault() {
		return getChromeHeroku();
	}

	public static ApplicationSources getFirefoxHeroku() {
		return ApplicationSources.get()
				.setBrowserName("Firefox")
				.setDriverPath("src\\main\\resources\\drivers\\geckodriver.exe")
				.setImplicitTimeOut(5L)
				.setLoginUrl("http://registrator.herokuapp.com/login")
				.setLogoutUrl("http://registrator.herokuapp.com/logout")
				.build();
	}

	public static ApplicationSources getChromeHeroku() {
		return ApplicationSources.get()
				.setBrowserName("Chrome")
				.setDriverPath("src\\main\\resources\\drivers\\chromedriver.exe")
				.setImplicitTimeOut(5L)
				.setLoginUrl("http://registrator.herokuapp.com/login")
				.setLogoutUrl("http://registrator.herokuapp.com/logout")
				.build();
	}

	public static ApplicationSources getHtmlUnitHeroku() {
		return ApplicationSources.get()
				.setBrowserName("HtmlUnit")
				.setDriverPath("")
				.setImplicitTimeOut(5L)
				.setLoginUrl("http://registrator.herokuapp.com/login")
				.setLogoutUrl("http://registrator.herokuapp.com/logout")
				.build();
	}

}
