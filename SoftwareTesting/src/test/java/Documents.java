

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;


public class Documents
{
    private FileInputStream _fileInputStream;
    private Properties _properties = new Properties();

    public Documents()
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
    
    public void clickDocTemplates()
    {
        $(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[1]/a")).click();
    }
    
    public boolean atPage()
    {
        return (WebDriverRunner.url().contains(_properties.getProperty("documents")));
    }
}

