package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.NestframePage;
import support.Browser;

    public class NestFramesTest {
        NestframePage nestFramesTest;
        @BeforeClass
        void setup(){
            Browser.launchBrowser("Chrome");
        }

        @BeforeTest
        void setupPage(){
            nestFramesTest = new NestframePage();
            nestFramesTest.open();
        }

        @Test
        void verifyTextPresent (){
            nestFramesTest.switchFrame("frame-top");
            nestFramesTest.switchFrame("frame-left");
            Assert.assertEquals(nestFramesTest.getString(),"LEFT");
            nestFramesTest.switchParentFrame();

            nestFramesTest.switchFrame("frame-middle");
            Assert.assertEquals(nestFramesTest.getString(),"MIDDLE");
            nestFramesTest.switchParentFrame();

            nestFramesTest.switchFrame("frame-right");
            Assert.assertEquals(nestFramesTest.getString(),"RIGHT");
            nestFramesTest.switchParentFrame();

            nestFramesTest.switchParentFrame();
            nestFramesTest.switchFrame("frame-bottom");
            Assert.assertEquals(nestFramesTest.getString(),"BOTTOM");
        }

        @AfterClass
        void closePage(){
            Browser.quit();
        }
    }
