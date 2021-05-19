package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.DriverUtils;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    /**
     * Element locators of the common web elements' locator
     **/
    private final By _searchInput = By.cssSelector("[name='q']");
    private final By _mainResult = By.xpath("//div[@class=\"liYKde g VjDLd\"]//h2[@data-attrid=\"title\"]/span");
    private final By _videos = By.xpath("//div[@class=\"ULSxyf\"]//div[@class=\"CwxNSe\"]/div");

    /**
     * This is place create common Web elements
     */

    protected WebElement searchInput() {
        return DriverUtils.getDriver().findElement(_searchInput);
    }

    protected WebElement mainResult() {
        return DriverUtils.getDriver().findElement(_mainResult);
    }

    protected List<WebElement> videos() {
        return DriverUtils.getDriver().findElements(_videos);
    }

    public void navigateToGoogle() {
        DriverUtils.navigate(Constants.GOOGLE_URL);
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
        List<String> stringList = new ArrayList<>();
        for (WebElement element : videos()) {
            stringList.add(element.getText());
        }
        return stringList;
    }

    public boolean isVideoText(String query) {
        List<String> listVideosText = listVideosText();
        return listVideosText.stream().anyMatch(str -> str.trim().contains(query));
    }

}
