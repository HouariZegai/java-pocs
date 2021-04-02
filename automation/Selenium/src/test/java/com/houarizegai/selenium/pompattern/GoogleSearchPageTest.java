package com.houarizegai.selenium.pompattern;

import com.houarizegai.selenium.pompattern.pages.GoogleSearchPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author HouariZegai, created on 25/02/2021
 */
public class GoogleSearchPageTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void searchInGoogleTest() throws InterruptedException {
        driver.get("https://google.com");

        GoogleSearchPageObjects googleSearchPageObjects = new GoogleSearchPageObjects(driver);

        googleSearchPageObjects.setTextInSearchBox("Selenium with POM");

        Thread.sleep(1000);

        googleSearchPageObjects.clickSearchBtn();

        Thread.sleep(5000);
    }
}
