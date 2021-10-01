

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class JUnitTest
{
    private static FileInputStream _fileInputStream;
    private static Properties _properties = new Properties();

    public static WebDriver _webDriver;
    public static MainPage _mainPage;
    public static MenuOfBlocks _menuOfBlocks;
    public static AboutMe _aboutMe;
    public static AcademicPerformance _academicPerformance;
    public static AcademicPerformanceDigitalTranscript _academicPerformanceDigitalTranscript;

    @BeforeClass
    public static void setup()
    {
        _webDriver = new ChromeDriver();
        _webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        _mainPage = new MainPage(_webDriver);
        _menuOfBlocks = new MenuOfBlocks(_webDriver);
        _menuOfBlocks = new MenuOfBlocks(_webDriver);
        _aboutMe = new AboutMe(_webDriver);
        _academicPerformance = new AcademicPerformance(_webDriver);
        _academicPerformanceDigitalTranscript = new AcademicPerformanceDigitalTranscript(_webDriver);
    }

    @Before
    public void loadMainUrl()
    {
        try
        {
            _fileInputStream = new FileInputStream(Props.PATH_TO_PROPERTIES);
            _properties.load(_fileInputStream);
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(AboutMe.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AboutMe.class.getName()).log(Level.SEVERE, null, ex);
        }

        _webDriver.get(_properties.getProperty("pageMain"));
    }

    @Test
    public void checkAboutMe()
    {
        _mainPage.clickPersonalAccount();
        _mainPage.enterUserName(_properties.getProperty("login"));
        _mainPage.enterPassword(_properties.getProperty("password"));
        _mainPage.clickLogin();
        _menuOfBlocks.clickAboutMe();
        //Строка для падения теста
        //_webDriver.findElement(By.id("ABOBA"));
        assertTrue(_aboutMe.atPage());
    }

    @Test
    public void checkAcademicPerformance()
    {
        _mainPage.clickPersonalAccount();
        _mainPage.enterUserName(_properties.getProperty("login"));
        _mainPage.enterPassword(_properties.getProperty("password"));
        _mainPage.clickLogin();
        _menuOfBlocks.clickAcademicPerformance();
        _academicPerformance.clickAcademicPerformanceDigitalTranscript();
        assertTrue(_academicPerformanceDigitalTranscript.atPage());
    }

    @AfterClass
    public static void tearDown()
    {
        _webDriver.quit();
    }
}

