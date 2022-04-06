import com.Base;
import com.UserOperations;
import com.BaseConfig;
import com.model.Tokens;
import com.model.UserRegisterResponse;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import org.junit.Before;

import static com.BaseConfig.START_MAXIMIZED;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import com.codeborne.selenide.Configuration;
import pageobject.RegisterPage;
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
    @Step("Установка настроек браузера")
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = START_MAXIMIZED;

        // Обнуляем токены
        Tokens.setAccessToken(null);
        Tokens.setRefreshToken(null);
    }

    @After
    @Step("Удаление пользователя, закрытие браузера")
    public void deleteUser() {
        userOperations.delete();
        close();
    }

    /*
     * Страница регистрации -> Заполнение полей -> Зарегистрироваться -> Заполнение полей -> Вход
     */
    @Test
    @DisplayName("Проверка успешной регистрации и последующей авторизации")
    @Description("Проверка с произвольными параметрами")
    public void checkSuccessRegisterUserTest () {

        String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);

        user = new HashMap<>();
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

        getUserAccessToken();

    }

    @Test
    @DisplayName("Проверка ошибки регистрации с коротким паролем")
    @Description("Проверка с произвольными параметрами")
    public void checkFalseRegisterUserTest () {
        MainPage mainPage = open(BaseConfig.BASE_URL, MainPage.class);
        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterUrl();

        RegisterPage registerPage = page(RegisterPage.class);

        registerPage.setNameField(RandomStringUtils.randomAlphabetic(10));
        registerPage.setEmailField(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        registerPage.setPasswordField(RandomStringUtils.randomAlphabetic(5));
        registerPage.clickRegisterButton();

        MatcherAssert.assertThat(registerPage.isErrorMessage(), equalTo(true));
    }

    @Step("Получение AccessToken для удаления пользователя")
    private void getUserAccessToken() {

        UserRegisterResponse response = given()
                .spec(Base.getBaseSpec())
                .and()
                .body(user)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .body()
                .as(UserRegisterResponse.class);

        Tokens.setAccessToken(response.getAccessToken().substring(7));
        Tokens.setRefreshToken(response.getRefreshToken());

    }

}
