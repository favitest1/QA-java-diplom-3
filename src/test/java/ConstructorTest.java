
import com.codeborne.selenide.Configuration;
import com.BaseConfig;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.ConstructorPage;
import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ConstructorTest {

    ConstructorPage page;

    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        page = open(BaseConfig.BASE_URL, ConstructorPage.class);
    }

    @After
    public void closeBrowser() {
        close();
    }

    @Test
    @DisplayName("Проверка вкладки Булки")
    @Description("Переход на вкладку Булки через вкладку Начинки")
    public void clickToTabBunTest() {

        page.clickFillingTab();

        page.clickBunTab();
        assertThat("Error go to tab bun", page.textActualTab("Булки"), equalToIgnoringCase("Булки"));

    }

    @Test
    @DisplayName("Проверка вкладки Соусы")
    @Description("Переход на вкладку Соусы")
    public void clickToTabSauceTest() {

        page.clickSauceTab();

        assertThat("Error go to tab sause", page.textActualTab("Соусы"), equalToIgnoringCase("Соусы"));
    }

    @Test
    @DisplayName("Проверка вкладки Начинки")
    @Description("Переход на вкладку Начинки")
    public void clickToTabFillingTest() {

        page.clickFillingTab();

        assertThat("Error go to tab filling", page.textActualTab("Начинки"), equalToIgnoringCase("Начинки"));

    }

}
