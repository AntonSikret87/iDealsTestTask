package com.ideals.core;

import com.ideals.pages.GooglePage;
import com.ideals.pages.IdealsHomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 11/14/2017.
 */
public class LoginAndSignInBtnColorTestBase extends TestBase {
    private String baseUrl = "https://www.google.com";
    private String googleSearchValue = "iDeals";
    private String linkToSearch = "https://www.idealsvdr.com/";
    private String expectedHexColorTextLoginBtn = "#70a429";
    private String expectedHexBackGroundColorSignUpBtn = "#70a429";
    private String expectedHexColorTextSignUpBtn = "#ffffff";
    private String expectedTitle = "iDeals™ Virtual Data Rooms | Secure Data Room Provider";

    @Test
    public void checkLoginSigninButtonsColorAndPageTitle() {
        //В браузере Chrome переходим на страницу google.com
        GooglePage googlePage = new GooglePage(driver);
        googlePage.open(baseUrl);
        //Вводим в поиск текст "iDeals"
        googlePage.searchInGoogle(googleSearchValue);
        //В списке результатов ищем ресурс с ссылкой "https://www.idealsvdr.com/" и переходим на него
        googlePage.findNeededLinkInSearchResultAndClick(linkToSearch);
        IdealsHomePage idealsHomePage = new IdealsHomePage(driver);
        //Кнопка Log In отображается и цвет текста зеленый
        assertTrue(idealsHomePage.checkLogInBtnIsDisplayed());
        assertEquals(idealsHomePage.getColorTextLoginBtn(), expectedHexColorTextLoginBtn);
        // Кнопка Sign Up Отображается на зеленом фоне и цвет текста белый
        assertEquals(idealsHomePage.getBackGroundColorSignupBtn(), expectedHexBackGroundColorSignUpBtn);
        assertEquals(idealsHomePage.getColorTextSignupBtn(), expectedHexColorTextSignUpBtn);
        //Title страницы == iDeals™ Virtual Data Rooms | Secure Data Room Provider
        assertEquals(idealsHomePage.getActualTitle(), expectedTitle);
    }
}




