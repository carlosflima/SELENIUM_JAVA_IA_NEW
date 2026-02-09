package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Seletores (Encapsulados)
    private By inputUser = By.name("username");
    private By inputPass = By.name("password");
    private By btnLogin  = By.cssSelector("button[type='submit']");
    private By msgErro   = By.className("alert-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void realizarLogin(String usuario, String senha) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUser)).sendKeys(usuario);
        driver.findElement(inputPass).sendKeys(senha);
        driver.findElement(btnLogin).click();
    }

    public String obterMensagemErro() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(msgErro)).getText();
    }
}