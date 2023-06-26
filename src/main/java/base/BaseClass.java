package base;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {


    public WebDriver driver; // if you do not mention it as public, it is accessible only in your package
    @BeforeClass
    public void setUpBrowser(){
        // when config file, crossBrowserTesting not possible
        System.out.println("LOG-INFO - Setting up browser");
        driver = BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("url"));

    }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
        System.out.println("LOG-INFO - Closing the browser");
    }



}
