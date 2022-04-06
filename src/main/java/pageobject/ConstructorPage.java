package pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;

public class ConstructorPage {

    @FindBy(how = How.XPATH, using = "//*[@id='root']//*[@class = 'text text_type_main-default' and text()='Булки']")
    //@FindBy(how = How.XPATH, using = "//div[span[text()='Булки']]")
    //@FindBy(how = How.XPATH, using = "//span[text()='Булки']/parent::div[contains(@class, 'tab')]")
    private SelenideElement bunTab;

    @FindBy(how = How.XPATH, using = "//*[@id='root']//*[@class = 'text text_type_main-default' and text()='Соусы']")
    //@FindBy(how = How.XPATH, using = "//div[span[text()='Соусы']]")
    //@FindBy(how = How.XPATH, using = "//span[text()='Соусы']/parent::div[contains(@class, 'tab')]")
    private SelenideElement saucesTab;

    @FindBy(how = How.XPATH, using = "//*[@id='root']//*[@class = 'text text_type_main-default' and text()='Начинки']")
    //@FindBy(how = How.XPATH, using = "//div[span[text()='Начинки']]")
    //@FindBy(how = How.XPATH, using = "//span[text()='Начинки']/parent::div[contains(@class, 'tab')]")
    private SelenideElement fillingTab;

    /*
    * Методы
     */

    @Step("Переход на вкладку Булки")
    public void clickBunTab() {
        bunTab.click();
    }

    @Step("Переход на вкладку Соусы")
    public void clickSauceTab() {
        saucesTab.click();
    }

    @Step("Переход на вкладку Начинки")
    public void clickFillingTab() {
        fillingTab.click();
    }

    @Step("Получение названия актуальной вкладки")
    public String textActualTab(String nameTab) {
        String xpath = "//*[@id='root']//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect' and .//span[text()='" + nameTab + "']]";

        SelenideElement actualTab = Selenide.$(By.xpath(xpath));

        return actualTab.shouldBe(exactText(nameTab)).getText();
    }

}
