package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DropdownSelect {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";

    String expected = "Benz";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void testDropdown() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("carselect"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Benz");
        Thread.sleep(3000);
        String actual = select.getFirstSelectedOption().getText();

        List<WebElement> options = select.getOptions();

        for (WebElement option:options){
            System.out.println(option.getText());
        }



        assertEquals("Test is not working",expected,actual);

        select.selectByIndex(2);
        Thread.sleep(3000);

        select.selectByValue("bmw");
        Thread.sleep(3000);


    }
    @After
    public void tearDown(){
        driver.close();
    }
}
