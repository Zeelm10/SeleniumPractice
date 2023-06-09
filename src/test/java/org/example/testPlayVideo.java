package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class testPlayVideo {

    public WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testVideo() throws InterruptedException {
        driver.get("https://www.youtube.com/watch?v=u2NAuswnTKs");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById(\"video\").play()");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@aria-label=Accept the use of cookies and other data for the purposes described]")).click();
        driver.findElement(By.className("ytp-play-button ytp-button")).click();

//        js .executeScript("document.getElementById(\"video\").load()");
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
