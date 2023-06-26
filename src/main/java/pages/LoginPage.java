package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    By user = By.id("email1");
    By pwd = By.id("password1");

    By login = By.xpath("//button[contains(text(),'Sign in')]");
    By signOut = By.xpath("//button[contains(text(),'Sign out')]");

    boolean isSignOutPresent;
    public Object loginToApp(String username, String password){
            driver.findElement(user).sendKeys(username);
            driver.findElement(pwd).sendKeys(password);
            driver.findElement(login).click();
        WebElement element1 = driver.findElement(signOut);
        isSignOutPresent = element1.isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        element1.click();

        return isSignOutPresent;
    }


}
