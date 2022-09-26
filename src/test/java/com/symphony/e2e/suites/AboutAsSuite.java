package com.symphony.e2e.suites;

import com.symphony.e2e.asserts.SymphonyAssert;
import com.symphony.e2e.pages.AboutAsPage;
import com.symphony.e2e.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AboutAsSuite extends BaseSuite {

    @Test()
    public void verifyAboutAsDetails() {

        HomePage homePage = new HomePage(driver, url);
        homePage.show();
        homePage.openAboutAs();

        AboutAsPage aboutAsPage = new AboutAsPage(driver, url);
        List<String> actual = aboutAsPage.getAboutAsDetails();
        SymphonyAssert symphonyAssert = new SymphonyAssert();
        symphonyAssert.assertList(actual, Arrays.asList("HQ", "Founded", "Consulting Offices", "Engineering Hubs", "Size", "Clients"));

    }

    @Test()
    public void verifyAboutAsURL() {

        HomePage homePage = new HomePage(driver, url);
        homePage.show();
        homePage.openAboutAs();
        AboutAsPage aboutAsPage = new AboutAsPage(driver, url);
        Assert.assertEquals(aboutAsPage.getURL(), "https://symphony.is/about-us", "URL is not as expected");

    }

}
