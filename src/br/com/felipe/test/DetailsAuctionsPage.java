package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsAuctionsPage {

    private final WebDriver driver;
    private WebDriverWait waitForElement;

    public DetailsAuctionsPage(WebDriver driver){
       this.driver = driver;
       this.waitForElement = new WebDriverWait(driver, 10);
   }

   public void bidRegister(String name, int value){
       Select userComboBox = new Select(driver.findElement(By.name("lance.usuario.id")));

       userComboBox.selectByVisibleText(name);
       driver.findElement(By.name("lance.valor")).sendKeys(String.valueOf(value));

       driver.findElement(By.id("btnDarLance")).click();
   }

    public boolean bidValidate(String name, double value){


        boolean containsUser = waitForElement
                .until(ExpectedConditions.textToBePresentInElement(By.id("lancesDados"), name));

        if(containsUser) return driver.getPageSource().contains(String.valueOf(String.valueOf(value)));

        return false;

    }
}
