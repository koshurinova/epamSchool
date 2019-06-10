package testsWP;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBase  {
    public WebDriver driver;
@BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
//    }

}

