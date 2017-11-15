package com.ideals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by AntonKa on 11/15/2017.
 */
public class GooglePage extends BasePage {
    By searchFiledLocator = By.id("lst-ib");
    private WebElement serchField;

    By foundResultLinkLocator = By.cssSelector(".r>a");
    private List<WebElement> foundLinks;

    private String linkAttribute = "href";

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void findNeededLinkInSearchResultAndClick(String searchedURL) {
        foundLinks =driver.findElements(foundResultLinkLocator);
        for(WebElement link : foundLinks){
            if (link.getAttribute(linkAttribute).contains(searchedURL)) {
                //   System.out.println("My link " + link.getText());
                link.click();
                return;
            }
        }
        System.out.println("Link \'iDeals\' not found in search results");
    }

    public void searchInGoogle(String searchValue) {
        serchField = driver.findElement(searchFiledLocator);
        serchField.click();
        serchField.clear();
        serchField.sendKeys(searchValue);
        serchField.submit();
    }
}
