package DataProvider;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "data", parallel = true)
    public static Object[][] testData(){
        return new Object[][] {
                { DriverFactory.BrowserType.CHROME },
                { DriverFactory.BrowserType.FIREFOX} ,
                { DriverFactory.BrowserType.IE}};
    }
}
