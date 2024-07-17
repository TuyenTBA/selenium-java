package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Browser;

public class HyperlinkPage {
    WebDriver driver;
    By here = By.linkText("here");

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/status_codes");
    }
    public void click(String stCode){
        By statusCode = By.linkText(stCode);
        Browser.click(statusCode);
    }
    public void back(){
      Browser.click(here);
    }
    public String getCurrentUrl(){
        return Browser.currentUrl();
    }

}
