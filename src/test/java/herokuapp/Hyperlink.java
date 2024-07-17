package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HyperlinkPage;
import support.Browser;

public class Hyperlink {
    @DataProvider(name = "statusCode")
    public Object[][] data() {
        return new Object[][]{
                {"200", "https://the-internet.herokuapp.com/status_codes/200"},
                {"301", "https://the-internet.herokuapp.com/status_codes/301"},
                {"404", "https://the-internet.herokuapp.com/status_codes/404"},
                {"500", "https://the-internet.herokuapp.com/status_codes/500"}
        };
    }

    @BeforeTest
    public static void setup(){
        Browser.launchBrowser("chrome");

    }


    @Test(dataProvider = "statusCode")
    public void verifyHyperlink(String st,String url){
        HyperlinkPage hyperlinkPage = new HyperlinkPage();
        hyperlinkPage.open();

        hyperlinkPage.click(st);
        Assert.assertEquals(hyperlinkPage.getCurrentUrl(),url);
        hyperlinkPage.back();
        }
    @AfterTest
    void exist(){
        Browser.quit();
    }
    }
