package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class CalculatorPage extends BasePage {
    //div[@data-e2e-id = 'mland-calculator/result-block']  блок с расчетом ипотеки
    //div[@data-e2e-id = 'mland-calculator/result-block']//div[@class = 'styles_wrap__-BY3m']//span[@class = 'style_label__270Um']

    @FindBy(xpath = "//div[@data-e2e-id = 'mland-calculator/result-block']//div[@class = 'styles_wrap__-BY3m']//span[@class = 'style_label__270Um']")
    private List<WebElement> valueNameList;

    @FindBy(xpath = "//div[@class = 'dc-input__label-5-3-5']")
    private List<WebElement> fieldList;

    @FindBy(xpath = "//div[@class = 'styles_main__2I9K4']")
    private List<WebElement> checkboxBlockList;

    @FindBy(xpath = "//h1[@class = '_2GkaGoQxM2HHvF1x6HmTCf']")
    private WebElement title;


    /**
     * Метод для заполнения полей
     *
     * @param fieldName - название поля
     * @param value     - значение поля
     * @return CalculatorPage - т.е. остаемся на этой странице
     * @see BasePage#fillInputField
     */
    public CalculatorPage fill(String fieldName, String value) {
        for (WebElement fieldText : fieldList) {
            if (fieldName.equalsIgnoreCase(fieldText.getText())) {
                WebElement field = fieldText.findElement(By.xpath("./..//input"));
                fillInputField(field, value);
                boolean checkFlag = wait.until(ExpectedConditions.attributeContains(field, "value", value));
                Assertions.assertTrue(checkFlag, "Поле было заполнено некорректно");
            }
        }
        return this;
    }

    /**
     * Метод для изменения состояния checkbox
     *
     * @param checkboxBlockName - название нужного checkbox
     * @param value - значение в которое нужно поставить checkbox (true/false)
     * @return CalculatorPage - т.е. остаемся на этой странице
     */
    public CalculatorPage checkbox(String checkboxBlockName, String value) {
        for (WebElement checkboxBlock : checkboxBlockList) {
            WebElement checkboxText = checkboxBlock.findElement(By.xpath(".//span[@class = 'styles_title__1ZfZY']"));
            if (checkboxBlockName.equalsIgnoreCase(checkboxText.getText())) {
                WebElement checkbox = checkboxBlock.findElement(By.xpath(".//input[@type = 'checkbox']"));
                if(! value.equals(checkbox.getAttribute("checked"))){
                    scrollToElementJs(checkbox);
                    checkbox.click();
                }
            }
        }
        return this;
    }

    /**
     * Метод для проверки значения ипотечного калькулятора
     *
     * @param valueName - название поля для проверки
     * @param value - ожидаемое значение
     * @return CalculatorPage - т.е. остаемся на этой странице
     */
    public CalculatorPage checkValue(String valueName, String value){
        for (WebElement valueText : valueNameList) {
            if (valueName.equalsIgnoreCase(valueText.getText())) {
                WebElement trueValue = valueText.findElement(By.xpath("./..//span[contains(@class, 'styles_value')]//span"));
                Assertions.assertEquals(value, trueValue.getText(), "Значение не соответствует заданному");
            }
        }
        return this;
    }

    /**
     * Метод проверки открытия страницы, путем проверки заголовка
     *
     * @return CalculatorPage - т.е. остаемся на этой странице
     */
    public CalculatorPage checkOpenCalculatorPage(){
        Assertions.assertEquals("Ипотечный калькулятор", title.getText(), "Заголовок отсутствует или не соответствует требуемому" );
        return this;
    }


}
