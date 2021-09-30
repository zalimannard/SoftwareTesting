
import org.openqa.selenium.WebDriver;

public class AcademicPerformanceDigitalTranscript
{
    private WebDriver _webDriver;

    public AcademicPerformanceDigitalTranscript(WebDriver webDriver)
    {
        this._webDriver = webDriver;
    }
    
    public boolean atPage()
    {
        String currentUrl = _webDriver.getCurrentUrl();
        String thisPageUrl = "https://shelly.kpfu.ru/e-ksu/SITE_STUDENT_SH_PR_AC.score_list_book_subject?p_menu=7";
        return (currentUrl.equals(thisPageUrl));
    }
}
