package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AuctionsPage {

    private WebDriver driver;

    public AuctionsPage(WebDriver driver){
        this.driver = driver;
    }

    public NewAuctionsPage newAuctionLink(){
        driver.findElement(By.linkText("Novo Leilão")).click();
        return new NewAuctionsPage(driver);
    }

    public boolean existOnListAuctions(String productName, double initialValue, String user, boolean used ){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  driver.getPageSource().contains(productName) &&
                driver.getPageSource().contains(String.valueOf(initialValue)) &&
                driver.getPageSource().contains(user) &&
                driver.getPageSource().contains(used ? "Sim" : "Não");

    }
}
