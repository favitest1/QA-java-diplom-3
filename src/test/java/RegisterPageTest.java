import com.UserOperations;
import com.BaseConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import org.junit.Before;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import com.codeborne.selenide.Configuration;
import pageObject.RegisterPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.CoreMatchers.notNullValue;


public class RegisterPageTest {

    private MainPage mainPage = new MainPage();
    private Map<String, String> user = new HashMap<>();
    private UserOperations userOperations = new UserOperations();

    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @After
    public void closeBrowser() {
        close();
    }

    /*
     * Страница регистрации -> Заполнение полей -> Зарегистрироваться -> Заполнение полей -> Вход
     */
    @Test
    @DisplayName("Проверка регистрации и последующей авторизации")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessRegisterUserTest () {

        String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);

        user.put("email", email);
        user.put("password", password);
        user.put("name", name);

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterUrl();

        RegisterPage registerPage = page(RegisterPage.class);

        registerPage.setNameField(user.get("name"));
        registerPage.setEmailField(user.get("email"));
        registerPage.setPasswordField(user.get("password"));
        registerPage.clickRegisterButton();

        if (loginPage.isEnterHExist()) {
            loginPage.setEmail(user.get("email"));
            loginPage.setPassword(user.get("password"));
            loginPage.clickLoginButton();
        }

        MatcherAssert.assertThat(mainPage.checkCreateOrderButton(), notNullValue());

    }

    @Test
    @DisplayName("Проверка регистрации с коротким паролем")
    @Description("Проверка с произвольными параметрами")
    public void checkFalseRegisterUserTest () {

        String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(5);
        String name = RandomStringUtils.randomAlphabetic(10);

        user.put("email", email);
        user.put("password", password);
        user.put("name", name);

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterUrl();

        RegisterPage registerPage = page(RegisterPage.class);

        registerPage.setNameField(user.get("name"));
        registerPage.setEmailField(user.get("email"));
        registerPage.setPasswordField(user.get("password"));
        registerPage.clickRegisterButton();

        MatcherAssert.assertThat(registerPage.isErrorMessage(), equalTo(true));
    }

}
