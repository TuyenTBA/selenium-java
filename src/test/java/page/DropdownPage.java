package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static support.Browser.*;

public class DropdownPage {
    WebDriver driver;
By id= By.id("dropdown");
By option1 = By.xpath("//option[.='Option 1']");
    public void open(){
        visit("https://the-internet.herokuapp.com/dropdown");
    }
    public void select(String option){
        Select select = new Select(findElement(id));
        select.selectByVisibleText(option);
    }
    public boolean isSelect(){
        return isSelected(option1);
    }
}
