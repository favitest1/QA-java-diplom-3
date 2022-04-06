import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.BaseConfig;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ProfileTest {

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
     * Главная страница -> Войти в аккаунт -> Личный кабинет
     */
    @Test
    @DisplayName("Проверка перехода в Личный кабинет после авторизации")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessEntreProfilePageTest () {

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(user.get("email"));
        loginPage.setPassword(user.get("password"));
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccountUrl();

        ProfilePage profilePage = page(ProfilePage.class);

        MatcherAssert.assertThat(profilePage.isProfileUrl(), notNullValue());

    }

    /*
     * Главная страница -> Войти в аккаунт -> Личный кабинет -> Конструктор
     */
    @Test
    @DisplayName("Проверка перехода в раздел Конструктор из раздела Личный кабинет")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessToConstructorFromProfilePageTest () {

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(user.get("email"));
        loginPage.setPassword(user.get("password"));
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccountUrl();

        mainPage.clickСonstructorUrl();

        MatcherAssert.assertThat(mainPage.isCreateBurgerH(), notNullValue());

    }

    /*
     * Главная страница -> Войти в аккаунт -> Личный кабинет -> Stellar Burger
     */
    @Test
    @DisplayName("Проверка перехода к Конструктору через логотип из раздела Личный кабинет")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessToConstructorFromStellarBurgerTest () {

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(user.get("email"));
        loginPage.setPassword(user.get("password"));
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccountUrl();

        mainPage.clickStellarBurgerUrl();

        MatcherAssert.assertThat(mainPage.isCreateBurgerH(), notNullValue());

    }

    /*
     * Главная страница -> Войти в аккаунт -> Личный кабинет -> Выход
     */
    @Test
    @DisplayName("Проверка выхода из личного кабинета")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessExitFromPersonalPageTest () {

        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(user.get("email"));
        loginPage.setPassword(user.get("password"));
        loginPage.clickLoginButton();

        mainPage.clickPersonalAccountUrl();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();

        MatcherAssert.assertThat(loginPage.isEnterH(), notNullValue());

    }

}
