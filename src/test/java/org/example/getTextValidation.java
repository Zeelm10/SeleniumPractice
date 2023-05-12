package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class getTextValidation {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";

    String expectedText = "SIGN IN";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void testSignInText() throws InterruptedException {
//        Thread.sleep(3000);
        String actualText = String.valueOf(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/nav/div/div[2]/div/div/a")).getText());
        System.out.println(actualText);

        assertEquals("Test is failed", expectedText,actualText);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
