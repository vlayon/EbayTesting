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
private static WebDriver driver;

    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Setup\\CromeDriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        //driver.get("https://www.ebay.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    public void LoginTest() {
        driver.get("https://signin.ebay.co.uk/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.co.uk%2F");
        LoginPage logInPage= new LoginPage(driver);
        logInPage.setUserName("lookironic@gmail.com");
        logInPage.setPassword("AutomationT3sts");
        logInPage.clickLogInButton();
        WebElement logInGreetings= driver.findElement(By.id("gh-ug"));
        String result= logInGreetings.getText();
        Assert.assertEquals(result,  "Hello Automation.","You are not logged");


    }

    @Test
    public void SearchTest(){
        HomePage homePage= new HomePage(driver);
        homePage.writeInSearcField("bike mudguard");
        homePage.clickOverGoButton();
    }
    @AfterTest
    public void AfterTest() {
     // driver.quit();
    }
}
