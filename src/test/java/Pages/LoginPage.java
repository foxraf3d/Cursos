package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginFormPage clickSignIn() {
        //Acessar a modal de login
        driver.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(driver);
    }
}
