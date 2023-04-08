package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.example.fileReaders.FileReaders;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    @Before
    public static void OpenBrowser()
    {
        if(driver == null){
            if((FileReaders.getPropertyByKey("configData.properties", "Browser")).equalsIgnoreCase("firefox"))
            {
                driver = new FirefoxDriver();
            }
            else if((FileReaders.getPropertyByKey("configData.properties", "Browser")).equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(FileReaders.getPropertyByKey("configData.properties", "App_URL"));

    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
}

