import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.BaseConfig;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import pageObject.ForgotPasswordPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegisterPage;
import org.hamcrest.MatcherAssert;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.HashMap;
import java.util.Map;


public class LoginPageTest {

    private MainPage mainPage = new MainPage();
    private Map<String, String> user = new HashMap<>();
    private UserOperations userOperations = new UserOperations();

    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        user = userOperations.register();
    }

    @After
    public void deleteUser() {
        userOperations.delete();
        close();
    }

    /*
     * Методы
     */

    /*
     * Главная страница -> Войти в аккаунт
     */
    @Test
    @DisplayName("Проверка успешной авторизации через кнопку Войти в аккаунт")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessLoginUserWithButtonEnterAccountUserTest () {

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(user.get("email"));
        loginPage.setPassword(user.get("password"));
        loginPage.clickLoginButton();

        MatcherAssert.assertThat(mainPage.checkCreateOrderButton(), notNullValue());

    }

    /*
     * Главная страница -> Личный кабинет
     */
    @Test
    @DisplayName("Проверка успешной авторизации через кнопку Личный кабинет")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessLoginUserWithButtonPersonalAccountUserTest () {

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickPersonalAccountUrl();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(user.get("email"));
        loginPage.setPassword(user.get("password"));
        loginPage.clickLoginButton();

        MatcherAssert.assertThat(mainPage.checkCreateOrderButton(), notNullValue());

    }

    /*
    * Главная страница -> Войти в аккаунт -> Зарегистрироваться -> Войти
     */
    @Test
    @DisplayName("Проверка успешной авторизации через ссылку Войти страницы регистрации")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessLoginUserWithRegisterUserPageTest () {

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterUrl();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLoginUrl();

        loginPage = page(LoginPage.class);
        loginPage.setEmail(user.get("email"));
        loginPage.setPassword(user.get("password"));
        loginPage.clickLoginButton();

        MatcherAssert.assertThat(mainPage.checkCreateOrderButton(), notNullValue());

    }

    /*
    * Главная страница -> Войти в аккаунт -> Восстановить пароль -> Войти
     */
    @Test
    @DisplayName("Проверка успешной авторизации через ссылку Войти страницы восстановления пароля")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessLoginUserWithRefreshPasswordUserPageTest () {

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRefreshUrl();

        ForgotPasswordPage forgotPasswordPage = page (ForgotPasswordPage.class);
        forgotPasswordPage.clickLoginUrl();

        loginPage = page(LoginPage.class);
        loginPage.setEmail(user.get("email"));
        loginPage.setPassword(user.get("password"));
        loginPage.clickLoginButton();

        MatcherAssert.assertThat(mainPage.checkCreateOrderButton(), notNullValue());

    }

}
