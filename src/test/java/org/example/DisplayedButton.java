package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisplayedButton {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void testDispaly() throws InterruptedException {
        driver.findElement(By.id("hide-textbox")).click();
        boolean ans = driver.findElement(By.id("displayed-text")).isDisplayed();
        assertFalse(ans);

        driver.findElement(By.id("show-textbox")).click();
        boolean ans1 = driver.findElement(By.id("displayed-text")).isDisplayed();
        assertTrue(ans1);
        driver.findElement(By.id("displayed-text")).sendKeys("Zeel Mehta");
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
