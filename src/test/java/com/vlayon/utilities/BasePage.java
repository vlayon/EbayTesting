package com.vlayon.utilities;


import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public  abstract class BasePage {

    private WebDriver driver= new ChromeDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 20);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

protected WebDriver getDriver(){
        return this.driver;
}

       protected void clickOn(WebElement element) {
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();


        } catch (ElementNotVisibleException enve) {
            System.out.println("Element \"" + element + "is not visible");
        }

    }
}

