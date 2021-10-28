import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Properties;

import static org.junit.Assert.assertTrue;


public class steps {
    MainPage mainPage = new MainPage();
    MenuWithBlocks menuWithBlocks = new MenuWithBlocks();
    AcademicPerformance academicPerformance = new AcademicPerformance();
    AcademicPerformanceDigitalTranscript academicPerformanceDigitalTranscript = new AcademicPerformanceDigitalTranscript();
    AboutMe aboutMe = new AboutMe();
    Messages messages = new Messages();
    UnifiedServiceCenter unifiedServiceCenter = new UnifiedServiceCenter();
    Documents documents = new Documents();
    DocTemplates docTemplates = new DocTemplates();

    private static Properties _properties = new Properties();

    @Given("Открыть kpfu.ru")
    public void open_kpfu_ru() {
        Selenide.open("https://kpfu.ru");
    }

    @When("Нажать на кнопку {string}")
    public void pressButtonWithText(String arg0) {
        if (arg0.equals("Личный кабинет")) {
            mainPage.clickPersonalAccount();
        } else if (arg0.equals("Отправить")) {
            mainPage.clickLogin();
        } else if (arg0.equals("Успеваемость")) {
            menuWithBlocks.clickAcademicPerformance();
        } else if (arg0.equals("Обо мне")) {
            menuWithBlocks.clickAboutMe();
        } else if (arg0.equals("Сообщения")) {
            menuWithBlocks.clickMessage();
        } else if (arg0.equals("Единый центр обслуживания")) {
            academicPerformance.clickUnifiedServiceCenter();
        } else if (arg0.equals("Документы")) {
            unifiedServiceCenter.clickDocuments();
        } else if (arg0.equals("Шаблоны документов")) {
            documents.clickDocTemplates();
        }
    }

    @And("Ввести в поле {string} текст: {string}")
    public void typeToInputWithNameText(String arg0, String arg1) {
        if (arg0.equals("Введите логин")) {
            mainPage.enterUserName("DmiAKolesnikov");
        } else if (arg0.equals("Введите пароль")) {
            mainPage.enterPassword("226tg34r");
        }
    }

    @Then("На странице {string}")
    public void atPage(String arg0) {
        if (arg0.equals("Меню с блоками")) {
            assertTrue(menuWithBlocks.atPage());
        } else if (arg0.equals("Успеваемость")) {
            assertTrue(academicPerformance.atPage());
        } else if (arg0.equals("Обо мне")) {
            assertTrue(aboutMe.atPage());
        } else if (arg0.equals("Сообщения")) {
            assertTrue(messages.atPage());
        }
    }

    @And("Удалить старую фотографию")
    public void removeOldPhoto()
    {
        aboutMe.deletePhoto();
    }

    @And("Установить новую фотографию")
    public void setNewPhoto()
    {
        aboutMe.setPhoto("/run/media/zalimannard/Files/Online/Course3/Semester1/SoftwareTesting/SoftwareTesting/SoftwareTesting/src/Ya.png");
    }

    @Then("Фото установлено")
    public void isPhotoDisplayed()
    {
        Assert.assertTrue(aboutMe.isPhotoDisplayed());
    }

    @And("Скачать и проверить файл")
    public void downloadDocument()
    {
        String text = docTemplates.readPraktLeto();
        assertTrue(text.contains("для прохождения летней производственной практики по"));
    }
}
