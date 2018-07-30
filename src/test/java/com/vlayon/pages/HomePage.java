package com.vlayon.pages;

import com.vlayon.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage extends BasePage {

   // private WebDriver driver;
    private static String homePageUrl="https://www.ebay.co.uk/";

    public HomePage(WebDriver driver){
       super(driver);
       PageFactory.initElements(driver,this);

    }

    @FindBy(id = "gh-ac")
    private WebElement searchField;

    @FindBy(id="gh-btn")
    private WebElement goButton;

    public void searchForText(String text){
        searchField.sendKeys(text);
        clickOn(goButton);
    }

    public void sendTextToElement(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }
}
