package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IFrameClass {
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
    public void testIframe() throws InterruptedException{
        WebElement iframe = driver.findElement(By.id("courses-iframe"));
        Thread.sleep(3000);//this is just so you can observe how its working
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        WebElement searchtab = driver.findElement(By.xpath("//input[@id=\"search\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",searchtab);//this is to observe scrolling down)
        Thread.sleep(3000);
        searchtab.sendKeys("Selenium");
        searchtab.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
