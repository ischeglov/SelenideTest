package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract public class BaseSelenideTest {

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/imshcheglov/Desktop/QA Test/chromedriver-mac-arm64/chromedriver");

        Configuration.browser = "chrome"; // указываем конфигурацию браузера
        Configuration.driverManagerEnabled = true; // указываем присутствие webdrivermanager
        Configuration.browserSize = "1920x1080"; // размер окна браузера
        Configuration.headless = false; //указываем, будем ли мы видеть браузер при выполнении тестов
        Configuration.pageLoadTimeout= (60000); // устанавливаем время ожидания загрузки веб-страницы
    }

    // перед каждым выполнением теста будет происходить инициализация webdriver
    @BeforeEach
    public void initialization() {
        setUp();
    }

    // после каждого выполнения теста будет происходить закрытие webdriver
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
