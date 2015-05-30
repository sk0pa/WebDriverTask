import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Skopa on 30.05.2015.
 */
public class SentLattesPage extends PageObject {
    public SentLattesPage(WebDriver driver) {
        super(driver);
    }

    public void openLastLetter(WebElement lastLetter){
        lastLetter.click();
    }
}
