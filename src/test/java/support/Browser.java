package support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

//Selenium Owner method
public class Browser {
    private static WebDriver driver;

    public static void launchBrowser(String name){
        switch (name.toLowerCase()){
            case "chrome":{
                driver= new ChromeDriver();
                break;
            }
            case "firefox": {
                driver= new FirefoxDriver();
                break;
            }
            case "safari": {
                driver= new SafariDriver();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }

    public static void visit(String url){
        driver.get(url);
    }

    public static void click(By locator){
        driver.findElement(locator).click();
    }

    public static void fill(By locator, CharSequence... keyToSend){
        driver.findElement(locator).sendKeys(keyToSend);
    }

    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }
    public static String getTextfromlist(By locator, int index){
        return driver.findElements(locator).get(index).getText();
    }

    public static String currentUrl(){
        return driver.getCurrentUrl();
    }


    public static void quit(){
        if(driver!=null){
            driver.quit();
        }
    }

    public static void takeScreenShot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }
    public static WebElement findElement(By location){
       return driver.findElement(location);
    }
    public static List<WebElement> findElements(By location){
       return driver.findElements(location);
    }
    public static void switchFrame(String frameName){
        driver.switchTo().frame(frameName);
    }

    public static void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }




}