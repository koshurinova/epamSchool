package pages.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseURL ="http://localhost/wordpress/wp-login.php";

    public HomePage goToMainPage(){
        driver.get(baseURL);
        return this;
    }

    public LoginPage goToLoginPage(){

        return new LoginPage(driver);
    }

    public PostPage goToPostPage(){

        return new PostPage(driver);
    }
}
