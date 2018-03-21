package TestSelenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    //Método para abrir o navegador ()
    public void AbrirNavegador(String navegador){

        if (navegador == "chrome"){
            System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        else if (navegador == "firefox") {
            System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

    }

    //Método para fechar o navegador
    public void FecharNavegador(){
        driver.quit();
    }

}
