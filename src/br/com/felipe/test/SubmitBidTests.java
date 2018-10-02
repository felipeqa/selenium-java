package br.com.felipe.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class SubmitBidTests {
    private WebDriver driver;
    private HomePage home ;
    private DetailsAuctionsPage bidRegister;

    @Before
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get(new URLApplication().getUrlBase() + "/apenas-teste/limpa");
        home = new HomePage(driver);
        home.visitHome();
        home.usersLink().newUserLink().register("Felipe", "felipe@felipe");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        home.usersLink().newUserLink().register("Luis", "luis@luis");
        home.auctionsLink().newAuctionLink().registerAuction("Geladeira", 50
                ,"Felipe", false);
    }

    @After
     public void close(){
        driver.close();
    }

    @Test
    public void submitBid(){
        bidRegister = home.auctionsLink().viewAuctionLink();
        bidRegister.bidRegister("Luis", 200);
        assertTrue(bidRegister.bidValidate("Luis", 200));
    }

    @Test
    public void submitBidWithDetailsIndex(){
        bidRegister = home.auctionsLink().detailsAuction(1);
        bidRegister.bidRegister("Luis", 200);
        assertTrue(bidRegister.bidValidate("Luis", 200));
    }
}
