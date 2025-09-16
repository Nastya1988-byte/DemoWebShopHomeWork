package com.demo.tests;

import com.demoWeb.models.RegisterUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (!app.getUserLogin().isLoginLinkPresent()) {
            app.getUserLogin().clickOnLogOutButton();
        }
        if (!app.getHome().isHomePagePresent()) {
            app.getHome().clickOnHomeElement();
        }
            app.getUserLogin().clickOnLoginLink();
            app.getUserLogin().fillLoginForm(new RegisterUser()
                    .setEmail("test345demoWeb#@mail.com")
                    .setPassword("test345demoWeb#"));
            app.getUserLogin().clickOnLoginButton();

    }

    @Test
    public void addToCardPositiveTest() {
        app.getAdd().addToCard();
        Assert.assertTrue(app.getAdd().isProductAdded());
    }

}


