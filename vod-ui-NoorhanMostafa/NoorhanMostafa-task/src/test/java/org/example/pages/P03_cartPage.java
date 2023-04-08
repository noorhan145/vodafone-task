package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P03_cartPage {
    public WebElement ProceedToCheckoutBtn()
    {
        return driver.findElement(By.className("btn btn-red"));
    }
}
