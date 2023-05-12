package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void testOpenWindow(){
        String ParentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Handle:"+ParentWindow);
        driver.findElement(By.id("openwindow")).click();

        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Python");
        search.sendKeys(Keys.ENTER);

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
