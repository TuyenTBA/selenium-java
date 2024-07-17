package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static support.Browser.*;

public class CheckboxPage {
    WebDriver driver;

    By checkbox1 = By.xpath("//*[@id='checkboxes']/input[@type='checkbox'][1]");
    By checkbox2 = By.xpath("//*[@id='checkboxes']/input[@type='checkbox'][2]");
    public void open(){
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void clickcheckbox1(){

        if(!isSelected(checkbox1)){
            click(checkbox1);
        }
    }

    public void clickcheckbox2(){

        if(!isSelected(checkbox2)){
            click(checkbox2);
        }
    }
    public boolean ischeckedcheckbox1(){
        return isSelected(checkbox1);
    }
    public boolean ischeckedcheckbox2(){
        return isSelected(checkbox2);
    }
}
