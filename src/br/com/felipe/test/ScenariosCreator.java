package br.com.felipe.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScenariosCreator {

    private final WebDriver driver;
    private HomePage home;

    ScenariosCreator(WebDriver driver){
        this.driver = driver;
        this.home = new  HomePage(driver);
    }

    public ScenariosCreator createUser(String name, String email) {
        home.visitHome();
        home.usersLink().newUserLink().register(name, email);
        return this;
    }

    public ScenariosCreator addAuction(String productName, double initialValue, String user, boolean used){
        home.auctionsLink().newAuctionLink().registerAuction("Geladeira", 50
                ,"Felipe", false);
        return this;
    }
}
