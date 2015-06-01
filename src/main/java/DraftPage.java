import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Skopa on 30.05.2015.
 */
public class DraftPage extends PageObject {
    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public void openLastDraft(WebElement lastDraft){
        lastDraft.click();
    }

    public void sendLetter(WebElement sendButton){
        sendButton.click();
    }

    public SentLattesPage goToSentPage(WebElement sentLettersLink){
        sentLettersLink.click();
        return new SentLattesPage(this.driver);
    }

}
