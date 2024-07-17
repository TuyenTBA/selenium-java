package page;

import org.openqa.selenium.By;
import support.Browser;

public class NestframePage {

public void open(){
    Browser.visit("https://the-internet.herokuapp.com/nested_frames");
}

public void switchFrame(String box){
        Browser.switchFrame(box);
    }
public void switchParentFrame(){
        Browser.switchToParentFrame();
    }


public String getString(){
       return Browser.getText(By.xpath("html/body"));
}
}
