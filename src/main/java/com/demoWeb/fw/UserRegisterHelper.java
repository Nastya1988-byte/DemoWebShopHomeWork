package com.demoWeb.fw;

import com.demoWeb.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegisterHelper extends BaseHelper {


    public UserRegisterHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterLink() {
        click(By.xpath("//a[text()='Register']"));
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void clickOnContinueButton() {
        click(By.xpath("//input[@class='button-1 register-continue-button']"));
    }

    public void fillRegisterLoginForm(User user) {
        type(By.id("FirstName"), user.getName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getConfirmPassword());
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By
                .cssSelector("div[class='validation-summary-errors'] ul li"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isRegisterLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/register']"));
    }
}
