package Suporte;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {


    public static final String USERNAME = "rafaelsimpliciod1";
    public static final String AUTOMATE_KEY = "yEiSwGtQFihZqQ7yGFDV";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


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

    public static WebDriver createBrowserStack(){

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");

        WebDriver driver = null;

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("http://www.juliodelima.com.br/taskit");

        } catch (MalformedURLException e) {
            System.out.println("Houveram promemas com a URL: " + e.getMessage());
        }



        return driver;
    }

}
