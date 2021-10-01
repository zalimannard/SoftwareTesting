

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AcademicPerformance
{
    private FileInputStream _fileInputStream;
    private Properties _properties = new Properties();

    private WebDriver _webDriver;

    public AcademicPerformance(WebDriver webDriver)
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

    public void clickAcademicPerformanceAnalytycs()
    {
        _webDriver.findElement(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[9]/span")).click();
    }

    public void clickAcademicPerformanceDigitalTranscript()
    {
        _webDriver.findElement(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[8]/span")).click();
    }

    public void clickAcademicPerformanceSemester()
    {
        _webDriver.findElement(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[7]/span")).click();
    }

    public boolean atPage()
    {
        String currentUrl = _webDriver.getCurrentUrl();
        return (currentUrl.contains(_properties.getProperty("pageAcademicPerformance")));
    }
}

