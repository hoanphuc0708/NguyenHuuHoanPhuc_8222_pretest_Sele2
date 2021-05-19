package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.DriverUtils;

public class BasePage {
    /**
     * Element locators of the common web elements' locator
     **/
    private final By _searchInput = By.cssSelector("[name='q']");
    private final By _mainResult = By.xpath("//div[@class=\"liYKde g VjDLd\"]");
    private final By _peopleAlsoAsk= By.xpath("//div[@class=\"xpdopen\"]");
    private final By _peopleAlsoAsk= By.xpath("//div[@class=\"xpdopen\"]");


    /**
     * This is place create common Web elements
     */

    protected WebElement searchInput() {
        return DriverUtils.getDriver().findElement(_searchInput);
    }

    public void navigateToGoogle() {
        DriverUtils.navigate(Constants.GOOGLE_URL);
    }

    public void enter_SearchInput() {
        searchInput().sendKeys("the Beatles");
        searchInput().sendKeys(Keys.RETURN);
    }
}
