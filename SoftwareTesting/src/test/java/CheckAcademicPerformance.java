
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckAcademicPerformance
{
    public static WebDriver _webDriver;
    public static MainPage _mainPage;
    public static MenuOfBlocks _menuOfBlocks;
    public static AcademicPerformance _academicPerformance;
    public static AcademicPerformanceDigitalTranscript _academicPerformanceDigitalTranscript;
    private String _userName = "DmiAKolesnikov";
    private String _password = "226tg34r";        
    
    
    @BeforeClass
    public static void setup()
    {
        _webDriver = new ChromeDriver();
        _mainPage = new MainPage(_webDriver);
        _menuOfBlocks = new MenuOfBlocks(_webDriver);
        _academicPerformance = new AcademicPerformance(_webDriver);
        _academicPerformanceDigitalTranscript = new AcademicPerformanceDigitalTranscript(_webDriver);
        
        _webDriver.get("https://kpfu.ru");
    }
    
    @Test
    @Step
    public void checkAcademicPerformance()
    {
        _mainPage.clickPersonalAccount();
        _mainPage.enterUserName(_userName);
        _mainPage.enterPassword(_password);
        _mainPage.clickLogin();
        _menuOfBlocks.clickAcademicPerformance();
        _academicPerformance.clickAcademicPerformanceDigitalTranscript();
        assertEquals(true, _academicPerformanceDigitalTranscript.atPage());
    }
    
    @After
    public void tearDown()
    {
        _webDriver.close();
    }
}
