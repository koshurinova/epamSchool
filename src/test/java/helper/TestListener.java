package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public abstract class TestListener implements ITestListener {

    WebDriver driver = null;
    String filepath="\\src\\screens";


    @Override
    public void onTestFailure(ITestResult result, ITestContext context) {
        System.out.println("Test " +result.getName()+" failed");
       String methodName=result.getName().toString().trim();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
       takeScreenShot(methodName, driver);
       
}

    public void takeScreenShot (String methodName, WebDriver driver) {
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
        FileUtils.copyFile(src, new File(filepath+methodName+".png"));
    }catch (IOException e){
                e.printStackTrace();}


    }
}
