package com.vlayon.pages;

import com.vlayon.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    //implementing POM with PageFactory
   private WebDriver driver;
    private String logInPageUrl = "https://signin.ebay.co.uk/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.co.uk%2F";

    @FindBy(id = "userid")
    private WebElement userNameField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "sgnBt")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public void setUserName(String userName){
        userNameField.sendKeys(userName);

    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLogInButton(){
        clickOn(logInButton);
    }
}
