package PageObjects;

import BasePackage.BasePage;

import BasePackage.ReporterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="div.col-md-6 > h2")
    public WebElement registrationPageTitle;

    @FindBy(id="username")
    public WebElement loginName;

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="confirmPassword")
    public WebElement confirmPassword;

    @FindBy(css="button.btn.btn-default")
    public WebElement registerButton;

    @FindBy(css="a.btn")
    public WebElement cancelRegistrationButton;

    @FindBy(css="div.result.alert.alert-success")
    public WebElement registrationSuccess;

    public void registerUser() {

        verifyElementIsDisplayed(registrationPageTitle);
        verifyElementTextIsCorrect( "Register with Buggy Cars Rating",registrationPageTitle);
        String random = UUID.randomUUID().toString();
        String login = random.substring(0, random.indexOf("-"));
        loginName.sendKeys(AppData.get("Login")+login);
        firstName.sendKeys(AppData.get("First name"));
        lastName.sendKeys(AppData.get("Last name"));
        password.sendKeys(AppData.get("Password"));
        confirmPassword.sendKeys(AppData.get("Confirm password"));
        registerButton.click();
        ReporterExtension.log("Check success message displayed");
        verifyElementTextIsCorrect( "Registration is successful",registrationSuccess);

    }

   }
