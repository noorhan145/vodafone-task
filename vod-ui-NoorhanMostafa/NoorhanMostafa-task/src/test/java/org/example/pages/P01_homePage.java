package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P01_homePage {
    public WebElement englishLink()
    {
        return driver.findElement(By.className("lang"));
    }

    public WebElement iphoneIcon()
    {
        return driver.findElement(By.xpath("//a[@href=\"/shop/shopByBrand/Apple\"]"));
        //return driver.findElement(By.cssSelector("li:nth-child(7) > #shopByBrandCard"));

    }

    public WebElement productTitle()
    {
        return driver.findElement(By.xpath("(//a[@class=\"productList-cardLink\"])[1]"));
    }

    public WebElement addToCartBtn()
    {
        return driver.findElement(By.xpath("//button[@class=\"btn btn-red btn-block fontLightEnAr\"]"));
    }

    public WebElement CartIcon()
    {
        return driver.findElement(By.xpath("(//div[@class=\"ui-icon ui-icon-small shoppingCart\"])[1]"));
    }


}
