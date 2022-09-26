package com.symphony.e2e.suites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseSuite {

    protected WebDriver driver;
    protected String url;

    @BeforeSuite
    public void beforeSuite() {
        this.url = "https://symphony.is/";
    }

    @BeforeTest
    public void beforeTest() {
        this.url = "https://symphony.is/";
    }

    @BeforeClass
    public void beforeClass(ITestContext context) {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setBrowserName("chrome");
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        this.driver = new ChromeDriver();

       /* if (context.getCurrentXmlTest().getParameter("browser").equals("firefox")) {

        } else if (context.getCurrentXmlTest().getParameter("browser").equals("chrome")) {
            desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setBrowserName("chrome");
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            this.driver = new ChromeDriver();
        }*/

        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {
        this.driver.quit();
    }

    @AfterTest
    public void afterTest(ITestContext context) {
        // this.driver.quit();
    }

    @AfterSuite
    public void afterSuite() {

    }





}
