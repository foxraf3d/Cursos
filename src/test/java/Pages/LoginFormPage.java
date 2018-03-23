package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage  extends BasePage{

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }


    public LoginFormPage typeLogin(String login) {
        driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }

    public LoginFormPage typePassword(String password){
        driver.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public SecretaPage clicarNoSignIn() {
        driver.findElement(By.linkText("SIGN IN")).click();
        return new SecretaPage(driver);
    }

    public SecretaPage fazerLogin(String login, String senha){
        typeLogin(login);
        typePassword(senha);
        clicarNoSignIn();
        return new SecretaPage(driver);
    }
}
