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
                            WebElement passwordInput, WebElement submitButton){
        loginInput.clear();
        loginInput.sendKeys(login);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.click();
        return new MailPage(this.driver);
    }

    public MailPage doLoginGoogle(String login, String password, String loginXpath, String nextXpath,
                                  String passwordXpath, String submitXpath){
        WebElement loginInput = help.getByXpath(loginXpath);
        loginInput.clear();
        loginInput.sendKeys(login);
        WebElement next = help.getByXpath(nextXpath);
        next.click();
        WebElement passwordInput=help.getByXpath(passwordXpath);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        WebElement submitButton = help.getByXpath(submitXpath);
        submitButton.click();
        return new MailPage(this.driver);
    }
}
