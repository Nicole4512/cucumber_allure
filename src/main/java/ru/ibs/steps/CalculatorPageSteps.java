package ru.ibs.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import ru.ibs.managers.PageManager;

import java.util.List;

import static java.lang.Thread.sleep;

public class CalculatorPageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Заполняем поля формы:$")
    public void fill(DataTable dataTable){
        for (List<String> data: dataTable.asLists()) {
            pageManager.getCalculatorPage().fill(data.get(0), data.get(1));
        }
    }

    @И("^Изменяем состояние checkbox:$")
    public void checkbox(DataTable dataTable){
        for (List<String> data: dataTable.asLists()) {
            pageManager.getCalculatorPage().checkbox(data.get(0), data.get(1));
        }

    }

    @И("^Проверяем, что открылась страница ипотечного калькулятора$")
    public void checkOpenCalculatorPage(){
        pageManager.getCalculatorPage().checkOpenCalculatorPage();
    }

    @И("^Проверяем значение поля:$")
    public void checkValue(DataTable dataTable){
        for (List<String> data: dataTable.asLists()) {
            pageManager.getCalculatorPage().checkValue(data.get(0), data.get(1));
        }

    }

    @И("Ждем изменения")
    public void sleepS(){
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
