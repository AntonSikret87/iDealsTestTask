import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by AntonKa on 11/14/2017.
 */
public class TestClass {
    private static WebDriver driver;
    private String baseUrl;


    @BeforeClass(alwaysRun = true)
    public void setUp() {

        baseUrl =  "https://www.google.com";
        String pathToFileWindows = ".\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToFileWindows);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void checkLoginSigninButtonsColorAndPageTitle()  {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("lst-ib")).click();
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("iDeals");
        driver.findElement(By.id("lst-ib")).submit();
       // driver.findElement(By.partialLinkText("iDeals™ Virtual Data Rooms")).click();

       //String findLink ="iDeals™ Virtual Data Rooms";
        String searchedLink = "https://www.idealsvdr.com/";

        findNeededLinkFromSearchResult(searchedLink);
     //   findNeededLinkFromSearchResult1(findLink1);

        //Кнопка Log In отображается и цвет текста зеленый
        WebElement loginButton = driver.findElement(By.linkText("Log In"));
        assertTrue(loginButton.isDisplayed());

        String expectedRGBAColorTextLoginBtn = "rgba(112, 164, 41, 1)";
        String expectedHexColorTextLoginBtn = "#70a429";

        String  actualRGBAColorTextLoginBtn = driver.findElement(By.linkText("Log In")).getCssValue("color");
        String actualHexColorTextLoginBtn = Color.fromString(actualRGBAColorTextLoginBtn).asHex();
        assertEquals(actualHexColorTextLoginBtn, expectedHexColorTextLoginBtn);
        // Кнопка Sign Up Отображается на зеленом фоне и цвет текста белый
        String expectedRGBABackGroundColorSignInBtn = "rgba(112, 164, 41, 1)";
        String expectedHexBackGroundColorSignInBtn = "#70a429";

        String actualRGBABackGroundColorSignInBtn = driver.findElement(By.linkText("Sign Up")).getCssValue("background-color");
        String actualHexBackGroundColorSignInBtn = Color.fromString(actualRGBABackGroundColorSignInBtn).asHex();
        assertEquals(actualHexBackGroundColorSignInBtn, expectedHexBackGroundColorSignInBtn);

        String expectedRGBAColorTextSignInBtn = "rgba(255, 255, 255, 1)";
        String expectedHexColorTextSignInBtn = "#ffffff";

        String actualRGBAColorTextSignInBtn = driver.findElement(By.linkText("Sign Up")).getCssValue("color");
        String actualHexColorTextSignInBtn = Color.fromString(actualRGBAColorTextSignInBtn).asHex();
        assertEquals(actualHexColorTextSignInBtn, expectedHexColorTextSignInBtn);


//
//        String color = driver.findElement(By.linkText("Log In")).getCssValue("color").trim();
//        System.out.println("RGB_Color: " + color);
//
//
//        String color_hex[];
//        color_hex = color.replace("rgba(", "").split(",");
//        String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));
//
////
//       assertEquals("#70a429", actual_hex);






        assertEquals(driver.getTitle(), "iDeals™ Virtual Data Rooms | Secure Data Room Provider");
    }



    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        driver.quit();
        }

    public static void findNeededLinkFromSearchResult ( String searchedURL ) {
        List<WebElement> foundLinks = driver.findElements(By.cssSelector(".r>a"));
        for(WebElement link : foundLinks){
            //System.out.println(link.getAttribute("href"));
            if (link.getAttribute("href").contains(searchedURL)) {
                //   System.out.println("My link " + link.getText());
                //System.out.println("INLOP " + link.getAttribute("href"));
                link.click();
                return;
            }
        }
        System.out.println("Link \'iDeals\' not found in search results");
    }

}




