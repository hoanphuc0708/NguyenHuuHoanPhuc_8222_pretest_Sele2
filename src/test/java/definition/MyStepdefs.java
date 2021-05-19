package definition;

import cucumber.api.java8.En;
import org.testng.Assert;
import pages.BasePage;

public class MyStepdefs implements En {
    BasePage basePage = new BasePage();

    public MyStepdefs() {
        Given("^I navigate to the Google page$", () -> {
            basePage.navigateToGoogle();
        });

        When("^I search for \"([^\"]*)\"$", (String query) -> {
            basePage.inputSearchInput();
        });

        Then("The main result should contains {string} text", (String query) -> {
            Assert.assertEquals(basePage.getMainResultText(), query, "The main result does not contains query text");
        });

        Then("The special sections {string} should contains {string} text", (String sections, String query) -> {
           Assert.assertTrue(basePage.isVideoText(query));
        });

        And("The {string} remained on the search box", (String query) -> {
            Assert.assertEquals(basePage.getSearchInputText().toLowerCase(), query.toLowerCase(), "The search box does not contains query text");
        });
    }
}
