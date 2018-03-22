package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {
    private WebDriver driver;

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFormPage typeLogin(String login) {
        driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }
}
