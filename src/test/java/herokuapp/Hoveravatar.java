package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hoveravatar {
    WebDriver web;
    Actions mouse;
    @BeforeTest
    public void setup(){
        web = new ChromeDriver();
        web.get("https://the-internet.herokuapp.com/hovers");
        mouse = new Actions(web);
    }

    @Test
    public void verifyHoverAvatar(){
        mouse.moveToElement(web.findElement(By.xpath("//img[@alt='User Avatar'][1]")));
        Assert.assertEquals(web.findElement(By.xpath("//*[@class=\"figure\"][1]/*[@class=\"figcaption\"]")),"name: user1");
        Assert.assertEquals(web.findElement(By.xpath("a[href='/users/1']")).getText(),"https://the-internet.herokuapp.com/users/1");

    }
    @AfterClass
    void tearDown() {
        web.quit();
    }
}
