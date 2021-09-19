
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AboutMe
{
    private WebDriver _webDriver;

    public AboutMe(WebDriver webDriver)
    {
        this._webDriver = webDriver;
    }
    
    public boolean atPage()
    {
        String currentUrl = _webDriver.getCurrentUrl();
        String partPageUrl = "https://shelly.kpfu.ru/e-ksu/new_stud_personal.stud_anketa";
        return (currentUrl.contains(partPageUrl));
    }
}
