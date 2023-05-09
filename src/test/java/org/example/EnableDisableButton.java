package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;


public class EnableDisableButton {
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
    public void testEnableDisableBtn() throws InterruptedException {
       driver.findElement(By.id("disabled-button")).click();
       boolean ans = driver.findElement(By.id("enabled-example-input")).isEnabled();
       assertFalse(ans);

        driver.findElement(By.id("enabled-button")).click();
        boolean ans1 = driver.findElement(By.id("enabled-example-input")).isEnabled();
        assertTrue(ans1);
        driver.findElement(By.id("enabled-example-input")).sendKeys("Zeel Mehta");
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
