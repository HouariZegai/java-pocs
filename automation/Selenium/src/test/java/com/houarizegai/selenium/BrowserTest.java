package com.houarizegai.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author HouariZegai, created on 24/02/2021
 */
public class BrowserTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/learning/JavaLearning/automation/Selenium/src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}
