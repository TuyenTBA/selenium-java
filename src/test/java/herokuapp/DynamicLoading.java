package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class DynamicLoading {
    @Test
    void waiting() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File destFile = new File(String.format("target/screenshot-%s-%s.png", "process", System.currentTimeMillis()));
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4"))).getText();
        Assert.assertEquals(result,"Hello World");

    }
}
