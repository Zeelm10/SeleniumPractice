package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenURLwithJunit {
  public WebDriver driver;

  @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openYoutubeURL(){
        driver.get("https://www.youtube.com/");
        driver.close();
    }
    @Test
    public void openMangoURL(){
        driver.get("https://shop.mango.com/gb");
        driver.close();
    }
    @Test
    public void openNopCommerceURL(){
        driver.get("https://demo.nopcommerce.com/");
        driver.close();
    }

    @Test
    public void openNetflixURL(){
        driver.get("https://www.netflix.com/");
        driver.close();
    }

    @Test
    public void openNextURL(){
        driver.get("https://www.next.co.uk/");
        driver.close();
    }
    @After
    public void tearDown(){
      driver.close();
    }
}
