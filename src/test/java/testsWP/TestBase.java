package testsWP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBase {
//    public WebDriver driver;

//    @BeforeClass
//    public void setup(){
//        System.setProperty("webdriver.chrome.driver","/tools/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//    @Test
//    @Parameters({"baseUrl"})
//    public void goStartPage(String baseUrl){
//
//        driver.navigate().to(baseUrl);
//        System.out.println("текст в тесте");
//    }

    @Test
    @Parameters("adminPass")
    public void goStartPage(String adminPass){

        System.out.println("текст в тесте " + adminPass);
    }
//    @AfterClass
//    public void teardown(){
//        driver.quit();
//    }

}

