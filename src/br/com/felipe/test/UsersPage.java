package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage {

    private WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }


    public NewUserPage newUserLink(){
        driver.findElement(By.linkText("Novo Usuário")).click();
        return new NewUserPage(driver);
    }

    public boolean existOnList(String name, String email){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  driver.getPageSource().contains(name) &&
                driver.getPageSource().contains(email);

    }

    public boolean validateRequiredNameMessage(String message) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getPageSource().contains(message);
    }

    public boolean validateRequiredMailMessage(String message) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getPageSource().contains(message);

    }
}