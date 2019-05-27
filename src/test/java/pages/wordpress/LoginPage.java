package pages.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class LoginPage extends BasePage {
    private final Properties properties ;
    public LoginPage(WebDriver driver) {
        super(driver);
        properties = new Properties();
    }

    public LoginPage login() {

        driver.findElements(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(properties.getProperty("web.adminLogin"));
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys(properties.getProperty("web.adminPass"));
        driver.findElement(By.id("wp-submit")).click();
        return this;
    }
}
