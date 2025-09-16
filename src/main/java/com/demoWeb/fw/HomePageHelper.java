package com.demoWeb.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePagePresent() {
        return isElementPresent(By.xpath("//h2[contains(text(),'Welcome to our store')]"));

    }


    public void clickOnHomeElement() {
        click(By.cssSelector("img[alt='Tricentis Demo Web Shop']"));
        waitUntilHomePageIsLoaded();
    }

    public void waitUntilHomePageIsLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(text(),'Welcome to our store')]")));
    }
}
