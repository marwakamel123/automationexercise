package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoggedInHomePage;
import pages.LoginPage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static fileReaderManager.ReadFromFiles.getPropertyByKey;

public class BaseTests {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    LoggedInHomePage loggedInHomePage;
    String email;
    String password ;
    public static String configPropertyFileName =  "configData.properties" ;

    @BeforeMethod
    public void longinToHomePagePreCondition()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get((String) getPropertyByKey(configPropertyFileName , "APP_URL"));
        //email =(String) getPropertyByKey(configPropertyFileName , "EMAIL");
        //password = (String) getPropertyByKey(configPropertyFileName , "PASSWORD");
        //homePage = new HomePage(driver);
        //loginPage = homePage.clickSignInSignUpButton();
        //loggedInHomePage = loginPage.login(email,password);
    }

    @AfterMethod
    public void a_takeScreenshotForFailedTests (ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {FileUtils.copyFile(screenshot, new File("./images/" +result.getName() +".png"));}
            catch (IOException e) {System.out.println("I/O Error");}
        }
    }
    //@AfterMethod
    //public void z_quitDriver () {driver.quit();}

    /*
    public void assertEqualsLoop (List<String> actual, JSONArray expected, String msg) {
        for (int i = 0; i < actual.size(); i++)
        {Assert.assertEquals(actual.get(i), expected.get(i), msg +i+ " Should be : " + expected.get(i));}
    }
    public void assertContainsLoop (List<String> actual, String s, String msg) {
        for (int i = 0; i < actual.size(); i++)
        {Assert.assertTrue(actual.get(i).contains(s), msg +i+ " Should Contain : " + s);}
    }
    public void assertEqualsLoop (int[] actual, int[] expected, String msg) {
        for (int i = 0; i < actual.length; i++)
            {Assert.assertEquals(actual[i], expected[i], msg +i+ " Should be : " + expected[i]);}
    }
*/

}
