package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RadioButton {

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
    public void checkRadioButton() throws InterruptedException {
        driver.findElement(By.id("bmwradio")).click();
        Thread.sleep(3000);
        boolean ans = driver.findElement(By.id("bmwradio")).isSelected();
        assertEquals(true,ans);
        boolean ans1 = driver.findElement(By.id("hondaradio")).isSelected();
        assertEquals(false,ans1);

        System.out.println("BMW Radio Button is selected? " + ans);
        System.out.println("Honda Radio Button is selected? " + ans1);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
