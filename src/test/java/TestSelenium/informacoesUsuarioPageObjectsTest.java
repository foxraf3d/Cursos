package TestSelenium;

import Pages.LoginPage;
import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioPageObjectsTest.csv")
public class informacoesUsuarioPageObjectsTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.createBrowserStack();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name = "login")String login,
            @Param(name = "senha")String senha,
            @Param(name = "tipo")String tipo,
            @Param(name = "contato")String contato,
            @Param(name = "mensagemEsperada")String mensagemEsperada
    ){
        String actual = new LoginPage(driver)
                            .clickSignIn()
                            .fazerLogin(login, senha)
                            .clicarMe()
                            .clicarNaAbaMoreDataAboutYou()
                            .clicarBotaoAddMoreDataAboutYou()
                            .adicionarContato(tipo, contato)
                            .capturarTextoToast();
        assertEquals(mensagemEsperada, actual);
    }

}
