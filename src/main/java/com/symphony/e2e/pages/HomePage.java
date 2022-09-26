package com.symphony.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, String url) {
        super(driver, url);
    }

    @Override
    public BasePage show() {
        this.driver.get(url);
        this.driver.manage().window().maximize();
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return true;
    }

    private WebElement getLnkAboutAs() {
        try {
            /*return driver.findElement(
                    By.xpath(".//a[@href='/about-as']"));*/
            return driver.findElement(
                    By.xpath("//span[text()='About Us']"));

        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Current Openings", e);
        }
    }

    private WebElement getLnkCurrentOpenings() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@href='/careers#current-openings']")));
            return driver.findElement(
                    By.xpath(".//a[@href='/careers#current-openings']"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Current Openings", e);
        }
    }

    public void openAboutAs() {
        this.getLnkAboutAs().click();
        //AboutAsPage aboutAsPage = new AboutAsPage(driver, url);
        //aboutAsPage.show();
    }

    public void openCurrentOpenings() {
        driver.findElement(
                By.xpath("//span[text()='Careers']")).click();
        this.getLnkCurrentOpenings().click();
    }

}
