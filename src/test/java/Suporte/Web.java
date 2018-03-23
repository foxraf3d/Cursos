package Suporte;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(String url){

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

    public static WebDriver createFirefox(String url){

        WebDriver driver;

        System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

}
