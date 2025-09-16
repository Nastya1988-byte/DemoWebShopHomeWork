package com.demoWeb.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCardHelper extends BaseHelper {

    public AddToCardHelper(WebDriver driver) {
        super(driver);
    }

    public void addToCard() {
        click(By.xpath("(//input[@value='Add to cart'])[2]"));
    }

    public boolean isProductAdded() {
        click(By.xpath("//span[.='Shopping cart']"));
        List<WebElement> cardElements = driver
                .findElements(By.xpath("(//a[text()='14.1-inch Laptop'])[2]"));
        for (WebElement element:cardElements){
            if (element.getText()!= null);
            return true;
        }
        return false;
    }
}
