package com.houarizegai.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.WebSocket;
import java.time.Duration;
import java.util.List;

/**
 * @author HouariZegai, created on 24/02/2021
 */
public class DriverManagerTest {

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
            driver.quit();
        }
    }

    @Test
    public void instagramAccountLoginTest() throws InterruptedException {
        driver.get("https://www.instagram.com/");
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        List<WebElement> loginFields = driver.findElements(new By.ByTagName("input"));

        loginFields.get(0).sendKeys("houarizegai");
        loginFields.get(1).sendKeys("0000");
        loginFields.get(0).submit();

        Thread.sleep(Duration.ofSeconds(15).toMillis());

        driver.close();
    }

    @Test
    public void searchInGoogleTest() throws InterruptedException {
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(new By.ByName("q"));
        searchBox.sendKeys("houari zegai");

        Thread.sleep(2000);

        WebElement searchBtn = driver.findElement(new By.ByName("btnK"));
        searchBtn.click();

        Thread.sleep(15000);
    }
}
