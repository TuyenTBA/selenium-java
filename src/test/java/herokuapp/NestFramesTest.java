package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.NestframePage;
import support.Browser;

    public class NestFramesTest {
        NestframePage nestFramesTest;
        @BeforeClass
        void setup(){
            Browser.launchBrowser("chrome");
        }

        @BeforeMethod
        void setupPage(){
            nestFramesTest = new NestframePage();
            nestFramesTest.open();
        }

        @Test
        void verifyTextPresent (){

            Assert.assertEquals(nestFramesTest.getFrameLeftString(),"LEFT");

            Assert.assertEquals(nestFramesTest.getFrameMiddleString(),"MIDDLE");

            Assert.assertEquals(nestFramesTest.getFrameRightString(),"RIGHT");

            Assert.assertEquals(nestFramesTest.getFramebottomString(),"BOTTOM");
        }

        @AfterClass
        void closePage(){
            Browser.quit();
        }
    }
