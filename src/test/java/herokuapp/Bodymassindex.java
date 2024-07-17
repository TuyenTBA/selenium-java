package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Bodymassindex {
    WebDriver web;
    @BeforeTest
    void setup(){
        web = new ChromeDriver();
        web.get("https://www.calculator.net/bmi-calculator.html");
    }

    @Test
    void verifyalert(){
        
        web.findElement(By.cssSelector("//*[@id=\"menuon\"]/a")).click();
        web.findElement(By.id("cage")).sendKeys("27");
        web.findElement(By.cssSelector("[value='Clear']")).click();
        web.findElement(By.id("cage")).sendKeys("27");
        web.findElement(By.cssSelector("label[for='csex2']")).click();
        web.findElement(By.id("cheightmeter")).sendKeys("162");
        web.findElement(By.id("ckg")).sendKeys("49");
        web.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertEquals(web.findElement(By.className("bigtext")).getText(),"BMI = 21.7 kg/m2   (Normal)");
    }

    @AfterTest
    void clean(){
        web.quit();
    }

}
