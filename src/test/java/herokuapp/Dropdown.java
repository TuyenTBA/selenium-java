package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.DropdownPage;
import support.Browser;

public class Dropdown {
    @BeforeTest
    public static void setup(){
        Browser.launchBrowser("chrome");

    }
@Test
void verifyAbleSelectOption(){
    DropdownPage dropdownPage = new DropdownPage();
    dropdownPage.open();
    dropdownPage.select("Option 1");

    Assert.assertTrue(dropdownPage.isSelect());
 }
    @AfterTest
    void exist(){
        Browser.quit();
    }
}
