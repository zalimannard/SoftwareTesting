

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.WebDriverRunner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;


public class UnifiedServiceCenter
{
    private FileInputStream _fileInputStream;
    private Properties _properties = new Properties();

    public UnifiedServiceCenter()
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
    
    public void clickDocuments()
    {
        $(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[8]")).click();
    }
    
    public boolean atPage()
    {
        return (WebDriverRunner.url().contains(_properties.getProperty("unifiedServiceCenter")));
    }
}

