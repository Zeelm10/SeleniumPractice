package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testPlayVideo {

    public WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testVideo() throws InterruptedException {
        driver.get("https://www.youtube.com/watch?v=u2NAuswnTKs");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById(\"video\").play()");
        Thread.sleep(3000);
        driver.findElement(By.className("yt-spec-touch-feedback-shape__fill")).click();
        driver.wait();
        driver.findElement(By.className("ytp-play-button ytp-button")).click();

//        js .executeScript("document.getElementById(\"video\").load()");
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
