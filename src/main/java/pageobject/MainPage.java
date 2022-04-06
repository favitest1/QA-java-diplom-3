package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    // Кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginInAccountButton;

    // Кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    // Ссылка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//a[starts-with(@class, 'AppHeader_header')]/p[text()='Личный Кабинет']")
    private SelenideElement personalAccountUrl;

    // Сылка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorUrl;

    // Текст Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement createBurgerH;

    // Ссылка Stellar Burger
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgerUrl;

    /*
     * Методы
     */

    @Step("Клик по кнопке Войти в аккаунт")
    public void clickLoginInAccountButton() {
        loginInAccountButton.click();
    }

    @Step("Клик по кнопке Оформить заказ")
     public boolean checkCreateOrderButton() {
        return createOrderButton.isEnabled();
    }

    @Step("Клик по ссылке Личный кабинет")
    public void clickPersonalAccountUrl() {
        personalAccountUrl.click();
    }

    @Step("Клик по ссылке Констурктор")
    public void clickСonstructorUrl() {
        constructorUrl.click();
    }

    @Step("Наличие текста Соберите бургер")
    public boolean isCreateBurgerH() {
        return createBurgerH.exists();
    }

    @Step("Клик логотипу")
    public void clickStellarBurgerUrl() {
        stellarBurgerUrl.click();
    }



}
