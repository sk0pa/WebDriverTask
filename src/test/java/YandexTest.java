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
    public void loginToYandex() {
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement toField = helper.getByXpath(Locators.YANDEX_XPATH_TO);
        WebElement subjField = helper.getByXpath(Locators.YANDEX_XPATH_SUBJ);
        WebElement bodyField = helper.getByXpath(Locators.YANDEX_XPATH_BODY);
        String to = Locators.LOGIN+Locators.DOMAIN_GMAIL;
        mailPage.startLetter(to, Locators.SUBJECT, Locators.BODY, toField,
                subjField, bodyField);

        WebElement saveButton = helper.getByXpath(Locators.YANDEX_XPATH_SAVEDRAFT);
        mailPage.saveDraft(saveButton);
        WebElement cancel = helper.getByXpath("//button[@data-action='dialog.dont_save']");
        WebElement confirm = helper.getByXpath(Locators.YANDEX_XPATH_CONFIRM_SAVEDRAFT);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        confirm.click();
    }

    @Test(priority=2, description = "Check letter in drafts and send")
    public void sendLetter() throws Exception{
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(3000);


        WebElement draftLink = helper.getByXpath(Locators.YANDEX_XPATH_DRAFTS);

        DraftPage draftPage = mailPage.goToDraft(draftLink);
        if(!helper.isElementEnableByXpath(Locators.YANDEX_XPATH_LAST_DRAFT)){
            draftLink.click();
        }
        Thread.sleep(3000);
//        WebElement lastDraftText = helper.getByXpath(Locators.YANDEX_XPATH_DRAFT_TEXT);
        WebElement lastDraft = helper.getElementClickableByXpath(Locators.YANDEX_XPATH_LAST_DRAFT);
       // Assert.assertTrue(lastDraftText.getText().contains(Locators.BODY));
        draftPage.openLastDraft(lastDraft);

     //   WebElement lastDraft = helper.getByXpath(Locators.YANDEX_XPATH_LAST_DRAFT);
       // WebElement lastDraftText = helper.getByXpath(Locators.YANDEX_XPATH_DRAFT_TEXT);
     //   Assert.assertEquals(lastDraftText.getText(),Locators.BODY);
      //  draftPage.openLastDraft(lastDraft);
        WebElement copySMS = helper.getByXpath("//div[@class='b-yabble__link js-sms-open-link daria-action']");

        WebElement sendButton = helper.getByXpath(Locators.YANDEX_XPATH_SEND_BUTTON);
        draftPage.sendLetter(sendButton);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        WebElement sentLetters = helper.getByXpath(Locators.YANDEX_XPATH_SENT_LETTERS);
        sentLetters.click();
        sentLattesPage = draftPage.goToSentPage(sentLetters);
    }

    @Test(priority=3, description = "Check letter in sent")
    public void checkInSent(){
        if(!helper.isElementEnableByXpath(Locators.YANDEX_XPATH_LAST_SENT_LETTER)){
        WebElement sentLetters = helper.getByXpath(Locators.YANDEX_XPATH_SENT_LETTERS);
        sentLetters.click();
        }
        Assert.assertTrue(helper.isElementPresentByXpath(Locators.YANDEX_XPATH_LAST_SENT_LETTER));
    }

    @Test(priority=4, description = "Logout")
    public void logout(){
        WebElement settings = helper.getByXpath(Locators.YANDEX_XPATH_SETTINGS);
        settings.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement logout = helper.getByXpath(Locators.YANDEX_XPATH_LOGOUT);
        logout.click();
        Assert.assertTrue(helper.isElementPresentByXpath(Locators.YANDEX_XPATH_LOGIN));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
