package testCases;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestLogin extends BaseClass {

    @Test(dataProvider = "loginDetails",dataProviderClass = CustomDataProvider.class)
    public void loginToApplication(String userName,String password){

        LoginPage login = new LoginPage(driver);

        boolean loginResult = (boolean) login.loginToApp(userName,password);


        /*
        if (loginResult){
            Reporter.log("succesfully logged in");
        } else {
            Assert.fail("please enter proper login details");
        }

         */

        // add an Assertion here

        Assert.assertTrue(loginResult);

        // then logOut

        // then return HomePage PageObject i think

    }
}
