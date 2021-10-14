

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


public class DocTemplates
{
    private FileInputStream _fileInputStream;
    private Properties _properties = new Properties();

    public DocTemplates()
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
    
    public String readPraktLeto()
    {
        File file = null;
        String fileString = null;
        try
        {
            file = $(By.xpath("//*[@id=\"tab1\"]/p[2]/a")).download();
            fileString = FileUtils.readFileToString(file, "Windows-1251");
        }
        catch (FileNotFoundException e)
        {
        }
        catch (IOException ex)
        {
            Logger.getLogger(DocTemplates.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileString;
    }
    
    public boolean atPage()
    {
        return (WebDriverRunner.url().contains(_properties.getProperty("docTemplates")));
    }
}

