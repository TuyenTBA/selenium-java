package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.HerokuLogin;
import support.Browser;

public class FormAuthenticationapp2 {

    @BeforeTest
     public static void setup(){
        Browser.launchBrowser("chrome");

    }


    @Test
    void verifyAuthenticationapp(){
        HerokuLogin HerokuLogin = new HerokuLogin();
        HerokuLogin.open();
        HerokuLogin.login("tomsmith","SuperSecretPassword!");
        HerokuLogin.submit();

        Assert.assertEquals(HerokuLogin.currentUrl(),"https://the-internet.herokuapp.com/secure");
        Assert.assertEquals(HerokuLogin.getsuccessfullyloginMessage(),"You logged into a secure area!");

    }

    @AfterTest
    void exist(){
        Browser.quit();
    }
}
