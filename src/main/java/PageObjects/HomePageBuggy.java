package PageObjects;

import BasePackage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBuggy extends BasePage {
    public HomePageBuggy(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div:nth-child(1) > div > h2.card-header.text-xs-center")
    public WebElement popularMake;

    @FindBy(css = "div:nth-child(2) > div > h2.card-header.text-xs-center")
    public WebElement popularModel;

    @FindBy(css = "div:nth-child(3) > div > h2.card-header.text-xs-center")
    public WebElement overallRating;

    @FindBy(css = "a.btn.btn-success-outline")
    public WebElement RegistrationLink;

    @FindBy(css = "a.navbar-brand")
    public WebElement buggyHomeLink;

    @FindBy(xpath = "//img[@title='Alfa Romeo']")
    public WebElement popularMakeLink;

    @FindBy(xpath = "//img[@title='Alfa Romeo']")
    public WebElement overAllRatingLink;

    public void verifyHomePage() {
        verifyElementIsDisplayed(popularMake);
        verifyElementIsDisplayed(popularModel);
        verifyElementIsDisplayed(overallRating);
        verifyElementTextIsCorrect("Popular Make", popularMake);
        verifyElementTextIsCorrect("Popular Model", popularModel);
        verifyElementTextIsCorrect("Overall Rating", overallRating);
    }

    public RegisterPage clickRegistrationLink() {
        RegistrationLink.click();
        RegisterPage userRegistration = new RegisterPage(driver);
        PageFactory.initElements(driver, userRegistration);
        return userRegistration;

    }

    public LoginPage Login() {
        buggyHomeLink.click();
        LoginPage login = new LoginPage(driver);
        PageFactory.initElements(driver, login);
        return login;

    }

    public ProfilePage Profile() {
        buggyHomeLink.click();
        ProfilePage profile = new ProfilePage(driver);
        PageFactory.initElements(driver, profile);
        return profile;

    }

    public PopularMakePage clickPopularMake() {
        popularMakeLink.click();
        PopularMakePage popularMakePage = new PopularMakePage(driver);
        PageFactory.initElements(driver, popularMakePage);
        return popularMakePage;

    }

    public OverAllRating clickOverAllRating() {
        overAllRatingLink.click();
        OverAllRating overAllRating = new OverAllRating(driver);
        PageFactory.initElements(driver, overAllRating);
        return overAllRating;

    }
}
