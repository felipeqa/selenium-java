package br.com.felipe.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class UserSystemTestWithPageObjects {

    private WebDriver driver;
    private HomePage home;
    private UsersPage users;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/apenas-teste/limpa");
        home = new HomePage(driver);
        home.visitHome();
        users = home.usersLink();
    }

    @After
    public void close(){

        if (testName.getMethodName().equals("addNewUser") || testName.getMethodName().equals("editUser")){
            users.removeUser();
        }
        driver.close();

    }

    @Test
    public void addNewUser(){

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

    @Test
    public void removeUser(){

        addNewUser();
        users.removeUser();
        assertFalse(users.existOnList("Felipe Rodrigues", "felipe@test.com"));
    }

    @Test
    public void editUser(){

        addNewUser();
        users.editUserLink().editUser("luis", "luis@luis");
        assertTrue(users.existOnList("luis", "luis@luis"));

    }

}