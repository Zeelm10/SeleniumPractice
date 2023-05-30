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

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchTab {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void testSwitchtab() throws InterruptedException{
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);
        driver.findElement(By.id("opentab")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);//to see all window unique ids
        for (String handle : allWindowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                WebElement searchTab = driver.findElement(By.xpath("//input[@id=\"search\"]"));
                searchTab.sendKeys("selenium");
                searchTab.sendKeys(Keys.ENTER);
                Thread.sleep(3000);
                driver.close();}
            driver.switchTo().window(parentWindowHandle);
            driver.findElement(By.xpath("//input[@id=\"hondaradio\"]")).click();
            Thread.sleep(3000);
        }
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
