package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openNopCommerceURL() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("Email")).sendKeys("test@test.com");
        Thread.sleep(3000);
        driver.findElement(By.id("Password")).sendKeys("Welcome123");
        Thread.sleep(3000);
        driver.findElement(By.className("login-button")).click();
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
