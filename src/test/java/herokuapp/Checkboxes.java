package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.CheckboxPage;
import support.Browser;

public class Checkboxes {
    @BeforeTest
    public static void setup(){
        Browser.launchBrowser("chrome");

    }


    @Test
    void verifycheckbox(){
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.open();

        checkboxPage.clickcheckbox1();
        Assert.assertTrue(checkboxPage.ischeckedcheckbox1());

        checkboxPage.clickcheckbox1();
        Assert.assertTrue(checkboxPage.ischeckedcheckbox2());
    }

    @AfterTest
    void exist(){
        Browser.quit();
    }
}
