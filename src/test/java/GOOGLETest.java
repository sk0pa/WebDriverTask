import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Skopa on 31.05.2015.
 */
public class GoogleTest {
    static WebDriver driver = new FirefoxDriver();
    Helper helper;
    MailPage mailPage;
    SentLattesPage sentLattesPage;

    @BeforeClass
    public void setUp(){
        this.helper = new Helper(driver);
        driver.get(Locators.URL_GOOGLE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority=0, description = "Login to i.ua")
    public void loginToGoogle() {
        LoginPage mainPage = new LoginPage(driver);
        if(helper.isElementPresentByXpath(Locators.GOOGLE_XPATH_CHOOSE_ANOTHER_ACCOUNT)){
            helper.getByXpath(Locators.GOOGLE_XPATH_CHOOSE_ANOTHER_ACCOUNT).click();
            helper.getByXpath(Locators.GOOGLE_XPATH_ADD_ANOTHER_ACCOUNT).click();
        }
        String login = Locators.LOGIN + Locators.DOMAIN_GMAIL;
        mailPage = mainPage.doLoginGoogle(login, Locators.PASSWORD,
                Locators.GOOGLE_XPATH_LOGIN, Locators.GOOGLE_XPATH_NEXT_BUTTON,
                Locators.GOOGLE_XPATH_PASSWORD, Locators.GOOGLE_XPATH_SUBMIT);
        Assert.assertTrue(helper.isElementPresentByXpath(Locators.GOOGLE_XPATH_SETTINGS));
    }

    @Test(priority=1, description = "Start write letter")
    public void startLetter(){
        WebElement newLetterButton = helper.getByXpath(Locators.GOOGLE_XPATH_CREATE_LETTER);
        newLetterButton.click();
        WebElement toField = helper.getByXpath(Locators.GOOGLE_XPATH_TO);
        WebElement subjField = helper.getByXpath(Locators.GOOGLE_XPATH_SUBJ);
        WebElement bodyField = helper.getByXpath(Locators.GOOGLE_XPATH_BODY);
        String to = Locators.LOGIN+Locators.DOMAIN_YANDEX;
        mailPage.startLetter(to, Locators.SUBJECT, Locators.BODY, toField,
                subjField, bodyField);
        WebElement saveButton = helper.getByXpath(Locators.GOOGLE_XPATH_SAVEDRAFT);
        mailPage.saveDraft(saveButton);
  //
    }

    @Test(priority=2, description = "Check letter in drafts and send")
    public void sendLetter() throws Exception{
        WebElement draftLink = helper.getByXpath(Locators.GOOGLE_XPATH_DRAFTS);
        DraftPage draftPage = mailPage.goToDraft(draftLink);
   //  /   if (!helper.getByXpath(Locators.GOOGLE_XPATH_SEARCH).getText().contains("in:draft")){
     //   }
//
        Thread.sleep(2000);


        WebElement lastDraft = helper.getByXpath(Locators.GOOGLE_XPATH_LAST_DRAFT);
        draftPage.openLastDraft(lastDraft);

        WebElement bodyField = helper.getByXpath(Locators.GOOGLE_XPATH_BODY);
        Assert.assertTrue(bodyField.getText().contains(Locators.BODY));

        WebElement sendButton = helper.getByXpath(Locators.GOOGLE_XPATH_SEND_BUTTON);
        draftPage.sendLetter(sendButton);

        Assert.assertTrue(helper.isElementPresentByXpath(Locators.GOOGLE_XPATH_STATUS_LINE));

        WebElement sentLetters = helper.getByXpath(Locators.GOOGLE_XPATH_SENT_LETTERS);
        sentLattesPage = draftPage.goToSentPage(sentLetters);

    }

    @Test(priority=3, description = "Check letter in sent")
    public void checkInSent() throws Exception{
        Thread.sleep(2000);
        WebElement lastLetter = helper.getByXpath(Locators.GOOGLE_XPATH_LAST_DRAFT);
        sentLattesPage.openLastLetter(lastLetter);
        WebElement letterSubj = helper.getByXpath(Locators.GOOGLE_XPATH_SENT_LETTER_SUBJ);
        Assert.assertTrue(letterSubj.getText().contains(Locators.SUBJECT));
    }

    @Test(priority=4, description = "Logout")
    public void logout(){
        WebElement settings = helper.getByXpath(Locators.GOOGLE_XPATH_SETTINGS);
        settings.click();
        WebElement logout = helper.getByXpath(Locators.GOOGLE_XPATH_LOGOUT);
        logout.click();
 //       Assert.assertTrue(driver.getTitle().contains("Gmail"));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
