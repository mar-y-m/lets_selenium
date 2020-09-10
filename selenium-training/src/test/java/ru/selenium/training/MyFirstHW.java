package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstHW {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        //System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void MyFirstTest(){
        driver.get("http://www.google.com/");
        System.out.println(driver.getTitle());
        String text = "Google";
        wait.until(titleIs(text));
        driver.get("http://www.yandex.ru/");
        System.out.println(driver.getTitle());
        String text1 = "Яндекс";
        wait.until(titleIs(text1));
        driver.get("http://oneportal.t-systems.ru/");
        System.out.println(driver.getTitle());
        String text2 = "ONE PORTAL";
        wait.until(titleIs(text2));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
