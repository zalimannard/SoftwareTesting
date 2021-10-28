

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;


public class AboutMe
{
    private FileInputStream _fileInputStream;
    private Properties _properties = new Properties();

    public AboutMe()
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
    
    @Step("Проверка, что файл удалился")
    public void deletePhoto()
    {
        $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[2]/div[2]")).should(Condition.exist).click();
        $(By.xpath("//*[@id=\"answer\"]/a[1]")).shouldBe(Condition.visible).click();
        Assert.assertTrue($(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[1]/input")).isDisplayed());
    }

    public void setPhoto(String newPhoto)
    {
        $(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[2]/i")).click();
        $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[1]/input")).uploadFile(new File(newPhoto));
        $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[2]/input")).click();
    }

    public boolean isPhotoDisplayed()
    {
        return $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[2]/div[2]")).isDisplayed();
    }
    
    public boolean atPage()
    {
        return (WebDriverRunner.url().contains(_properties.getProperty("pageAboutMe")));
    }
}

