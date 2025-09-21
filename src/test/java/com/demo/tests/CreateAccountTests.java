package com.demo.tests;

import com.demoWeb.data.UserData;
import com.demoWeb.models.User;
import com.demoWeb.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUserRegister().isRegisterLinkPresent()){
            app.getUserRegister().clickOnLogOutButton();
        }
    }
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {

        app.getUserRegister().clickOnRegisterLink();
        app.getUserRegister().fillRegisterLoginForm(new User()
                .setName(UserData.NAME)
                .setLastName(UserData.LastNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.ConfirmPASSWORD));
        app.getUserRegister().clickOnRegisterButton();
        app.getUserRegister().clickOnContinueButton();
    }
    @Test(enabled = false)
//    (dataProvider = "newUserRegistrationWithCsv", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveWithCsvFileTest(User user) {

        app.getUserRegister().clickOnRegisterLink();
        app.getUserRegister().fillRegisterLoginForm(user);
        app.getUserRegister().clickOnRegisterButton();
        app.getUserRegister().clickOnContinueButton();
    }

    @Test
    public void newUserRegistrationNegativeTest(){

        app.getUserRegister().clickOnRegisterLink();
        app.getUserRegister().fillRegisterLoginForm(new User()
                .setName(UserData.NAME)
                .setLastName(UserData.LastNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.ConfirmPASSWORD));
        app.getUserRegister().clickOnRegisterButton();
        Assert.assertTrue(app.getUserRegister().isErrorMessagePresent());
    }
}
