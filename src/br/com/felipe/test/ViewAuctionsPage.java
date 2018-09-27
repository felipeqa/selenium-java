package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  driver.getPageSource().contains(name) &&
                driver.getPageSource().contains(String.valueOf(String.valueOf(value)));
    }
}
