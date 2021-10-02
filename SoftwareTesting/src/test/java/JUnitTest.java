

import static com.codeborne.selenide.Selenide.open;
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

    @BeforeClass
    public static void setup()
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
    }

    @Before
    public void loadMainUrl()
    {
        open(_properties.getProperty("pageMain"));
    }

    @Test
    public void checkAboutMe()
    {
        MainPage mainPage = new MainPage();
        MenuOfBlocks menuOfBlocks = new MenuOfBlocks();
        AboutMe aboutMe = new AboutMe();
        
        mainPage.clickPersonalAccount();
        mainPage.enterUserName(_properties.getProperty("login"));
        mainPage.enterPassword(_properties.getProperty("password"));
        mainPage.clickLogin();
        menuOfBlocks.clickAboutMe();
        assertTrue(aboutMe.atPage());
    }

    @Test
    public void checkAcademicPerformance()
    {
        MainPage mainPage = new MainPage();
        MenuOfBlocks menuOfBlocks = new MenuOfBlocks();
        AcademicPerformance academicPerformance = new AcademicPerformance();
        AcademicPerformanceDigitalTranscript academicPerformanceDigitalTranscript = new AcademicPerformanceDigitalTranscript();
    
        mainPage.clickPersonalAccount();
        mainPage.enterUserName(_properties.getProperty("login"));
        mainPage.enterPassword(_properties.getProperty("password"));
        mainPage.clickLogin();
        menuOfBlocks.clickAcademicPerformance();
        academicPerformance.clickAcademicPerformanceDigitalTranscript();
        assertTrue(academicPerformanceDigitalTranscript.atPage());
    }
}

