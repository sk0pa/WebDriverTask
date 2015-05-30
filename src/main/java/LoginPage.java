import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by test on 5/28/15.
 */
public class LoginPage extends PageObject {
    Helper help;

    public LoginPage(WebDriver driver){
        super(driver);
        help = new Helper(driver);
    }

    public MailPage doLogin(String login, String password, WebElement loginInput,
                            WebElement passwordInput, WebElement submitButtonId){
        loginInput.clear();
        loginInput.sendKeys(login);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButtonId.click();
        return new MailPage(this.driver);
    }
}
