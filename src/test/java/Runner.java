/**
 * Created by Skopa on 30.05.2015.
 */
public class Runner {
    public static void testFirefox(){
        IUATest.driver = BrowserRunner.runFirefox();
        IUATest iuaFFTest = new IUATest();
        YandexTest.driver = BrowserRunner.runFirefox();
        YandexTest yandexFFTest = new YandexTest();
        GoogleTest.driver = BrowserRunner.runFirefox();
        GoogleTest googleFFTest = new GoogleTest();
    }

    public static void testChrome() {
        IUATest.driver = BrowserRunner.runChrome();
        IUATest iuaCHRTest = new IUATest();
        YandexTest.driver = BrowserRunner.runChrome();
        YandexTest yandexCHRTest = new YandexTest();
        GoogleTest.driver = BrowserRunner.runChrome();
        GoogleTest googleCHRTest = new GoogleTest();
    }

    public static void testUnit() {
        IUATest.driver = BrowserRunner.runHtmlUnit();
        IUATest iuaUNTest = new IUATest();
        YandexTest.driver = BrowserRunner.runHtmlUnit();
        YandexTest yandexUNTest = new YandexTest();
        GoogleTest.driver = BrowserRunner.runHtmlUnit();
        GoogleTest googleUNTest = new GoogleTest();
    }

    public static void testIE() {
        IUATest.driver = BrowserRunner.runInternetExplorer();
        IUATest iuaIETest = new IUATest();
        YandexTest.driver = BrowserRunner.runInternetExplorer();
        YandexTest yandexIETest = new YandexTest();
        GoogleTest.driver = BrowserRunner.runInternetExplorer();
        GoogleTest googleIETest = new GoogleTest();
    }

    public static void testOpera() {
        IUATest.driver = BrowserRunner.runOpera();
        IUATest iuaOPTest = new IUATest();
        YandexTest.driver = BrowserRunner.runOpera();
        YandexTest yandexOPTest = new YandexTest();
        GoogleTest.driver = BrowserRunner.runOpera();
        GoogleTest googleOPTest = new GoogleTest();
    }

    public static void main(String[] args) {
        testFirefox();
        testChrome();
        testIE();
        testOpera();
        testUnit();
    }
}
