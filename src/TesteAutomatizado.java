import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://bing.com");

        WebElement campoDeTexto = driver.findElement(By.name("q"));

        campoDeTexto.sendKeys("Almundo");
        campoDeTexto.submit();
    }
}
