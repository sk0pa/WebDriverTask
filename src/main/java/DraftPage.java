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

    public SentLattesPage goToSendedPage(WebElement sendButton, WebElement sentLettersLink){
        sendButton.click();
        sentLettersLink.click();
        return new SentLattesPage(this.driver);
    }

}
