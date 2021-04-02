package com.houarizegai.selenium.pompattern;

import com.houarizegai.selenium.pompattern.GoogleSearchTest;
import com.houarizegai.selenium.pompattern.pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author HouariZegai, created on 25/02/2021
 */
public class GoogleSearchTest {

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
        GoogleSearchPage.textBoxSearch(driver).sendKeys("houari zegai");

        Thread.sleep(100);

        GoogleSearchPage.searchBtn(driver).sendKeys(Keys.RETURN);

        Thread.sleep(5000);
    }
}
