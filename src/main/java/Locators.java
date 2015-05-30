public class Locators {
    public static final String LOGIN = "Webdriver42";
    public static final String PASSWORD = "webdriver123";
    public static final String PASSWORDMAILRU = "webdriver123123123";
    public static final String SUBJECT = "WebdriverLetter";
    public static final String BODY = "Webdriver42Webdriver";
    public static final String DOMAIN_GMAIL = "@gmail.com";
    public static final String DOMAIN_MAILRU = "@mail.ru";
    public static final String DOMAIN_IUA = "@i.ua";
    public static final String DOMAIN_YANDEX = "@yandex.ru";
    public static final String URL_YANDEX = "https://yandex.ru";
    public static final String URL_IUA = "http://www.i.ua/";
    public static final String URL_MAILRU = "https://mail.ru";
    public static final String URL_GOOGLE = "https://www.gmail.com";
    public static final String MAILRU_ID_LOGIN = "mailbox__login";
    public static final String MAILRU_ID_PASSWORD = "mailbox__password";
    public static final String MAILRU_ID_SUBMIT = "mailbox__auth__button";
    public static final String MAILRU_ID_LOGOUT = "PH_logoutLink";
    public static final String MAILRU_XPATH_CREATE_LETTER = "//a[@data-name='compose']";
    public static final String MAILRU_XPATH_TO="//textarea[@data-original-name='To']";
    public static final String MAILRU_XPATH_SUBJ="//input[@name='Subject']";
    public static final String MAILRU_XPATH_BODY="//textarea[@name='Body']";
    public static final String MAILRU_XPATH_SAVEDRAFT="//a[@data-name='saveDraft']";
    public static final String MAILRU_XPATH_DRAFTS="a[@href='/messages/drafts/']";
    public static final String MAILRU_XPATH_LAST_DRAFT ="div[@id='b-letters']//div[@class='b-datalist__item__body'][1]//a";
    public static final String MAILRU_XPATH_SEND_BUTTON = "div[@data-name='send']";
    public static final String MAILRU_XPATH_SENT_LETTERS ="a[@href='/messages/sent/']";
    public static final String MAILRU_XPATH_LAST_SENT_LETTER="div[@id='b-letters']//div[@class='b-datalist__item__body'][1]//a";
    public static final String MAILRU_XPATH_STATUS_LINE ="div[@data-mnemo='saveStatus']";
    public static final String MAILRU_XPATH_SENT_LETTER_SUBJ="div[@class='b-letter__head__subj__text']";

    public static final String IUA_XPATH_LOGIN = "//input[@name='login']";
    public static final String IUA_XPATH_PASSWORD = "//input[@name='pass']";
    public static final String IUA_XPATH_SUBMIT = "//input[@value='Войти']";
    public static final String IUA_XPATH_SETTINGS = "//span[@title='Настройки']";
    public static final String IUA_XPATH_LOGOUT = "//a[contains(text(),'Выйти')]";
    public static final String IUA_XPATH_CREATE_LETTER = "//p[@class=\"make_message\"]//a";
    public static final String IUA_XPATH_TO="//textarea[@id='to']";
    public static final String IUA_XPATH_SUBJ="//input[@name='subject']";
    public static final String IUA_XPATH_BODY="//textarea[@id='text']";
    public static final String IUA_XPATH_SAVEDRAFT="//input[@name='save_in_drafts']";
    public static final String IUA_XPATH_DRAFTS="//a[contains(@href, 'list/drafts')]";
    public static final String IUA_XPATH_LAST_DRAFT ="//div[@id='mesgList']//form[@name='aform']//div[contains(concat(' ',@class, ' '),' row ')][1]//a";
    public static final String IUA_XPATH_SEND_BUTTON = "//input[@value=\"Отправить\"]";
    public static final String IUA_XPATH_SENT_LETTERS ="//a[contains(@href, 'list/sent-mail')]";
    public static final String IUA_XPATH_LAST_SENT_LETTER="//div[@id='mesgList']//div[@class='row'][1]//a";
    public static final String IUA_XPATH_STATUS_LINE ="//div[@class='block_confirmation']//div[@class='content clear']";
    public static final String IUA_XPATH_SENT_LETTER_SUBJ="//div[contains(concat(' ',@class, ' '),' message_header ')]//h3";



}
