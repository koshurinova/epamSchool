package testsWP;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import pages.wordpress.BasePage;
import pages.wordpress.LoginPage;


public class LoginTest extends BasePage {

//    protected static LoginPage loginPage;

    public LoginTest(WebDriver driver) {
        super(driver);
    }


//    public LoginTest(WebDriver driver) {
//        super(driver);
//    }

@Test
public void Proba(){
    System.out.println("текст в тесте");
}


//    @BeforeSuite
//    public void precondition() {
//        init();
//
//    }
//
//    @Test //потом перенести в TestBase или прекондишн
//
//    public void authorizationTest() {
//        loginPage.login();
//        Assert.assertEquals(driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account' and contains(@class, 'menupop')]/a[contains(@class, 'ab-item')]")).getText(), "Привет, admin");
//    }
//
//    @AfterSuite
//    public void postcondition() {
//        driver.quit();
//    }
}


