package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRegistrationPage {
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
        driver.findElement(By.className("ico-register")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("gender-female")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("FirstName")).sendKeys("Zeel");
        Thread.sleep(1000);
        driver.findElement(By.name("LastName")).sendKeys("Mohile");
        Thread.sleep(1000);
        driver.findElement(By.id("Email")).sendKeys(("Zeel@gmail.com"));
        Thread.sleep(1000);
        driver.findElement(By.id("Password")).sendKeys("Welcome123");
        Thread.sleep(1000);
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Welcome123");
        Thread.sleep(1000);
        driver.findElement(By.name("register-button")).click();
        Thread.sleep(3000);

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
