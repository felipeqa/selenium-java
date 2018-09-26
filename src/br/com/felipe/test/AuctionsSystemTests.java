package br.com.felipe.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AuctionsSystemTests {

     private WebDriver driver;
     private HomePage home;
     private AuctionsPage auctions;
     private NewAuctionsPage newAuction;


    @Before
    public void initialize(){

        driver = new FirefoxDriver();
        home = new HomePage(driver);
        home.visitHome();
        UsersPage user = home.usersLink();
        NewUserPage newUser = user.newUserLink();
        newUser.register("felipe", "felipe@felipe");
        home.visitHome();

    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void addNewAuction(){

        auctions = home.auctionsLink();
        newAuction =  auctions.newAuctionLink();
        newAuction.registerAuction("Geladeira", 200, "felipe", false);
        auctions.existOnListAuctions("Geladeira", 200, "felipe", false);
    }
}
