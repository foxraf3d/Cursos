package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage{

    public MePage(WebDriver driver) {
        super(driver);
    }

    public MePage clicarNaAbaMoreDataAboutYou(){
        driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
    }

    public AddContactPage clicarBotaoAddMoreDataAboutYou(){
        driver.findElement(By.xpath("//div[@id='moredata']//button[.='+ Add more data']")).click();
        return new AddContactPage(driver);
    }
}
