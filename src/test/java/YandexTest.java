import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Skopa on 30.05.2015.
 */
public class YandexTest {
    static WebDriver driver = new FirefoxDriver();
    Helper helper;
    MailPage mailPage;
    SentLattesPage sentLattesPage;

    @BeforeClass
    public void setUp(){
        this.helper = new Helper(driver);
        driver.get(Locators.URL_YANDEX);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority=0, description = "Login to yandex.ua")
    public void loginToIUA() {
        LoginPage mainPage = new LoginPage(driver);
        WebElement loginField = helper.getByXpath(Locators.YANDEX_XPATH_LOGIN);
        WebElement passwordField = helper.getByXpath(Locators.YANDEX_XPATH_PASSWORD);
        WebElement submitButton = helper.getByCss(Locators.YANDEX_CSS_SUBMIT);
        mailPage = mainPage.doLogin(Locators.LOGIN, Locators.PASSWORD, loginField, passwordField, submitButton);
        Assert.assertTrue(helper.isElementPresentByXpath(Locators.YANDEX_XPATH_SETTINGS));
    }

    @Test(priority=1, description = "Start write letter")
    public void startLetter(){
        WebElement newLetterButton = helper.getByXpath(Locators.YANDEX_XPATH_CREATE_LETTER);
        newLetterButton.click();
        WebElement toField = helper.getByXpath(Locators.YANDEX_XPATH_TO);
        WebElement subjField = helper.getByXpath(Locators.YANDEX_XPATH_SUBJ);
        WebElement bodyField = helper.getByXpath(Locators.YANDEX_XPATH_BODY);
        String to = Locators.LOGIN+Locators.DOMAIN_GMAIL;
        mailPage.startLetter(to, Locators.SUBJECT, Locators.BODY, toField,
                subjField, bodyField);
       // WebElement statusLine = helper.getByXpath(Locators.YANDEX_XPATH_STATUS_LINE);
       // Assert.assertTrue(statusLine.getText().contains("Сохранено"));
        WebElement saveButton = helper.getByXpath(Locators.YANDEX_XPATH_SAVEDRAFT);
        mailPage.saveDraft(saveButton);
        WebElement confirm = helper.getByXpath(Locators.YANDEX_XPATH_CONFIRM_SAVEDRAFT);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        confirm.click();

    }

    @Test(priority=2, description = "Check letter in drafts and send")
    public void sendLetter(){

        WebElement draftLink = helper.getByXpath(Locators.YANDEX_XPATH_DRAFTS);
        DraftPage draftPage = mailPage.goToDraft(draftLink);
        WebElement lastDraft = helper.getByXpath(Locators.YANDEX_XPATH_LAST_DRAFT);
        draftPage.openLastDraft(lastDraft);

    //    WebElement subjField = helper.getByXpath(Locators.YANDEX_XPATH_SUBJ);
    //    WebElement bodyField = helper.getByXpath(Locators.YANDEX_XPATH_BODY);
    //    System.out.println(subjField.getText());
    //    System.out.println(bodyField.getText());
    //    Assert.assertTrue(bodyField.getText().contains(Locators.BODY));

        WebElement sendButton = helper.getByXpath(Locators.YANDEX_XPATH_SEND_BUTTON);
        draftPage.sendLetter(sendButton);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement sentLetters = helper.getByXpath(Locators.YANDEX_XPATH_SENT_LETTERS);
        sentLattesPage = draftPage.goToSendedPage(sentLetters);
    }

    @Test(priority=3, description = "Check letter in sent")
    public void checkInSent(){
        WebElement lastLetter = helper.getByXpath(Locators.YANDEX_XPATH_LAST_SENT_LETTER);
        sentLattesPage.openLastLetter(lastLetter);
        WebElement letterSubj = helper.getByXpath(Locators.YANDEX_XPATH_SENT_LETTER_SUBJ);
        Assert.assertTrue(letterSubj.getText().contains(Locators.SUBJECT));
    }

    @Test(priority=4, description = "Logout")
    public void logout(){
        WebElement settings = helper.getByXpath(Locators.YANDEX_XPATH_SETTINGS);
        settings.click();
        WebElement logout = helper.getByXpath(Locators.YANDEX_XPATH_LOGOUT);
        logout.click();
        Assert.assertTrue(helper.isElementPresentByXpath(Locators.YANDEX_XPATH_LOGIN));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
