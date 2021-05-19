package test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/google_search_result.feature",
        glue = {""}
)
public class PreTestValidation extends CommonValidation {

}