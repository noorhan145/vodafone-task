package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.fileReaders.FileReaders;
import org.example.pages.P01_homePage;
import org.example.pages.P02_productPage;
import org.example.pages.P03_cartPage;
import org.example.pages.P04_checkoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class S01_makeOrderStepDef {
    P01_homePage homePage = new P01_homePage();
    P02_productPage productPage = new P02_productPage();
    P03_cartPage cartPage = new P03_cartPage();
    P04_checkoutPage checkoutPage = new P04_checkoutPage();

    @When("user select language as “English”")
    public void selectEnglish(){
        homePage.englishLink().click();
    }

    @And("user go to “Shop By Brand” section and select “Iphone”")
    public void selectIphone() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,250);");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        //wait.until(ExpectedConditions.visibilityOf(homePage.iphoneIcon()));
        //wait.until(ExpectedConditions.elementToBeClickable(homePage.iphoneIcon()));
        //Thread.sleep(10000);
        homePage.iphoneIcon().click();
    }

    @And("user select any of returned iphone mobiles")
    public void selectProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.productTitle()));
        homePage.productTitle().click();

    }

    @And("user press add to cart")
    public void addToCart(){
        productPage.addToCartBtn().click();
    }

    @And("user press at cart icon")
    public void pressCartIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.addToCartBtn()));
        homePage.addToCartBtn().click();
        //homePage.cartIcon().click();

    }

    @And("user press Proceed to Checkout")
    public void pressProceedToCheckout(){
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,500);");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.ProceedToCheckoutBtn()));
        cartPage.ProceedToCheckoutBtn().click();
    }

    @And("user select “Delivery Options” as “Cairo” “Ain Shams”")
    public void selectDeliveryOptions(){

        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,250);");
        Select cityDropdown = new Select(checkoutPage.cityDropdown());
        cityDropdown.selectByVisibleText(FileReaders.getPropertyByKey("configData.properties", "city"));
        Select distinctDropdown = new Select(checkoutPage.districtDropdown());
        distinctDropdown.selectByVisibleText(FileReaders.getPropertyByKey("configData.properties", "distinct"));
    }

    @And("user select “Deliver to My Address”")
    public void pressDeliverToMyAddress(){
        checkoutPage.DelivaryToAddressBtn().click();
    }

    @And("user add address details")
    public void fillAddressDetails(){
        checkoutPage.streetField().sendKeys(FileReaders.getPropertyByKey("configData.properties", "street"));
        checkoutPage.buildingNoField().sendKeys(FileReaders.getPropertyByKey("configData.properties", "buildingNo"));
        checkoutPage.floorNoField().sendKeys(FileReaders.getPropertyByKey("configData.properties", "floorNo"));
        checkoutPage.apartmentNoField().sendKeys(FileReaders.getPropertyByKey("configData.properties", "apartmentNo"));
        checkoutPage.landmarkField().sendKeys(FileReaders.getPropertyByKey("configData.properties", "landmark"));
        checkoutPage.addressNameField().sendKeys(FileReaders.getPropertyByKey("configData.properties", "addressName"));


    }

    @And("user press continue after fill address")
    public void pressAddContinue(){
        checkoutPage.addressContinueBtn().click();
    }

    @And("user Leave Personal info. Tab empty and press continue")
    public void pressContinue(){
        checkoutPage.personalInfoContinueBtn().click();
    }

    @Then("error message returned from “Full Name” field")
    public void aseertFullNameErrorMsg(){
        String fullNameErrorMsg = checkoutPage.fullNameErrorMsg().getText().trim();
        Assert.assertTrue(fullNameErrorMsg.contains("enter a valid name"),"unmatched error massage");
    }
}
