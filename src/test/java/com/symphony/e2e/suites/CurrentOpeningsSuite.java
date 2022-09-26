package com.symphony.e2e.suites;

import com.symphony.e2e.asserts.SymphonyAssert;
import com.symphony.e2e.pages.AboutAsPage;
import com.symphony.e2e.pages.CurrentOpeningsPage;
import com.symphony.e2e.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CurrentOpeningsSuite extends BaseSuite {

    @Test()
    public void verifyCountOfOpenPositions() {

        HomePage homePage = new HomePage(driver, url);
        homePage.show();
        homePage.openCurrentOpenings();
        CurrentOpeningsPage currentOpeningsPage = new CurrentOpeningsPage(driver, url);
        int countOfPositions = currentOpeningsPage.getCountOfOpeningPositions();
        Assert.assertEquals(countOfPositions, 86, "Count of opening positions is not as expected");

    }

    @Test()
    public void saveTitleAndLocationOfOpenPositions() throws IOException {

        HomePage homePage = new HomePage(driver, url);
        homePage.show();
        homePage.openCurrentOpenings();
        CurrentOpeningsPage currentOpeningsPage = new CurrentOpeningsPage(driver, url);
        currentOpeningsPage.getTitleAndLocationOfOpeningPositions();

    }

}
