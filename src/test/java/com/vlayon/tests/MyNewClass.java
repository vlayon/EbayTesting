package com.vlayon.tests;

import com.vlayon.pages.HomePage;
import com.vlayon.pages.LoginPage;
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

public class MyNewClass {
private WebDriver driver;
private String driverPath= "D:\\Setup\\CromeDriver\\chromedriver.exe";

    @BeforeSuite
    public void BeforeSuite(){
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeTest
    public void BeforeTest() {

        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.ebay.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    public void LoginTest() {
        LoginPage logInPage= new LoginPage(driver);
        logInPage.goToLoginPage();
        logInPage.logIn("lookironic@gmail.com","AutomationT3sts");
        Assert.assertEquals(logInPage.getLogInGreetings(),  "Hello Automation.","You are not logged");


    }

    @Test
    public void SearchTest(){
        HomePage homePage= new HomePage(driver);
        homePage.searchForText("bike mudguard");

    }
    @AfterTest
    public void AfterTest() {
     driver.quit();
    }
}
