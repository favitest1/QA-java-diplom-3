package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;

public class ConstructorPage {

    //@FindBy(how = How.XPATH, using = "//*[@id='root']//*[@class = 'text text_type_main-default' and text()='Булки']")
    @FindBy(how = How.XPATH, using = ".//div[span[text()='Булки']]")
    private static SelenideElement bunTab;

    //@FindBy(how = How.XPATH, using = "//*[@id='root']//*[@class = 'text text_type_main-default' and text()='Соусы']")
    @FindBy(how = How.XPATH, using = ".//div[span[text()='Соусы']]")
    private static SelenideElement saucesTab;

    //@FindBy(how = How.XPATH, using = "//*[@id='root']//*[@class = 'text text_type_main-default' and text()='Начинки']")
    @FindBy(how = How.XPATH, using = ".//div[span[text()='Начинки']]")
    private static SelenideElement fillingTab;

    /*
    * Методы
     */

    @Step("Переход на вкладку Булки")
    public static void clickBunTab() {
        bunTab.shouldBe(Condition.visible).click();
    }

    @Step("Переход на вкладку Соусы")
    public static void clickSauceTab() {
        saucesTab.shouldBe(Condition.visible).click();
    }

    @Step("Переход на вкладку Начинки")
    public static void clickFillingTab() {
        fillingTab.shouldBe(Condition.visible).click();
    }

    @Step("Получение названия актуальной вкладки")
    public String textActualTab(String nameTab) {
        String xpath = "//*[@id='root']//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect' and .//span[text()='" + nameTab + "']]";

        SelenideElement actualTab = Selenide.$(By.xpath(xpath));

        return actualTab.shouldBe(exactText(nameTab)).getText();
    }

}
