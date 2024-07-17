package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ChromeTest {
    @Test
    void openChromeSuccessfully(){

       WebDriver driver =  new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/");
        Assert.assertEquals(driver.getTitle(),"The Selenium Browser Automation Project | Selenium");
        driver.quit();
    }

    @Test
    void openchromeOptionsSuccessfully(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver =  new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/documentation/");
        Assert.assertEquals(driver.getTitle(),"The Selenium Browser Automation Project | Selenium");
        driver.quit();
    }

    @Test
    void openChromeMobileViewPortSuccessfully(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 344);
        deviceMetrics.put("height", 822);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
//        driver.quit();
    }

}
