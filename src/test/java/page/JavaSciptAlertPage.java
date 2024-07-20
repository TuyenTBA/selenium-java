package page;


import org.openqa.selenium.By;
import support.Browser;

public class JavaSciptAlertPage {

    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickJSAlert(){
        Browser.click(By.xpath("//button[.='Click for JS Alert']"));
    }

    public void clickConfirm(){
        Browser.click(By.xpath("//button[.='Click for JS Confirm']"));
    }

    public void clickJSPrompt(){
        Browser.click(By.xpath("//button[.='Click for JS Prompt']"));
    }

    public void acceptAlert(){
        Browser.acceptAlert();
    }
    public void dismissAlert(){
        Browser.dismissAlert();
    }

    public void enterAlert(String input){
        Browser.inputAlert(input);
    }

    public String getMessage(){
        return Browser.getText(By.id("result"));
    }


}
