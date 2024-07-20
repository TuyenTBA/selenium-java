package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.JavaSciptAlertPage;
import support.Browser;

public class JavaScriptAlertTest {
 JavaSciptAlertPage javasciptAlert;
    @BeforeClass
    void setUp() {
        Browser.launchBrowser("Chrome");
    }

    @BeforeMethod
    void setUpPage(){
        javasciptAlert = new JavaSciptAlertPage();
        javasciptAlert.open();
    }

    @Test
    void verifyacceptForJSAlert(){
        javasciptAlert.clickJSAlert();
        javasciptAlert.acceptAlert();
        Assert.assertEquals(javasciptAlert.getMessage(),"You successfully clicked an alert");

    }
    @Test
    void dismissForJsConfirm(){
        javasciptAlert.clickConfirm();
        javasciptAlert.dismissAlert();
        Assert.assertEquals(javasciptAlert.getMessage(),"You clicked: Cancel");
    }

    @Test
    void clickForJsPrompt(){
        javasciptAlert.clickJSPrompt();
        javasciptAlert.enterAlert("hello");
        Assert.assertEquals(javasciptAlert.getMessage(),"You entered: hello");
    }

    @AfterClass
    void tearDown(){
Browser.quit();    }
}