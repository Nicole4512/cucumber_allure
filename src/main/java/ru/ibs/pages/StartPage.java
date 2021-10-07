package ru.ibs.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.managers.InitManager;

import java.util.List;

/**
 * Стартовая страница
 */
public class StartPage extends BasePage {


    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    private WebElement cookiesBtnClose;

    @FindBy(xpath = "//li[contains(@class,'kitt-top-menu__item_first')]/a[@role or @aria-expanded]")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//a[@data-cga_click_top_menu]")
    private List<WebElement> listSubMenu;

    /**
     * Закрытия сообщения cookies
     *
     * @return HomePage - т.е. остаемся на этой странице
     */
    public StartPage closeCookiesDialog() {
        waitUtilElementToBeClickable(cookiesBtnClose).click();
        return this;
    }

    /**
     * Функция наведения мыши на любой пункт меню
     *
     * @param nameBaseMenu - наименование меню
     * @return HomePage - т.е. остаемся на этой странице
     */
    public StartPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : listBaseMenu) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameBaseMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return this;
            }
        }
        Assertions.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;
    }

    /**
     * Функция клика на любое подменю
     *
     * @param nameSubMenu - наименование подменю
     * @return InsurancePage - т.е. переходим на страницу {@link BuyingHousePage}
     */
    public BuyingHousePage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : listSubMenu) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return pageManager.getBuyingHousePage().checkOpenBuyingHousePage();
            }
        }
        Assertions.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return pageManager.getBuyingHousePage();
    }
}
