package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationapp {
    /*
Open browser

Navigate to https://the-internet.herokuapp.com/login

Fill in username with tomsmith

Fill in the password with SuperSecretPassword!

Click on Login button

And the home page is appear*/
    @Test
    public void successfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//"<button class=\"radius\" type=\"submit\"><i class=\"fa fa-2x fa-sign-in\"> Login</i></button>"

        driver.findElement(By.cssSelector("button[type=submit]")).click();
//verifysuccess
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
        Assert.assertEquals(driver.findElement(By.cssSelector("#content h4")).getText(), "Welcome to the Secure Area. When you are done click logout below.");//message: You logged into a secure area!

        //driver.quit();


    }

    @Test
    public void loginFailByWrongUserName() {
        /*1.Open browser
2.Navigate to https://the-internet.herokuapp.com/login
3.Fill in wrong username with tomsmithy
4.Fill in the password with SuperSecretPassword!
5.Click on Login button
6.And show error message*/

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmithy");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
        driver.quit();
    }
}
