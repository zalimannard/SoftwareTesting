
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage
{
    private WebDriver _webDriver;

    public MainPage(WebDriver webDriver)
    {
        this._webDriver = webDriver;
    }
    
    
    public void enterUserName(String login)
    {
        _webDriver.findElement(By.name("p_login")).sendKeys(login);
    }
    
    public void enterPassword(String password)
    {
        _webDriver.findElement(By.name("p_pass")).sendKeys(password);
    }
    
    public void clickPersonalAccount()
    {
        _webDriver.findElement(By.id("top-panel")).click();
    }
    
    public void clickLogin()
    {
        _webDriver.findElement(By.id("eu_enter")).submit();
    }
    
    public void open()
    {
        _webDriver.get("http://kpfu.ru");
    }
    
    
    public boolean isLoginWindowOpened()
    {
        return _webDriver.findElement(By.name("p_login")).isDisplayed();
    }
    
    public boolean atPage()
    {
        String currentUrl = _webDriver.getCurrentUrl();
        String thisPageUrl = "https://kpfu.ru/";
        return (currentUrl.equals(thisPageUrl));
    }
}
