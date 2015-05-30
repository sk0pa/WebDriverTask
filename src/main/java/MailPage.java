import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by test on 5/28/15.
 */
public class MailPage extends PageObject {
    Helper help;

    public MailPage(WebDriver driver){
        super(driver);
        this.help = new Helper(driver);
    }

    public void startLetter(String to, String subject, String body,
                            WebElement elementTo,
                            WebElement elementSubj,
                            WebElement elementBody,
                            WebElement saveLetter){
        elementTo.clear();
        elementTo.sendKeys(to);

        elementSubj.clear();
        elementSubj.sendKeys(subject);

        elementBody.clear();
        elementBody.sendKeys(body);

        saveLetter.click();
    }

    public DraftPage goToDraft(WebElement draftLink){
        draftLink.click();
        return new DraftPage(this.driver);
    }



}
