package pages.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {

        this.driver = driver;

    }

    public void init(){
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(("web.baseUrl"));
    }

    public void click (By elementBy){
//        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    public void clear (By elementBy){
//        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
    }
    public void writeText (By elementBy, String text){
//        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void assertEquals(By elementBy, String ExpectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), ExpectedText);
    }

    public String readText(By elementBy)
    {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
}
