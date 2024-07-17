package herokuapp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TablePage;
import support.Browser;

import java.util.List;


public class TableTest {

    TablePage tablePage;
    @BeforeClass
    void setup(){
        Browser.launchBrowser("Chrome");
    }

    @BeforeMethod
    void setupPage(){
        tablePage = new TablePage();
        tablePage.open();
    }

    @Test
    void largestDuePerson(){
        Assert.assertEquals(tablePage.getMaxDuePersonInTable1(), List.of("Doe Jason"));
    }
    @Test
    void smallestDuePerson(){
        Assert.assertEquals(tablePage.getMinDuePersonInTable1(),List.of("Smith John","Conway Tim"));
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}