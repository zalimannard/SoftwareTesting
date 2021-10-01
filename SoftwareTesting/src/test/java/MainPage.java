

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage
{
    private static FileInputStream _fileInputStream;
    private static Properties _properties = new Properties();
    
    private WebDriver _webDriver;

    public MainPage(WebDriver webDriver)
    {
        this._webDriver = webDriver;
        
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

    public void enterUserName(String login)
    {
        _webDriver.findElement(By.name("p_login")).sendKeys(login);
    }

    public void enterPassword(String password)
    {
        _webDriver.findElement(By.name("p_pass")).sendKeys(password);
    }

    public void clickPersonalAccount()
    {
        _webDriver.findElement(By.id("top-panel")).click();
    }

    public void clickLogin()
    {
        _webDriver.findElement(By.id("eu_enter")).submit();
    }

    public void open()
    {
        _webDriver.get("http://kpfu.ru");
    }

    public boolean isLoginWindowOpened()
    {
        return _webDriver.findElement(By.name("p_login")).isDisplayed();
    }

    public boolean atPage()
    {
        String currentUrl = _webDriver.getCurrentUrl();
        return (currentUrl.equals(_properties.getProperty("pageMain")));
    }
}

