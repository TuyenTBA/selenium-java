package page;

import org.openqa.selenium.By;

import static support.Browser.*;

public class HoverAvatarPage {
    public void open(){ visit("https://the-internet.herokuapp.com/hovers");}
public void hoverUser1(){
    hover(By.xpath("//img[@alt='User Avatar'][1]"));
}
public  String getHyperLinkUser1(){
  return   getText(By.xpath("a[href='/users/1']"));
}
public String getNameUser1(){
    return  getText(By.xpath("//*[@class=\"figure\"][1]/*[@class=\"figcaption\"]"));
}
}
