package ru.ibs.utils;

import io.cucumber.plugin.event.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.managers.DriverManager;

public class MyAllureListener extends AllureCucumber5Jvm implements TestWatcher {
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "pgn")
    public byte[] getScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriverManager().getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, new EventHandler<TestStepFinished>() {
            @Override
            public void receive(TestStepFinished testStepFinished) {
                if(testStepFinished.getResult().getStatus().is(Status.FAILED)){
                    getScreenshot();
                }
            }
        });
        super.setEventPublisher(publisher);
    }
}
