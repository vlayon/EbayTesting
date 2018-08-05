package com.vlayon.tests;

import com.vlayon.pages.HomePage;
import com.vlayon.pages.LoginPage;
import com.vlayon.utilities.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class MyNewClass {
private  WebDriver driver;
private String chromeDriverPath= "D:\\Setup\\CromeDriver\\chromedriver.exe";
private LoginPage logInPage;
private final static Logger myLogger = Logger.getLogger(MyNewClass.class.getName());

   @BeforeSuite
   public void BeforeSuite(){
       try {
           MyLogger.setup();
           myLogger.info("Logger setUp finished");
       } catch (IOException e) {
           e.printStackTrace();
           throw new RuntimeException("Problems with creating the log files");
       } }

   @BeforeTest
   public void BeforeTest() {
       System.setProperty("webdriver.chrome.driver", chromeDriverPath);
       this.driver= new ChromeDriver();
       driver.manage().deleteAllCookies();
       driver.get("https://www.ebay.co.uk/");
       driver.manage().window().maximize();

   }

    @Test
    public void LoginTest() {
        logInPage= new LoginPage(driver);
        logInPage.goToLoginPage();
        logInPage.logIn("lookironic@gmail.com","AutomationT3sts");
        Assert.assertEquals(logInPage.getLogInGreetings(),  "Hello Automation.","You are not logged");


    }

   @Test
   public void SearchTest(){
       HomePage homePage= new HomePage(driver);
       homePage.goToHomePage();
       Assert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay", "Page not loaded");
       homePage.searchForText("bike mudguard");

   }
   @AfterTest
   public void AfterTest() {
    driver.quit();
   }
}
