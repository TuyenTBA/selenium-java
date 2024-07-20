package page;

import org.openqa.selenium.By;

import static support.Browser.*;

public class NestframePage {

public void open(){
    visit("https://the-internet.herokuapp.com/nested_frames");
}

    public String getFrameLeftString(){
        switchFrame("frame-top");
        switchFrame("frame-left");
        return getText(By.xpath("html/body"));
    }

    public String getFrameMiddleString(){
        switchToParentFrame();
        switchFrame("frame-middle");
        return getText(By.xpath("html/body"));
    }

    public String getFrameRightString(){
        switchToParentFrame();
        switchFrame("frame-right");
        return getText(By.xpath("html/body"));
    }

    public String getFramebottomString(){
        switchToParentFrame();
        switchToParentFrame();
        switchFrame("frame-bottom");
        return getText(By.xpath("html/body"));
    }

}
