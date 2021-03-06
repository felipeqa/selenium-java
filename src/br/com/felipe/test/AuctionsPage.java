package br.com.felipe.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AuctionsPage {

    private WebDriver driver;
    private WebDriverWait waitForElement;

    public AuctionsPage(WebDriver driver){
        this.driver = driver;
        this.waitForElement = new WebDriverWait(driver, 10);
    }

    public NewAuctionsPage newAuctionLink(){
        driver.findElement(By.linkText("Novo Leilão")).click();
        return new NewAuctionsPage(driver);
    }

    public DetailsAuctionsPage viewAuctionLink(){
        driver.findElement(By.linkText("exibir")).click();
        return new DetailsAuctionsPage(driver);
    }

    // select element by index 0
    public DetailsAuctionsPage detailsAuction(int index) {
        List<WebElement> elements = driver.findElements(By.linkText("exibir"));
        elements.get(index - 1).click();

        return new DetailsAuctionsPage(driver);
    }

    public boolean existOnListAuctions(String productName, double initialValue, String user, boolean used ){

        boolean containsAuction = waitForElement
                .until(ExpectedConditions.textToBePresentInElement(By.id("content"), productName));

        if(containsAuction){
            return  driver.getPageSource().contains(productName) &&
                    driver.getPageSource().contains(String.valueOf(initialValue)) &&
                    driver.getPageSource().contains(user) &&
                    driver.getPageSource().contains(used ? "Sim" : "Não");
        }

       return false;
    }
}
