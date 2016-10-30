package com.softserve.edu.reg.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.reg.apps.ApplicationSources;
import com.softserve.edu.reg.apps.ApplicationSourcesRepository;
import com.softserve.edu.reg.data.IUser;
import com.softserve.edu.reg.data.UserRepository;
import com.softserve.edu.reg.pages.AdminHomePage;
import com.softserve.edu.reg.pages.Application;
import com.softserve.edu.reg.pages.LoginPage;

public class LoginTest {

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
		Application.remove();
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		System.out.println("@AfterMethod");
		//Application.get().logout();
		Application.remove();
	}

	@DataProvider //(parallel = true)
	public Object[][] adminUsers() {
		return new Object[][] {
			{ ApplicationSourcesRepository.getChromeHeroku(), UserRepository.getAdmin() },
			{ ApplicationSourcesRepository.getFirefoxHeroku(), UserRepository.getAdmin() }
		};
	}

	@Test 	(dataProvider = "adminUsers")
	public void checkAdminLogin(ApplicationSources applicationSources, IUser admin) throws Exception {
		// Precondition
		//
		// Steps
		LoginPage loginPage = Application.get(applicationSources).load();
		AdminHomePage adminHomePage = loginPage.successAdminLogin(admin);
		//
		// Check
		Assert.assertEquals(admin.getLogin(),
				adminHomePage.getLoginAccountText());
		//
		// Return to previous state
		Thread.sleep(2000);
		adminHomePage.clickLogout();
		Thread.sleep(2000);
	}

}
