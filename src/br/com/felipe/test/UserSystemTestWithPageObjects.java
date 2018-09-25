package br.com.felipe.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;


public class UserSystemTestWithPageObjects {

    private static WebDriver driver;
    private HomePage home;
    private UsersPage users;

    @Before
    public void initialize(){
        driver = new FirefoxDriver();
        home = new HomePage(driver);
        home.visitHome();
        users = home.UsersLink();
    }

    @After
    public void close(){
        driver.close();
    }

    @Test
    public void newUser(){

        users.newUserLink().register("Felipe Rodrigues", "felipe@test.com");
        assertTrue(users.existOnList("Felipe Rodrigues", "felipe@test.com"));

    }

    @Test
    public void newUserNotName(){

        users.newUserLink().register("", "felipe@felipe");
        assertTrue(users.validateRequiredNameMessage("Nome obrigatorio!"));
    }

    @Test
    public void newUserNotNameNotEmail(){

        users.newUserLink().register("", "");
        assertTrue(users.validateRequiredNameMessage("Nome obrigatorio!"));
        assertTrue(users.validateRequiredMailMessage("E-mail obrigatorio!"));

    }


}