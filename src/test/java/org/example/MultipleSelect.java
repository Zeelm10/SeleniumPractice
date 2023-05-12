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

public class MultipleSelect {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void testMultipleSelect() throws InterruptedException {
        WebElement multipleselect = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(multipleselect);
        select.selectByVisibleText("Apple");
        Thread.sleep(3000);

        select.selectByIndex(1);
        Thread.sleep(3000);

        select.selectByValue("peach");

        List<WebElement> option = select.getOptions();
        for (WebElement value:option)
             {
                 System.out.println(value.getText());
        }
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
