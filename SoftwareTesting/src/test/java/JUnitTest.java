
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class JUnitTest 
{
    public static WebDriver _webDriver;
    public static MainPage _mainPage;
    public static MenuOfBlocks _menuOfBlocks;
    public static AboutMe _aboutMe;
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
        _menuOfBlocks = new MenuOfBlocks(_webDriver);
        _aboutMe = new AboutMe(_webDriver);
        _academicPerformance = new AcademicPerformance(_webDriver);
        _academicPerformanceDigitalTranscript = new AcademicPerformanceDigitalTranscript(_webDriver);
    }
    
    @Before
    public void loadMainUrl()
    {
        _webDriver.get("https://kpfu.ru");
    }
    
    @Test
    public void checkAboutMe()
    {
        _mainPage.clickPersonalAccount();
        _mainPage.enterUserName(_userName);
        _mainPage.enterPassword(_password);
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
        _mainPage.enterUserName(_userName);
        _mainPage.enterPassword(_password);
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