package com.houarizegai.selenium.pompattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author HouariZegai, created on 25/02/2021
 */
public class GoogleSearchPage {
    private static WebElement searchBox;
    private static WebElement searchBtn;

    public static WebElement textBoxSearch(WebDriver driver) {
        searchBox = driver.findElement(new By.ByName("q"));
        return searchBox;
    }

    public static WebElement searchBtn(WebDriver driver) {
        searchBtn = driver.findElement(new By.ByName("btnK"));
        return searchBtn;
    }
}
