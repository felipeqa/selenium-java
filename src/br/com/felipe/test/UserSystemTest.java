package br.com.felipe.test;

import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserSystemTest {

    @Test
    public void newUser(){

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/usuarios/new");

        WebElement name = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));
        WebElement saveButton = driver.findElement(By.id("btnSalvar"));

        name.sendKeys("Felipe Rodrigues");
        email.sendKeys("felipe@felipe.com");
        saveButton.click();

        //send form with submit
        //example

//        name.submit();

        //or

//        email.submit();

        boolean nameExist = driver.getPageSource().contains("Felipe Rodrigues");
        boolean emailExist = driver.getPageSource().contains("felipe@felipe.com");

        assertTrue(nameExist);
        assertTrue(emailExist);

        driver.close();

    }

    @Test
    public void newUserNotName(){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/usuarios/new");

        WebElement email = driver.findElement(By.name("usuario.email"));

        email.sendKeys("teste@teste.com");
        email.submit();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));

        driver.close();
    }

    @Test
    public void newUserNotNameANdEmail(){

        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/usuarios/new");

        WebElement email = driver.findElement(By.name("usuario.email"));

        email.submit();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));

        driver.close();
    }


}