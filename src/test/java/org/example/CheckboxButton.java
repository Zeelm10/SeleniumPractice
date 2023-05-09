package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckboxButton {
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
    public void testCheckBox(){
        WebElement bmwcheckbox = driver.findElement(By.id("bmwcheck"));
        bmwcheckbox.click();

        WebElement benzcheckbox = driver.findElement(By.id("benzcheck"));
        benzcheckbox.click();

        WebElement hondacheckbox = driver.findElement(By.id("hondacheck"));

        boolean ans1 = driver.findElement(By.id("hondacheck")).isSelected();
        assertFalse(ans1);

        System.out.println("BMW Checkbox is selected?" + bmwcheckbox.isSelected());
        System.out.println("Honda Checkbox is selected?" + hondacheckbox.isSelected());

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
