

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MenuOfBlocks
{
    private static FileInputStream _fileInputStream;
    private static Properties _properties = new Properties();
    
    private WebDriver _webDriver;

    public MenuOfBlocks(WebDriver webDriver)
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

    public void clickAcademicPerformance()
    {
        _webDriver.findElement(By.xpath("//*[@id=\"main-blocks\"]/div[1]/div[6]/a")).click();
    }

    public void clickAboutMe()
    {
        _webDriver.findElement(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[2]/i")).click();
    }

    public boolean atPage()
    {
        String currentUrl = _webDriver.getCurrentUrl();
        return (currentUrl.equals(_properties.getProperty("pageMenuOfBlocks")));
    }
}

