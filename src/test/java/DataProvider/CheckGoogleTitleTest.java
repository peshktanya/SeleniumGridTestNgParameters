package DataProvider;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class CheckGoogleTitleTest {
    WebDriver driver;
    DriverFactory settings;

    @Test(dataProvider = "data", dataProviderClass = StaticProvider.class)
    public void startRemoteDriver(DriverFactory.BrowserType browser) throws MalformedURLException {
        settings = new DriverFactory();
        driver = settings.setBrowser(browser);
        driver.navigate().to("https://google.com");
        //Assert.assertEquals(driver.getTitle(), "Google", "Wrong title");
        driver.quit();
    }





}
