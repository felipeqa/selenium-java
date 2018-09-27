package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewAuctionsPage {

    private final WebDriver driver;

    public ViewAuctionsPage(WebDriver driver){
       this.driver = driver;
   }

   public void bidRegister(String name, int value){
       Select userComboBox = new Select(driver.findElement(By.name("lance.usuario.id")));

       userComboBox.selectByVisibleText(name);
       driver.findElement(By.name("lance.valor")).sendKeys(String.valueOf(value));

       driver.findElement(By.id("btnDarLance")).click();
   }

    public boolean bidValidate(String name, double value){


        boolean containsUser = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(By.id("lancesDados"), name));

        if(containsUser) return driver.getPageSource().contains(String.valueOf(String.valueOf(value)));

        return false;

    }
}
