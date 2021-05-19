package test;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


public class CommonValidation extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(String browser) {
            DriverHelper.openChromeBrowser();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverHelper.quitBrowser();
    }
}