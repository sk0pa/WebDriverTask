import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MailRuTest {
    static WebDriver driver = new FirefoxDriver();
    Helper helper;
    MailPage mailPage;
    SentLattesPage sentLattesPage;

    @BeforeClass
    public void setUp(){
        this.helper = new Helper(driver);
        driver.get(Locators.URL_MAILRU);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority=0, description = "Login to mail.ru")
    public void loginToMailRu() {
        LoginPage mainPage = new LoginPage(driver);
        WebElement loginField = helper.getById(Locators.MAILRU_ID_LOGIN);
        WebElement passwordField = helper.getById(Locators.MAILRU_ID_PASSWORD);
        WebElement submitButton = helper.getById(Locators.MAILRU_ID_SUBMIT);
        mailPage = mainPage.doLogin(Locators.LOGIN, Locators.PASSWORDMAILRU, loginField, passwordField, submitButton);
        Assert.assertTrue(helper.isElementPresentById(Locators.MAILRU_ID_LOGOUT));
    }

    @Test(priority=1, description = "Start write letter")
    public void startLetter(){
        WebElement newLetterButton = helper.getByXpath(Locators.MAILRU_XPATH_CREATE_LETTER);
        newLetterButton.click();
        WebElement toField = helper.getByXpath(Locators.MAILRU_XPATH_TO);
        WebElement subjField = helper.getByXpath(Locators.MAILRU_XPATH_SUBJ);
        WebElement bodyField = helper.getByXpath(Locators.MAILRU_XPATH_BODY);
        WebElement saveButton = helper.getByXpath(Locators.MAILRU_XPATH_SAVEDRAFT);
        String to = Locators.LOGIN+Locators.DOMAIN_YANDEX;
        mailPage.startLetter(to, Locators.SUBJECT, Locators.BODY, toField,
                subjField, bodyField, saveButton);
        WebElement statusLine = helper.getByXpath(Locators.MAILRU_XPATH_STATUS_LINE);
        Assert.assertTrue(statusLine.getText().contains("Сохранено в"));
    }

    @Test(priority=2, description = "Check letter in drafts and send")
    public void sendLetter(){
        WebElement draftLink = helper.getByXpath(Locators.MAILRU_XPATH_DRAFTS);
        DraftPage draftPage = mailPage.goToDraft(draftLink);
        WebElement lastDraft = helper.getByXpath(Locators.MAILRU_XPATH_LAST_DRAFT);
        draftPage.openLastDraft(lastDraft);
        WebElement toField = helper.getByXpath(Locators.MAILRU_XPATH_TO);
        WebElement bodyField = helper.getByXpath(Locators.MAILRU_XPATH_BODY);
        Assert.assertTrue(toField.getText().contains(Locators.LOGIN));
        Assert.assertTrue(bodyField.getText().contains(Locators.BODY));

        WebElement sendButton = helper.getByXpath(Locators.MAILRU_XPATH_SEND_BUTTON);
        draftPage.sendLetter(sendButton);
        WebElement sentLetters = helper.getByXpath(Locators.MAILRU_XPATH_SENT_LETTERS);
        sentLattesPage = draftPage.goToSendedPage(sentLetters);
    }

    @Test(priority=3, description = "Check letter in sent")
    public void checkInSent(){
        WebElement lastLetter = helper.getByXpath(Locators.MAILRU_XPATH_LAST_SENT_LETTER);
        sentLattesPage.openLastLetter(lastLetter);
        WebElement letterSubj = helper.getByXpath(Locators.MAILRU_XPATH_SENT_LETTER_SUBJ);
        Assert.assertTrue(letterSubj.getText().contains(Locators.SUBJECT));
    }

    @Test(priority=4, description = "Logout")
    public void logout(){
        WebElement logout = helper.getById(Locators.MAILRU_ID_LOGOUT);
        logout.click();
        Assert.assertTrue(helper.isElementPresentById(Locators.MAILRU_ID_LOGIN));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
