package Selenium_TestNg_Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {

    @Test
    public void Asserts() {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = null;
        String str4 = "test";
        String str5 = "test";
        String str6 = "Not_Testing";

        int val1 = 5;
        int val2 = 6;

        Assert.assertEquals(str1, str2);
        System.out.println("Equals Assertion is success");

        Assert.assertNotEquals(str1, str6);
        System.out.println("Not equals assertion is success");

        Assert.assertTrue(val1 < val2);
        System.out.println("True assertion is success");

        Assert.assertFalse(val1 > val2);
        System.out.println("False assertion is success");

        Assert.assertNotNull(str1);
        System.out.println("Not null success");

        Assert.assertNull(str3);
        System.out.println("Null assertion success");

        Assert.assertSame(str4, str5);
        System.out.println("Strings are same");

        Assert.assertNotSame(str1, str6);
        System.out.println("Strings are not same");
        
        
    }
}