package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFormPage clickSignIn() {
        //Acessar a modal de login
        driver.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(driver);
    }
}
