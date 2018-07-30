package com.vlayon.pages;

import com.vlayon.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
    //implementing POM with PageFactory
    private static String logInPageUrl = "https://signin.ebay.co.uk/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.co.uk%2F";

    @FindBy(id = "userid")
    private WebElement userNameField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "sgnBt")
    private WebElement logInButton;

    @FindBy(id = "gh-ug")
    private WebElement logInGreetings;

    public String getLogInGreetings() {
        return logInGreetings.getText();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);


    }
    public void goToLoginPage(){
        super.getDriver().get(logInPageUrl);

    }

    public void logIn(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        clickOn(logInButton);

    }


}
