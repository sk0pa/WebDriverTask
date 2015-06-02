import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    private WebDriver driver;

    public Helper(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(String url){
        driver.get(url);
    }

    public WebElement getByCss(String selector){
        return new WebDriverWait(this.driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector(selector)));
    }

    public WebElement getByXpath(String xpath){
        return new WebDriverWait(this.driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                xpath(xpath)));
    }

    public WebElement getById(String id){
        return new WebDriverWait(this.driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                id(id)));
    }

    public WebElement getByName(String name){
        return new WebDriverWait(this.driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.
                name(name)));
    }

    public boolean isElementPresentByXpath(String xpath){
        return !this.driver.findElements(By.xpath(xpath)).isEmpty();
    }

    public boolean isElementPresentById(String id){
        return !this.driver.findElements(By.id(id)).isEmpty();
    }

    public boolean isElementEnableByXpath(String xpath){
        return this.driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public WebElement getElementClickableByXpath(String xpath){
        return new WebDriverWait(this.driver, 60).until(ExpectedConditions.elementToBeClickable(By.
                xpath(xpath)));
    }
}
