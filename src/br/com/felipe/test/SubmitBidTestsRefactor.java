package br.com.felipe.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class SubmitBidTestsRefactor {
    private WebDriver driver;
    private HomePage home ;
    private DetailsAuctionsPage bidRegister;

    @Before
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/apenas-teste/limpa");
        home = new HomePage(driver);

        ScenariosCreator scenariosCreator = new ScenariosCreator(driver);
        scenariosCreator.createUser("Felipe", "felipe@felipe");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scenariosCreator.createUser("Luis", "luis@luis");
        scenariosCreator.addAuction("Geladeira", 50,"Felipe", false);
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
