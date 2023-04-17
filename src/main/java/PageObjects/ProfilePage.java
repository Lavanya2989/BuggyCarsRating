package PageObjects;

import BasePackage.BasePage;
import BasePackage.ReporterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender")
    WebElement gender;

    @FindBy(id = "age")
    WebElement age;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement save;

    @FindBy(xpath = "//div[contains(text(),'The profile has been saved successful')]")
    WebElement successMessage;

    @FindBy(xpath = "//a[text()='Profile']")
    public WebElement profileLink;

    @FindBy(id = "hobby")
    public WebElement hobby;

    public void profileUpdate() {

        profileLink.click();
        gender.clear();
        gender.click();
        gender.sendKeys(AppData.get("gender"));
        age.clear();
        age.sendKeys(AppData.get("age"));
        address.clear();
        address.sendKeys(AppData.get("address"));
        hobby.click();
        Select drpHobby = new Select(hobby);
        drpHobby.selectByVisibleText("Reading");
        save.click();
        ReporterExtension.log("Check profile has been saved successfully");
        Assert.assertEquals("The profile has been saved successful", successMessage.getText());
    }

}
