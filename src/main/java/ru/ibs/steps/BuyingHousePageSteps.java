package ru.ibs.steps;

import io.cucumber.java.ru.И;
import ru.ibs.managers.PageManager;

public class BuyingHousePageSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем, что открылась страница 'ипотека на готовые квартиры'$")
    public void checkOpenBuyingHousePage(){
        pageManager.getBuyingHousePage().checkOpenBuyingHousePage();
    }

    @И("^Кликаем по кнопке 'Подать заявку'$")
    public void clickBtn(){
        pageManager.getBuyingHousePage().clickBtn();
    }

}
