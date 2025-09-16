package com.demoWeb.fw;

import com.demoWeb.models.RegisterUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends BaseHelper {

    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void fillLoginForm(RegisterUser registerUser){
        type(By.id("Email"), registerUser.getEmail());
        type(By.id("Password"), registerUser.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//input[@value='Log in']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }
    public void clickOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }
}
