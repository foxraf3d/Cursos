package TestSelenium;

import static org.junit.Assert.*;

import Suporte.Generator;
import Suporte.ScreenShot;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioTestData.csv")

public class informacoesUsuarioTest extends BaseTest{

    @Before
    public void SetUp(){
        AbrirNavegador("chrome");
    }

    @After
    public void FinalizaTest(){
        FecharNavegador();
    }

    @Rule
    public TestName test = new TestName();

    @Test
    public void testAcicionarUmaInformacaoAdicionalDoUsuario(@Param(name = "tipo")String tipo,@Param(name = "contato")String contato,@Param(name = "mensagem")String mensagemEsperada) {

        //GerarContatoParaTeste("+551125877896");

        //Abrir  aplicação no navegador
        driver.get("http://www.juliodelima.com.br/taskit");

        //Acessar a modal de login
        driver.findElement(By.linkText("Sign in")).click();

        //Preenchendo os campos de login
        WebElement formularioSignBox = driver.findElement(By.id("signinbox"));
        formularioSignBox.findElement(By.name("login")).sendKeys("julio0001");
        formularioSignBox.findElement(By.name("password")).sendKeys("123456");

        //Clicando em SIGN IN
        formularioSignBox.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"
        driver.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //Clicar no botão que possua o xpath "//div[@id='moredata']//button[.='+ Add more data']"
        driver.findElement(By.xpath("//div[@id='moredata']//button[.='+ Add more data']")).click();

        //Identificar a popup onde está o formulário de id "addmoredata"
        WebElement popupAddMoreData = driver.findElement(By.id("addmoredata"));

        //Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        //No campo de name "contact" digitar "++5511333339999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();


        //Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = driver.findElement(By.id("toast-container"));
        String actualText = mensagemPop.getText();
        assertEquals(mensagemEsperada, actualText);

    }

    @Test
    public void removerContatoDeUmUsuario(){

        GerarContatoParaTeste("+5511333339999");

        aguardarCarregamento(1000);

        //Clicar no botão excluir com o xpath  = //span[text()="+5511333339999"]/following-sibling::a
        driver.findElement(By.xpath("//span[text()='+5511333339999']/following-sibling::a")).click();

        //Clicar na mensagem javascript
        driver.switchTo().alert().accept();

        WebElement mensagemPop = driver.findElement(By.id("toast-container"));
        String actualText = mensagemPop.getText();

        ScreenShot.tirarScreenShot(driver, "C:\\Test_Report\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");

        //Espera explicita
        WebDriverWait aguardar = new WebDriverWait(driver, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        //Realizar o Logout
        driver.findElement(By.linkText("Logout")).click();

    }

    private void aguardarCarregamento(long tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Gerando usuário para Teste
    private void GerarContatoParaTeste(String telefone) {

        //Abrir  aplicação no navegador
        driver.get("http://www.juliodelima.com.br/taskit");

        //Acessar a modal de login
        driver.findElement(By.linkText("Sign in")).click();

        //Preenchendo os campos de login
        WebElement formularioSignBox = driver.findElement(By.id("signinbox"));
        formularioSignBox.findElement(By.name("login")).sendKeys("julio0001");
        formularioSignBox.findElement(By.name("password")).sendKeys("123456");

        //Clicando em SIGN IN
        formularioSignBox.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"
        driver.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //Clicar no botão que possua o xpath "//div[@id='moredata']//button[.='+ Add more data']"
        driver.findElement(By.xpath("//div[@id='moredata']//button[.='+ Add more data']")).click();

        //Identificar a popup onde está o formulário de id "addmoredata"
        WebElement popupAddMoreData = driver.findElement(By.id("addmoredata"));

        //Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        //No campo de name "contact" digitar "++5511333339999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(telefone);

        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

    }

}
