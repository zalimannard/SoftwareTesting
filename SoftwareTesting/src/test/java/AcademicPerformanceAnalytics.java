
import org.openqa.selenium.WebDriver;

public class AcademicPerformanceAnalytics
{
    private WebDriver _webDriver;

    public AcademicPerformanceAnalytics(WebDriver webDriver)
    {
        this._webDriver = webDriver;
    }
    
    public boolean atPage()
    {
        String currentUrl = _webDriver.getCurrentUrl();
        String thisPageUrl = "https://shelly.kpfu.ru/e-ksu/SITE_STUDENT_SH_PR_AC.student_personal_marks?p_menu=8";
        return (currentUrl.equals(thisPageUrl));
    }
}
