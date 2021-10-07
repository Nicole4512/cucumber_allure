package ru.ibs.steps;

import io.cucumber.java.ru.И;
import ru.ibs.managers.PageManager;

public class StartPageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Кликаем на меню '(.+)'$")
    public void selectBaseMenu(String nameBaseMenu) {
        pageManager.getStartPage().selectBaseMenu(nameBaseMenu);
    }

    @И("^Кликаем на подменю '(.+)'$")
    public void selectSubMenu(String nameSubMenu){
        pageManager.getStartPage().selectSubMenu(nameSubMenu);
    }

    @И("^Закрываем окно cookies$")
    public void closeCookiesDialog(){
        pageManager.getStartPage().closeCookiesDialog();
    }

}
