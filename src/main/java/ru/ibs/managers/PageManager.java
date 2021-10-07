package ru.ibs.managers;

import ru.ibs.pages.BuyingHousePage;
import ru.ibs.pages.CalculatorPage;
import ru.ibs.pages.StartPage;

/**
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Страничка ипотечного калькулятора
     */
    private static CalculatorPage calculatorPage;

    /**
     * Стартовая страничка
     */
    private static StartPage startPage;

    /**
     * Страничка покупти вторичного жилья
     */
    private static BuyingHousePage buyingHousePage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Метод ленивой инициализации PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Метод ленивой инициализации {@link StartPage}
     *
     * @return StartPage
     */
    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    /**
     * Метод ленивой инициализации BuyingHousePage
     *
     * @return BuyingHousePage
     */
    public BuyingHousePage getBuyingHousePage() {
        if (buyingHousePage == null) {
            buyingHousePage = new BuyingHousePage();
        }
        return buyingHousePage;
    }

    /**
     * Метод ленивой инициализации CalculatorPage
     *
     * @return CalculatorPage
     */
    public CalculatorPage getCalculatorPage() {
        if (calculatorPage == null) {
            calculatorPage = new CalculatorPage();
        }
        return calculatorPage;
    }





}
