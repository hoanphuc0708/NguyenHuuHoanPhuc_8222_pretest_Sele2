package definition;

import cucumber.api.java8.En;
import org.testng.Assert;
import pages.BasePage;

public class MyStepdefs implements En {
    BasePage basePage = new BasePage();
    private String firstVideoTitle = "";

    public MyStepdefs() {
        Given("I navigate to the Google page", () -> {
            basePage.navigateToGoogle();
        });

        When("I search for {string}", (String query) -> {
            basePage.inputSearchInput();
        });

        Then("The main result should contains {string} text", (String query) -> {
            Assert.assertEquals(basePage.getMainResultText(), query,
                    "The main result should contains query text");
        });

        Then("The special sections {string} should contains {string} text", (String sections, String query) -> {
            Assert.assertTrue(basePage.isVideoText(query),
                    "The special sections " + sections + " should contains " + query + " text");
        });

        Then("The {string} remained on the search box", (String query) -> {
            Assert.assertEquals(basePage.getSearchInputText(), query.toLowerCase(),
                    "The search box should contains query text");
        });

        When("I open the first YouTube video result on Google search for {string}", (String query) -> {
            firstVideoTitle = basePage.listVideosText().get(0);
            basePage.openFistVideo();
        });

        When("I play the video", () -> {
            if (!basePage.isVideoPlay()) {
                basePage.clickPlayButton();
            }
        });

        When("I pause the video after {int} seconds", (Integer second) -> {
            Thread.sleep(11000);
            basePage.clickPlayButton();
        });

        Then("The video title is same to Google result", () -> {
            Assert.assertEquals(firstVideoTitle, basePage.getVideoTitle(),
                    "The video title should be same to Google result");
        });

        Then("The video is played or paused accordingly", () -> {
            Assert.assertFalse(basePage.isVideoPlay(),
                    "The video should be played or paused accordingly");
        });
    }
}
