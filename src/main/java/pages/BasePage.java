package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    /**
     * Element locators of the common web elements' locator
     **/
    private final By _searchInput = By.cssSelector("[name='q']");
    private final By _mainResult = By.xpath("//div[@class=\"liYKde g VjDLd\"]//h2[@data-attrid=\"title\"]/span");
    private final By _videosSection = By.xpath("//div[@class=\"ULSxyf\"]//div[@class=\"CwxNSe\"]/div");

    /**
     * This is place create common Web elements
     */

    protected WebElement searchInput() {
        return Constants.DRIVER.findElement(_searchInput);
    }

    protected WebElement mainResult() {
        return Constants.DRIVER.findElement(_mainResult);
    }

    protected List<WebElement> videosSection() {
        return Constants.DRIVER.findElements(_videosSection);
    }

    public void navigateToGoogle() {
        Constants.DRIVER.get(Constants.GOOGLE_URL);
    }

    public void openFistVideo() {
        videosSection().get(0).click();
    }

    public void inputSearchInput() {
        searchInput().sendKeys("the Beatles");
        searchInput().sendKeys(Keys.RETURN);
    }

    public String getMainResultText() {
        return mainResult().getText();
    }

    public String getSearchInputText() {
        return searchInput().getAttribute("value");
    }

    public List<String> listVideosText() {
        return videosSection().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isVideoText(String query) {
        return listVideosText().stream().anyMatch(str -> str.trim().contains(query));
    }

}
