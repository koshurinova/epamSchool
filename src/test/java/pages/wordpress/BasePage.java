package pages.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



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
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

}
