package Params;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.net.MalformedURLException;


public class TestNgParamTest {
    WebDriver driver;

    SetDriver settings;

    @Parameters({"grid", "browser"})
    @BeforeMethod
    public void beforeTest(String grid, String browser) throws MalformedURLException {
        if (grid.contains("true")){
            settings = new SetDriver();
            driver = settings.setBrowser(browser);
        }
        else
            driver = new FirefoxDriver();

    }

    @Test
    public void startTest() {
        driver.navigate().to("https://google.com");
        Assert.assertEquals(driver.getTitle(), "Google", "Wrong title");
        driver.quit();
    }





}
