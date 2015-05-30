/**
 * Created by test on 5/28/15.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class BrowserRunner {

    public static WebDriver runFirefoxWithTroubles() {
        FirefoxBinary binary = new FirefoxBinary();
        binary.setTimeout(90000); // default is 45000
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxDriver driver = new FirefoxDriver(binary, profile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver runFirefox(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver runChrome(){
        System.setProperty("webdriver.chrome.driver", "Libdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver runInternetExplorer(){
        System.setProperty("webdriver.ie.driver", "Libdrivers\\IEDriverServer64.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver runHtmlUnit(){
        WebDriver driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver runOpera(){
        System.setProperty("webdriver.opera.driver", "Libdrivers\\operadriver32.exe");
        WebDriver driver = new OperaDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
