package example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static example.Main.isLeapYear;
import static example.Main.timSoLonNhatSoHai;

public class MainTest {
    @Test
    void namNhuan()
    {Assert.assertTrue(isLeapYear(2024));
    }


    @Test
    void solonnhatnhi()
    {
        Assert.assertEquals( timSoLonNhatSoHai(new int[]{23, 5, 1, 89, 65, 0, 23, 432, 1}),new int[]{432,65});
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testIllegalArray() {
        int[] input = new int[]{1, 2}; // Example input with length less than 3
        if (input.length < 3) {
            throw new RuntimeException("Illegal array");
        }
    }

}
