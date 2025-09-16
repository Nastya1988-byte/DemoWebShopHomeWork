package com.demo.tests;

import com.demoWeb.models.User;
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
    @Test
    public void newUserRegistrationPositiveTest() {
        String email = "test" + System.currentTimeMillis() + "@mail.com";
//        int i = (int)((System.currentTimeMillis()/1000)%3600);
        app.getUserRegister().clickOnRegisterLink();
        app.getUserRegister().fillRegisterLoginForm(new User()
                .setName("Anastasiia")
                .setLastName("Buch")
                .setEmail(email)
                .setPassword("test3457demoWeb#")
                .setConfirmPassword("test3457demoWeb#"));
        app.getUserRegister().clickOnRegisterButton();
        app.getUserRegister().clickOnContinueButton();
    }

    @Test
    public void newUserRegistrationNegativeTest(){
        String existingEmail = "existing_user@mail.com";
        app.getUserRegister().clickOnRegisterLink();
        app.getUserRegister().fillRegisterLoginForm(new User()
                .setName("Anastasiia")
                .setLastName("Buch")
                .setEmail(existingEmail)
                .setPassword("test345demoWeb#")
                .setConfirmPassword("test345demoWeb#"));
        app.getUserRegister().clickOnRegisterButton();
        Assert.assertTrue(app.getUserRegister().isErrorMessagePresent());
    }
}
