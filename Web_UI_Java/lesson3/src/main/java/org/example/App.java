package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class App {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");//режим инкогнито
        //options.addArguments("--headless"); //тесты не открывая браузер
        options.addArguments("start-maximized");//открытие окна на полную

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        driver.findElement(By.cssSelector(".center:nth-child(1) > .btn")).click();
        driver.findElement(By.id("userSelect")).click();
        {
            WebElement dropdown = driver.findElement(By.id("userSelect"));
            dropdown.findElement(By.xpath("//option[. = 'Harry Potter']")).click();
        }
        driver.findElement(By.cssSelector(".btn-default")).click();
        driver.findElement(By.xpath(".//div[3]/button[2]")).click();
        driver.findElement(By.cssSelector(".form-control")).click();
        driver.findElement(By.cssSelector(".form-control")).sendKeys("33333");
        driver.findElement(By.cssSelector(".btn-default")).click();
    }
}


