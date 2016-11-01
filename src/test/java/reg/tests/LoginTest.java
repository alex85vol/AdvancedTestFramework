package reg.tests;


import reg.apps.ApplicationSources;
import reg.apps.ApplicationSourcesRepository;
import reg.data.IUser;
import reg.data.UserRepository;
import reg.pages.AdminHomePage;
import reg.pages.Application;
import reg.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Demon on 30.10.2016.
 */
public class LoginTest {

    @AfterClass
    public void tearDownClass(){
        Application.remove();
    }

    @AfterMethod
    public void tearDownMethod(){
        Application.remove();
    }

    @DataProvider //(parallel = true)
    public Object[][] adminUsers() {
        return new Object[][] {
                { ApplicationSourcesRepository.getChromeHeroku(), UserRepository.getAdmin() },
                { ApplicationSourcesRepository.getFirefoxHeroku(), UserRepository.getAdmin() }};
    }

    @Test   (dataProvider = "adminUsers")
    public void testLogin(ApplicationSources applicationSources, IUser admin) throws Exception{
        // Precondition
        LoginPage loginPage = Application.get(applicationSources).load();
        AdminHomePage adminHomePage = loginPage.successAdminLogin(admin);       //
        // Steps
        Assert.assertEquals(admin.getLogin(),
                adminHomePage.getLoginAccountText());
        Thread.sleep(5000);
        //
        // Return to previous state

        adminHomePage.clickLogout();
        Thread.sleep(5000);

    }


}
