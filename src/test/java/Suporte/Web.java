package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(String navegador, String url){

        WebDriver driver = new ChromeDriver();

        if (navegador == "chrome"){
            System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        else if (navegador == "firefox") {
            System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        driver.get(url);

        return driver;
    }


}
