
import com.codeborne.selenide.Configuration;
import com.BaseConfig;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.ConstructorPage;
import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;


public class ConstructorTest {

    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @After
    public void closeBrowser() {
        close();
    }

    @Test
    @DisplayName("Проверка раздела Конструктор")
    @Description("Круговой проход по вкладкам")
    public void clickAllTabsTest() {

        ConstructorPage page = open(BaseConfig.BASE_URL, ConstructorPage.class);

        page.clickFillingTab();

        String actualTab = page.textActualTab("Начинки");
        assertEquals(actualTab, "Начинки");

        page.clickSauceTab();
        actualTab = page.textActualTab("Соусы");
        assertEquals(actualTab, "Соусы");

        page.clickBunTab();
        actualTab = page.textActualTab("Булки");
        assertEquals(actualTab, "Булки");

        //try { Thread.sleep(3000); }
        //catch (InterruptedException e) {}
    }


}
