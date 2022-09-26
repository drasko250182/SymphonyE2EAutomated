package com.symphony.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AboutAsPage extends BasePage {

    @Override
    public BasePage show() {
        this.driver.get(url + "/about-as");
        this.driver.manage().window().maximize();
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return true;
    }

    public AboutAsPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public List<String> getAboutAsDetails() {
        List<String> toReturn = new ArrayList<>();

        WebElement details = this.driver.findElement(By.xpath(".//ul[@class='pageMetaDetails--list']"));

        List<WebElement> items = details.findElements(By.xpath(".//li"));

        for(int i = 0; i < items.size(); i++) {
            String tpmKey = items.get(i).findElement(By.xpath(".//strong")).getText();

            toReturn.add(tpmKey);
        }

        return toReturn;
    }

    public String getURL() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.driver.getCurrentUrl();
    }
}
