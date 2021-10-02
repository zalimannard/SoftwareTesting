

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.WebDriverRunner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;


public class MainPage
{
    private static FileInputStream _fileInputStream;
    private static Properties _properties = new Properties();

    public MainPage()
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

    public void enterUserName(String login)
    {
        $(By.name("p_login")).val(login);
    }

    public void enterPassword(String password)
    {
        $(By.name("p_pass")).val(password);
    }

    public void clickPersonalAccount()
    {
        $(By.xpath("//*[@id=\"top-panel\"]/div[1]/div[1]/a")).click();
    }

    public void clickLogin()
    {
        $(By.xpath("//*[@id=\"eu_enter\"]/input[3]")).submit();
    }

    public void open()
    {
        Selenide.open(_properties.getProperty("pageMain"));
    }

    public boolean isLoginWindowOpened()
    {
        
        return $(By.name("p_login")).isDisplayed();
    }

    public boolean atPage()
    {
        return (WebDriverRunner.url().equals(_properties.getProperty("pageMain")));
    }
}

