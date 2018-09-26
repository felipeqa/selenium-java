package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAuctionsPage {

    private WebDriver driver;

    public NewAuctionsPage(WebDriver driver){
        this.driver = driver;
    }

    public void registerAuction(String productName, double initialValue, String user, boolean used ){

        WebElement productNameField = driver.findElement(By.name("leilao.nome"));
        WebElement initialValueField = driver.findElement(By.name("leilao.valorInicial"));
        Select userComboBox = new Select(driver.findElement(By.name("leilao.usuario.id")));

        productNameField.sendKeys(productName);
        initialValueField.sendKeys(String.valueOf(initialValue));
        userComboBox.selectByVisibleText(user);

        if (used) driver.findElement(By.name("leilao.usado")).click();

        productNameField.submit();
    }
}
