package PageObjects;

import BasePackage.BasePage;
import BasePackage.ReporterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OverAllRating extends BasePage {
    public OverAllRating(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[contains(text(),'View more')])[1]")
    public WebElement viewMore;

    @FindBy(xpath = "//button[contains(text(),'Vote')]")
    public List<WebElement> voteButton;

    @FindBy(id = "comment")
    WebElement comment;

    @FindBy(xpath = "//button[contains(text(),'Vote')]")
    public WebElement voteButton1;

    @FindBy(xpath = "//h4[contains(text(),'Votes')]/strong")
    WebElement votes;

    @FindBy(xpath = "//p[@class='card-text']")
    WebElement messageAfterVote;

    public int Rating() {
        viewMore.click();

        if (voteButton.size() > 0) {

            int voteCountBefore = getVotes();
            comment.sendKeys("Good looking");
            voteButton1.click();
            int voteCountAfter = getVotes();
            while (voteCountAfter == voteCountBefore) {
                voteCountAfter = getVotes();
            }
            return voteCountAfter - voteCountBefore;

        } else {
            verifyElementTextIsCorrect("Thank you for your vote!", messageAfterVote);
            ReporterExtension.log("Check message displayed");
        }

        return 0;
    }

    private int getVotes() {
        return Integer.parseInt(votes.getText());
    }
}
