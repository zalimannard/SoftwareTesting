

import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JUnitTest
{
    private static FileInputStream _fileInputStream;
    private static Properties _properties = new Properties();
    
    @BeforeClass
    public static void setup()
    {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
           .screenshots(true)
           .savePageSource(true)
        );
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
        MenuWithBlocks menuWithBlocks = new MenuWithBlocks();
        AboutMe aboutMe = new AboutMe();
        
        mainPage.clickPersonalAccount();
        mainPage.enterUserName(_properties.getProperty("login"));
        mainPage.enterPassword(_properties.getProperty("password"));
        mainPage.clickLogin();
        menuWithBlocks.clickAboutMe();
        assertTrue(aboutMe.atPage());
    }

    @Test
    public void checkAcademicPerformance()
    {
        MainPage mainPage = new MainPage();
        MenuWithBlocks menuWithBlocks = new MenuWithBlocks();
        AcademicPerformance academicPerformance = new AcademicPerformance();
        AcademicPerformanceDigitalTranscript academicPerformanceDigitalTranscript = new AcademicPerformanceDigitalTranscript();
    
        mainPage.clickPersonalAccount();
        mainPage.enterUserName(_properties.getProperty("login"));
        mainPage.enterPassword(_properties.getProperty("password"));
        mainPage.clickLogin();
        menuWithBlocks.clickAcademicPerformance();
        academicPerformance.clickAcademicPerformanceDigitalTranscript();
        assertTrue(academicPerformanceDigitalTranscript.atPage());
    }
    
    @Test
    public void checkDocument()
    {
        MainPage mainPage = new MainPage();
        MenuWithBlocks menuWithBlocks = new MenuWithBlocks();
        AcademicPerformance academicPerformance = new AcademicPerformance();
        AcademicPerformanceDigitalTranscript academicPerformanceDigitalTranscript = new AcademicPerformanceDigitalTranscript();
        UnifiedServiceCenter unifiedServiceCenter = new UnifiedServiceCenter();
        Documents documents = new Documents();
        DocTemplates docTemplates = new DocTemplates();
    
        mainPage.clickPersonalAccount();
        mainPage.enterUserName(_properties.getProperty("login"));
        mainPage.enterPassword(_properties.getProperty("password"));
        mainPage.clickLogin();
        menuWithBlocks.clickAcademicPerformance();
        academicPerformance.clickUnifiedServiceCenter();
        unifiedServiceCenter.clickDocuments();
        documents.clickDocTemplates();
        String text = docTemplates.readPraktLeto();
        assertTrue(text.contains("?????? ?????????????????????? ???????????? ???????????????????????????????? ???????????????? ????"));
    }
    
    @Test
    public void changeLkPhoto ()
    {
        MainPage mainPage = new MainPage();
        MenuWithBlocks menuWithBlocks = new MenuWithBlocks();
        AboutMe aboutMe = new AboutMe();
        
        mainPage.clickPersonalAccount();
        mainPage.enterUserName(_properties.getProperty("login"));
        mainPage.enterPassword(_properties.getProperty("password"));
        mainPage.clickLogin();
        menuWithBlocks.clickAboutMe();
        aboutMe.deletePhoto();
        aboutMe.setPhoto(_properties.getProperty("photo"));
        assertTrue(true);
    }
}

