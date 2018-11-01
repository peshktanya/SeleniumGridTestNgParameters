package DataProvider;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    DesiredCapabilities capabilities;

    public enum BrowserType{
        FIREFOX("firefox"),
        CHROME("chrome"),
        IE("internet explorer"),
        SAFARI("safari"),
        OPERA("opera");

        private String value;
        BrowserType(String value){
            this.value = value;
        }
        public String getBrowserName(){
            return this.value;
        }
    }

    public WebDriver setBrowser(BrowserType type) throws MalformedURLException {
        switch(type){
            case FIREFOX:
                capabilities = new DesiredCapabilities(new FirefoxOptions());
                break;
            case IE:
                capabilities = new DesiredCapabilities(new InternetExplorerOptions());
                break;
            case CHROME:
                capabilities = new DesiredCapabilities(new ChromeOptions());
                break;
            default:
                capabilities=new DesiredCapabilities(new FirefoxOptions());
                break;
        }
        capabilities.setBrowserName(type.getBrowserName());
        capabilities.setPlatform(Platform.WINDOWS);
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

}
