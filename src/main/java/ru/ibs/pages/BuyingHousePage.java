package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyingHousePage extends BasePage {

    /**
     * Элемент для хранения заголовка
     */
    @FindBy(xpath = "//div[contains(@class, ' kit-col_lg_6 kit-col_xs-bottom_20 ')]//h1[contains(@class, 'product-teaser-full-width__header')]")
    private WebElement title;

    /**
     * Элемент для хранения кнопки "Подать заявку"
     */
    @FindBy(xpath = "//a[contains(@href, 'calculator') and @class = 'kit-button  kit-button_default kit-button_type_big analytics-button']")
    private WebElement button;

    /**
     * Метод проверки открытия страницы, путем проверки заголовка
     *
     * @return BuyingHousePage - т.е. остаемся на этой странице
     */
    public BuyingHousePage checkOpenBuyingHousePage (){
        Assertions.assertEquals("Ипотека от 8,1%* на готовые квартиры", title.getText(), "Заголовок отсутствует или не соответствует требуемому" );
        return this;
    }

    /**
     * Метод клика по кнопке "Подать заявку"
     *
     * @return CalculatorPage - т.е. переходим на страничку ипотечного калькулятора {@link CalculatorPage}
     */
    public CalculatorPage clickBtn(){
        waitUtilElementToBeClickable(button).click();
        return pageManager.getCalculatorPage();
    }

}
