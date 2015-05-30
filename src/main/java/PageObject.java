import org.openqa.selenium.WebDriver;

/**
 * Created by test on 5/28/15.
 */
public abstract class PageObject {
    WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
    }
}
