
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MenuOfBlocks
{
    private WebDriver _webDriver;

    public MenuOfBlocks(WebDriver webDriver)
    {
        this._webDriver = webDriver;
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
        String thisPageUrl = "https://kpfu.ru/";
        return (currentUrl.equals(thisPageUrl));
    }
}
