package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visitHome(){
        driver.get("http://localhost:8080/");
    }

    public UsersPage usersLink(){
        driver.findElement(By.linkText("Usuários")).click();
        return new UsersPage(driver);
    }

    public AuctionsPage auctionsLink() {
         driver.findElement(By.linkText("Leilões")).click();
         return new AuctionsPage(driver);
    }
}
