package definition;

import cucumber.api.java8.En;
import pages.BasePage;

public class MyStepdefs implements En {
    BasePage basePage = new BasePage();

    public MyStepdefs() {
        Given("^I navigate to the Google page$", () -> {
            basePage.navigateToGoogle();
        });

        When("^I search for the Beatles$", () -> {
            basePage.enter_SearchInput();
        });

        Then("^The sections below should contains the Beatles text$", () -> {
        });
    }
}
