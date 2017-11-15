package com.ideals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

/**
 * Created by AntonKa on 11/15/2017.
 */
public class IdealsHomePage extends BasePage {
    By loginButtonLocator = By.linkText("Log In");
    private WebElement loginBtn;

    By signupButtonLocator = By.linkText("Sign Up");
    private WebElement signupBtn;

    private String textColor = "color";
    private String backgroundColor = "background-color";

    public IdealsHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkLogInBtnIsDisplayed() {
        loginBtn = driver.findElement(loginButtonLocator);
        return loginBtn.isDisplayed();
    }

    public String getColorTextLoginBtn() {
        String actualRGBAColorTextLoginBtn = loginBtn.getCssValue(textColor);
        String actualHexColorTextLoginBtn = Color.fromString(actualRGBAColorTextLoginBtn).asHex();
        return actualHexColorTextLoginBtn;
    }

    public String getBackGroundColorSignupBtn() {
        signupBtn = driver.findElement(signupButtonLocator);
        String actualRGBABackGroundColorSignUpBtn = signupBtn.getCssValue(backgroundColor);
        String actualHexBackGroundColorSignUpBtn = Color.fromString(actualRGBABackGroundColorSignUpBtn).asHex();
        return actualHexBackGroundColorSignUpBtn;
    }

    public String getColorTextSignupBtn() {
        String actualRGBAColorTextSignUpBtn = signupBtn.getCssValue(textColor);
        String actualHexColorTextSignUpBtn = Color.fromString(actualRGBAColorTextSignUpBtn).asHex();
        return actualHexColorTextSignUpBtn;
    }

    public String getActualTitle() {
        String actualTitle = driver.getTitle();
        return actualTitle;
    }


}
