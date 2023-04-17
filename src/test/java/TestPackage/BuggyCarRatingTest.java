package TestPackage;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import PageObjects.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class BuggyCarRatingTest extends BaseTest {

    HomePageBuggy homePagebuggy;
    RegisterPage registerPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    PopularMakePage popularMake;
    OverAllRating rating;

    @Test
    public void buggyCarsHomePageTest() {

        openBrowser("Chrome");
        BasePage pageBase = new BasePage(driver);
        PageFactory.initElements(driver, pageBase);
        HomePageBuggy homePagebuggy = pageBase.OpenApplication();
        homePagebuggy.getTitle("Buggy Cars Rating");
        homePagebuggy.verifyHomePage();
    }

    @Test
    public void registration() {

        openBrowser("Chrome");
        BasePage pageBase = new BasePage(driver);
        PageFactory.initElements(driver, pageBase);
        homePagebuggy = pageBase.OpenApplication();
        registerPage = homePagebuggy.clickRegistrationLink();
        registerPage.registerUser();

    }

    @Test
    public void userLogin() {

        openBrowser("Chrome");
        BasePage pageBase = new BasePage(driver);
        PageFactory.initElements(driver, pageBase);
        homePagebuggy = pageBase.OpenApplication();
        loginPage = homePagebuggy.Login();
        loginPage.loginUser();

    }

    @Test
    public void verifyProfileUpdate() {

        userLogin();
        profilePage = homePagebuggy.Profile();
        profilePage.profileUpdate();
    }

    @Test
    public void verifyPopularMake() {

        userLogin();
        popularMake = homePagebuggy.clickPopularMake();
        popularMake.popularMake();
    }

    @Test
    public void verifyRating() {

        userLogin();
        rating = homePagebuggy.clickOverAllRating();
        rating.Rating();
    }
}

