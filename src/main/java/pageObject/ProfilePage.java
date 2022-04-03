package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class ProfilePage {

    // Ссылка Профиль
    @FindBy(how = How.XPATH, using = ".//a[text()='Профиль']")
    private SelenideElement profileUrl;

    // Кнопка Выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    @Step("Клие по ссылке Выход")
    public void clickExitButton() {
        exitButton.shouldBe(enabled).click();
    }

    @Step("Наличие кнопки Вход")
    public boolean isEnterHExist() {
        return exitButton.shouldBe(enabled).exists();
    }

    @Step("Наличие ссылки Профиль")
    public boolean isProfileUrl() {
        return profileUrl.shouldBe(enabled).exists();
    }

}
