package br.com.felipe.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;


public class UserSystemTest {

    private WebDriver driver;

    @Before
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/usuarios/new");
    }

    @After
    public void close(){
        driver.close();
    }

    @Test
    public void newUser(){

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

    }

    @Test
    public void newUserNotName(){

        WebElement email = driver.findElement(By.name("usuario.email"));

        email.sendKeys("teste@teste.com");
        email.submit();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));

    }

    @Test
    public void newUserNotNameANdEmail(){

        WebElement email = driver.findElement(By.name("usuario.email"));

        email.submit();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
        assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));

    }


}