package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Browser;

import static support.Browser.*;

public class HerokuLogin {
    /**
     * Suffix:
     * Tab
     * Button -> btn
     * TextBox
     * Label ->
     * ...
     */
    WebDriver driver;
    By userName = By.id("username");
    By passWord = By.id("password");
    By submit = By.cssSelector("button[type=submit]");
    By message = By.className("success");

    public void open(){
        visit("https://the-internet.herokuapp.com/login");
    }

    public void login(String username,String password)
    {   fill(userName,username);
        fill(passWord,password);
    }
    public void submit(){
        Browser.click(submit);}
    public String currentUrl(){return currentUrl();}
    public String getsuccessfullyloginMessage(){return getText(message);}
}