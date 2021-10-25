package co.com.sofka.runner.practiceform;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/practiceform/practiceForm.feature"},
        glue = {"co.com.sofka.stepdefinition.practiceform"},
        tags = {"not @ignore"}
)
public class PracticeFormRunner {
}
