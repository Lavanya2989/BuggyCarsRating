package PageObjects;

import BasePackage.BasePage;
import BasePackage.ReporterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name=login]")
    public WebElement login;

    @FindBy(css = "input[name=password]")
    public WebElement password;

    @FindBy(css = "button.btn.btn-success")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Profile']")
    public WebElement profileLink;


    public void loginUser() {

        login.sendKeys(AppData.get("Loginname"));
        password.sendKeys(AppData.get("Login Password"));
        loginButton.click();
        Assert.assertTrue(profileLink.isDisplayed());
        ReporterExtension.log("Check login successfully");
    }
}
