package PageObjects;

import BasePackage.BasePage;
import BasePackage.ReporterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PopularMakePage extends BasePage {
    public PopularMakePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h3[class='card-header']")
    public WebElement header;

    public void popularMake() {
        verifyElementTextIsCorrect("Alfa Romeo", header);
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='cars table table-hover']//thead//tr//th"));
        verifyElementTextIsCorrect("Model", columns.get(1));
        verifyElementTextIsCorrect("Rank", columns.get(2));
        verifyElementTextIsCorrect("Votes", columns.get(3));
        verifyElementTextIsCorrect("Comments", columns.get(4));
        ReporterExtension.log("Check Elements in popularMake are displayed");
    }
}
