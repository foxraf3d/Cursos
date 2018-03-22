package TestSelenium;

import Pages.LoginPage;
import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class informacoesUsuarioPageObjectsTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.createChrome("chrome", "http://www.juliodelima.com.br/taskit");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        new LoginPage(driver)
                .clickSignIn()
                .typeLogin("julio0001");
    }

}
