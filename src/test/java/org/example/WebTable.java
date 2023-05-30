package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebTable {
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
    public void testWebTable() throws InterruptedException{
        for(int i =2;i<=4;i++) {
            for (int j = 1; j <= 3; j++) {
                String actualTableText = driver.findElement(By.xpath("//table[@id=\"product\"]/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.println(actualTableText);
            }
        }
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
