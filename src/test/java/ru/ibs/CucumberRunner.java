package ru.ibs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"ru.ibs.utils.MyAllureListener"},
        glue = {"ru.ibs.steps"},
        features = {"src/test/resources/"},
        tags = {"@firstTest"},
        strict = false
)
public class CucumberRunner {
}
