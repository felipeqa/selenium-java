package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUserPage {

    private WebDriver driver;

    public NewUserPage(WebDriver driver){
        this.driver = driver;
    }

    public void register(String name, String email){

        WebElement textName = driver.findElement(By.name("usuario.nome"));
        WebElement textEmail = driver.findElement(By.name("usuario.email"));

        textName.sendKeys(name);
        textEmail.sendKeys(email);

        textEmail.submit();

    }


    public void editUser(String name, String email){

        WebElement textName = driver.findElement(By.name("usuario.nome"));
        WebElement textEmail = driver.findElement(By.name("usuario.email"));

        textName.clear();
        textEmail.clear();

        textName.sendKeys(name);
        textEmail.sendKeys(email);

        textEmail.submit();

    }
}
