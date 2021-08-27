package com.houarizegai.selenium.pompattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author HouariZegai, created on 25/02/2021
 */
public class GoogleSearchPageObjects {

    WebDriver driver;
    By textBoxSearch = new By.ByName("q");
    By btnSearch = By.name("btnK");

    public GoogleSearchPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void setTextInSearchBox(String text) {
        WebElement searchBox = driver.findElement(textBoxSearch);
        searchBox.sendKeys(text);
    }

    public void clickSearchBtn() {
        driver.findElement(btnSearch).sendKeys(Keys.RETURN);
    }
}
