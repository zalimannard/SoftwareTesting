

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.WebDriverRunner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;


public class MenuOfBlocks
{
    private static FileInputStream _fileInputStream;
    private static Properties _properties = new Properties();

    public MenuOfBlocks()
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

    public void clickAcademicPerformance()
    {
        $(By.xpath("//*[@id=\"main-blocks\"]/div[1]/div[6]/a")).click();
    }

    public void clickAboutMe()
    {
        $(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[2]/i")).click();
    }

    public boolean atPage()
    {
        return (WebDriverRunner.url().equals(_properties.getProperty("pageMenuOfBlocks")));
    }
}

