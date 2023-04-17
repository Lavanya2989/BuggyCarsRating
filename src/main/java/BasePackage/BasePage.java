package BasePackage;

import PageObjects.HomePageBuggy;


import TestData.BuggyCarAppData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Map;


public class BasePage {
    public WebDriver driver;

    protected Map<String,String> AppData= BuggyCarAppData.BuggyAppData();
    public BasePage(WebDriver driver) {
        this.driver = driver;
           }


    public HomePageBuggy OpenApplication() {
        ReporterExtension.log("Open Apllication");
        driver.navigate().to("https://buggy.justtestit.org/");

        HomePageBuggy homePageBuggy = new HomePageBuggy(driver);
        PageFactory.initElements(driver, homePageBuggy);
        return homePageBuggy;
    }

    public void getTitle(String expectedTitle) {
        try {
            Assert.assertEquals(driver.getTitle(), expectedTitle);

        } catch (Exception e) { }

    }

    public void verifyElementIsDisplayed(WebElement webElement){
       Assert.assertTrue(webElement.isDisplayed());

    }

    public void verifyElementTextIsCorrect(String text,WebElement webElement){
        Assert.assertEquals(text,webElement.getText());

    }
//    public WebElement waitUntilVisibilityOf(WebElement element) {
//
//        return (WebElement) Wait.until(ExpectedConditions.visibilityOf(element));
//    }
}
