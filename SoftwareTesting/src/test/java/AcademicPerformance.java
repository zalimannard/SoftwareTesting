
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AcademicPerformance
{
    private WebDriver _webDriver;

    public AcademicPerformance(WebDriver webDriver)
    {
        this._webDriver = webDriver;
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
        String partPageUrl = "https://shelly.kpfu.ru/e-ksu/main_blocks.startpage";
        return (currentUrl.contains(partPageUrl));
    }
}
