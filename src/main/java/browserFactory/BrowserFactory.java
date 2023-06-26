package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver getBrowserInstance(){// this will just return WebDriver driver
        return driver;
    }

    public static WebDriver startBrowser(String browserName, String applicationURL) {

        //WebDriver driver = null;

        if (browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.contains("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.contains("Safari")) {
            driver = new SafariDriver();
        } else if (browserName.contains("Edge")) {
            driver = new EdgeDriver();
        } else {
            //Reporter.log("Sorry " + browserName + " not supported Running test in default browser");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

        driver.get(applicationURL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }


}
