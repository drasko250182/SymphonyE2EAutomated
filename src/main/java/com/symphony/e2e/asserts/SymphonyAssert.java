package com.symphony.e2e.asserts;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SymphonyAssert {

    public void assertList(List<String> actual, List<String> expected) {
        Assert.assertEquals(actual.size(), expected.size(), "Size is not equal");

        SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i < expected.size(); i++) {
            softAssert.assertEquals(actual.contains(expected.get(i)), true, "Item " + expected.get(i) + " doesn't exist");
        }
        softAssert.assertAll();
    }

}
