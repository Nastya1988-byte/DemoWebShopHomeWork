package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHome().isHomePagePresent()) {
            app.getHome().clickOnHomeElement();
        }
    }

    @Test
    public void isHomePagePresentTest() {
        Assert.assertTrue(app.getHome().isHomePagePresent());
    }

}
