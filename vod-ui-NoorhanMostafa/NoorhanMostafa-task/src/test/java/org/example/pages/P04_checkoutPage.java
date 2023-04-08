package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P04_checkoutPage {
    public WebElement cityDropdown()
    {
        return driver.findElement(By.xpath("//div[@class=\"col-md-4 col-sm-12 checkout-dropdownCity checkoutDeleiveryOptionsPhase2EditWidth\"]/select"));
    }

    public WebElement districtDropdown()
    {
        return driver.findElement(By.xpath("(//select[@class=\"btn dropdown-toggle checkout-dropdown border-radius_Style checkoutDeliveryFamilyFont ng-pristine ng-valid ng-touched\"])[2]"));
    }

    public WebElement DelivaryToAddressBtn()
    {
        return driver.findElement(By.className("checkout-DelivaryToAddress"));
    }

    public WebElement streetField()
    {
        return driver.findElement(By.xpath("//div[@class=\"addressName\"]//input"));
    }

    public WebElement buildingNoField()
    {
        return driver.findElement(By.xpath("(//div[@class=\"addressDetails\"]//input)[0]"));
    }

    public WebElement floorNoField()
    {
        return driver.findElement(By.xpath("(//div[@class=\"addressDetails\"]//input)[1]"));
    }

    public WebElement apartmentNoField()
    {
        return driver.findElement(By.xpath("(//div[@class=\"addressDetails\"]//input)[2]"));
    }

    public WebElement landmarkField()
    {
        return driver.findElement(By.xpath("(//div[@class=\"addressMark\"]//input)[0]"));
    }

    public WebElement addressNameField()
    {
        return driver.findElement(By.xpath("(//div[@class=\"addressMark\"]//input)[1]"));
    }

    public WebElement addressContinueBtn()
    {
        return driver.findElement(By.xpath("//div[@class=\"checkout-addressBtn\"]/button"));
    }

    public WebElement personalInfoContinueBtn()
    {
        return driver.findElement(By.id("shippingAddressContinue"));
    }

    public WebElement fullNameErrorMsg()
    {
        return driver.findElement(By.xpath("//div[@class=\"help-block alertComp\"]"));
    }

}
