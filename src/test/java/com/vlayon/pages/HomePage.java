package com.vlayon.pages;

import com.vlayon.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    private WebDriver driver;
    private String homePageUrl="https://www.ebay.co.uk/";

    public HomePage(WebDriver driver){
       super(driver);

    }

    @FindBy(id = "gh-ac")
    private WebElement searchField;

    @FindBy(id="gh-btn")
    private WebElement goButton;

    public void searchForText(String text){
        searchField.sendKeys(text);
        clickOn(goButton);
    }


}
