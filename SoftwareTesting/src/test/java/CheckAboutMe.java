
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckAboutMe
{
    public static WebDriver _webDriver;
    public static MainPage _mainPage;
    public static MenuOfBlocks _menuOfBlocks;
    public static AboutMe _aboutMe;
    private String _userName = "DmiAKolesnikov";
    private String _password = "226tg34r";        
    
    
    @BeforeClass
    public static void setup()
    {
        _webDriver = new ChromeDriver();
        _webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        _mainPage = new MainPage(_webDriver);
        _menuOfBlocks = new MenuOfBlocks(_webDriver);
        _aboutMe = new AboutMe(_webDriver);
        
        _webDriver.get("https://kpfu.ru");
    }
    
    @Test
    @Step
    public void checkAboutMe()
    {
        _mainPage.clickPersonalAccount();
        _mainPage.enterUserName(_userName);
        _mainPage.enterPassword(_password);
        _mainPage.clickLogin();
        _menuOfBlocks.clickAboutMe();
        //Строка для падения теста
        //_webDriver.findElement(By.id("ABOBA"));
        assertEquals(true, _aboutMe.atPage());
    }
    
    @After
    public void tearDown()
    {
        _webDriver.close();
    }
}
