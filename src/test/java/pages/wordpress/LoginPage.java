package pages.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class LoginPage extends BasePage {
    By loginButton = By.id("wp-submit");
    By loginField = By.id("user_login");
    By passField = By.id("user_pass");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public PostPage goToPostPage(){

        return new PostPage(driver);
    }

    public LoginPage loginEnter(String login, String password) {

        click(loginField);
        writeText(loginField,login);
        click(passField);
        writeText(passField,password);
        click(loginButton);
        return this;
    }
}
