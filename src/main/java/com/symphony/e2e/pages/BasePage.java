package com.symphony.e2e.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public BasePage() {

    }

    public abstract BasePage show();

    public abstract boolean isDisplayed();

}
