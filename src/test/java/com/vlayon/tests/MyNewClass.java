package com.vlayon.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyNewClass {
private static WebDriver driver;

    @BeforeSuite
    public void BeforeSuite() {
        System.setProperty("webdriver.chrome.driver", "D:\\Setup\\CromeDriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.ebay.co.uk/");
    }

    @Test
    public void FirstTest() {
        WebElement searchField= driver.findElement(By.id("gh-ac"));
        searchField.click();
        searchField.sendKeys("mudguard bicycle");
        WebElement goButton=driver.findElement(By.id("gh-btn"));
        goButton.click();

    }
    @AfterTest
    public void AfterTest() {
        driver.quit();
    }
}
