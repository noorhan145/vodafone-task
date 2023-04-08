package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P02_productPage {
    public WebElement addToCartBtn()
    {
        return driver.findElement(By.xpath("//button[@class=\"btn btn-red btn-block fontLightEnAr\"]"));
    }
}
