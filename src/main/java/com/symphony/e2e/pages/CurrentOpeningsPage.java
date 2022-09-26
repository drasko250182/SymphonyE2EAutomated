package com.symphony.e2e.pages;

import com.symphony.e2e.asserts.SymphonyAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CurrentOpeningsPage extends BasePage {

    @Override
    public BasePage show() {
        this.driver.get(url + "/careers#current-openings");
        this.driver.manage().window().maximize();
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return true;
    }

    public CurrentOpeningsPage(WebDriver driver, String url) {
        super(driver, url + "/careers#current-openings");
    }

    private List<WebElement> openingJobs() {

        WebElement currentOpeningJobs = this.driver.findElement(By.xpath(".//ul[@class='currentOpenings--jobs']"));

        return currentOpeningJobs.findElements(By.xpath(".//li"));
    }

    public Integer getCountOfOpeningPositions() {
        Integer toReturn;

        //WebElement currentOpeningJobs = this.driver.findElement(By.xpath(".//ul[@class='currentOpenings--jobs']"));

        //List<WebElement> jobs = currentOpeningJobs.findElements(By.xpath(".//li"));

        return this.openingJobs().size();
    }

    public List<String> getTitleAndLocationOfOpeningPositions() throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\drago\\OneDrive\\Desktop\\Symphony\\out.txt");
        List<String> toReturn = new ArrayList<>();

        List<WebElement> jobs = this.openingJobs();

        for(int i = 0; i < jobs.size(); i++) {
            WebElement jobTitle = jobs.get(i).findElement(By.xpath(".//div[@class='currentOpenings--job-title']"));
            String title = jobTitle.getText();

            WebElement jobLocation = jobs.get(i).findElement(By.xpath(".//div[@class='currentOpenings--job-locationWrapper-name']"));
            String location = jobLocation.getText();

            String tmp = title + " , "+ location;
            fw.write(tmp);
            fw.write("\n");
            toReturn.add(tmp);

        }
        fw.close();
        return toReturn;
    }


}
