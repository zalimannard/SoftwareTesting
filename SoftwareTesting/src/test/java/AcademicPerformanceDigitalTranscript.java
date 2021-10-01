

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;


public class AcademicPerformanceDigitalTranscript
{
    private FileInputStream _fileInputStream;
    private Properties _properties = new Properties();
    
    private WebDriver _webDriver;

    public AcademicPerformanceDigitalTranscript(WebDriver webDriver)
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

    public boolean atPage()
    {
        String currentUrl = _webDriver.getCurrentUrl();
        return (currentUrl.equals(_properties.getProperty("pageAcademicPerformanceDigitalTranscript")));
    }
}

