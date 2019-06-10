package testsWP;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.wordpress.BasePage;
import org.testng.annotations.Test;
import pages.wordpress.HomePage;
import pages.wordpress.LoginPage;


public class LoginTest extends testsWP.TestBase {

//    String login = "admin";
//    String password = "secret";
    private static final By HelloNick=By.xpath("//li[@id='wp-admin-bar-my-account' and contains(@class, 'menupop')]/a[contains(@class, 'ab-item')]");

@Parameters({"login", "password"})
@Test

public void loginSuccsess(String login, String password){
    System.out.println("Invoked testString " + login);
    HomePage homepage = new HomePage(driver);
    homepage.goToMainPage()
            .goToLoginPage()
            .loginEnter(login, password);

    Assert.assertEquals(driver.findElement(HelloNick).getText(), "Привет, "+login);



    }



}


