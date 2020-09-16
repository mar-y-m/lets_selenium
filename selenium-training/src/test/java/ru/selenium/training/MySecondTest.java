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

public class MySecondTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void MyFirstTest(){
        driver.get("http://localhost/litecart/admin/");
        System.out.println(driver.getTitle());
        String text = "My Store";
        wait.until(titleIs(text));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).submit();
        System.out.println(driver.getTitle());
        String text1 = "Dashboard | My Store";
        wait.until(titleIs(text1));
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println(driver.getTitle());
        wait.until(titleIs(text));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
