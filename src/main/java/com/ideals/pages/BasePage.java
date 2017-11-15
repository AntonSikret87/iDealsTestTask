package com.ideals.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by AntonKa on 11/15/2017.
 */
public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }
}
