package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenURL{

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(5000);

        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        Thread.sleep(5000);

        driver.manage().window().maximize();
        driver.get("https://shop.mango.com/gb");
        Thread.sleep(5000);

        driver.close();
    }


}
