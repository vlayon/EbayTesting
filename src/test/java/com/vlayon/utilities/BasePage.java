package com.vlayon.utilities;


import com.google.common.collect.ImmutableMap;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.List;

import static com.sun.media.jfxmedia.logging.Logger.*;

public  abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait wait ;
    private final static Logger myLogger = Logger.getLogger(BasePage.class.getName());


    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);

    }

    protected WebDriver getDriver(){
            return this.driver;
    }

       protected void clickOn(WebElement element) {
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            myLogger.info("element is clicked");



        } catch (ElementNotVisibleException enve) {
            System.out.println("Element \"" + element + "is not visible");
            myLogger.severe("element was not visible");
        }

    }

    public void sendTextToElement(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
        myLogger.info("text sent to element");

    }
}

