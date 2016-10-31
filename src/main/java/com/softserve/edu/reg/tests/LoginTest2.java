package com.softserve.edu.reg.tests;


import com.softserve.edu.reg.apps.ApplicationSources;
import com.softserve.edu.reg.data.IUser;
import com.softserve.edu.reg.data.UserRepository;
import com.softserve.edu.reg.pages.Application;
import com.softserve.edu.reg.pages.LoginPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Demon on 30.10.2016.
 */
public class LoginTest2 {

    @BeforeSuite
    public void warmUp(){
    ;




    }

    @Test
    public void testLogin(ApplicationSources applicationSources, IUser admin) throws Exception {
        // Precondition
        LoginPage loginPage = null;
        //
        // Steps
        loginPage.clearLoginInput();
        loginPage.getLoginInput().sendKeys(UserRepository.getAdmin().getLogin());
        loginPage.clearPasswordInput();
        loginPage.getPasswordInput().sendKeys(UserRepository.getAdmin().getPassword());

        //
        // Return to previous state
        Thread.sleep(2000);
        //adminHomePage.clickLogout();
        Thread.sleep(2000);
    }

    @AfterSuite
    public void tearDown(){
        Application.get().quit();
    }
}
