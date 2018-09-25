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

    public UsersPage UsersLink(){
        driver.findElement(By.linkText("Usuários")).click();
        return new UsersPage(driver);
    }
}
