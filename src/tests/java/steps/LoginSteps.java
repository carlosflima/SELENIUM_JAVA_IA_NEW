package tests.java.steps;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import pages.LoginPage;
import utils.DriverManager; // Supondo uma classe que gerencia o Driver

public class LoginSteps {
    
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Dado("que estou na página de login")
    public void acessarLogin() {
        DriverManager.getDriver().get("https://sua-url.com/login");
    }

    @Quando("eu insiro credenciais válidas")
    public void loginValido() {
        loginPage.realizarLogin("admin", "admin123");
    }

    @Quando("eu insiro usuário {string} e senha {string}")
    public void loginInvalido(String user, String pass) {
        loginPage.realizarLogin(user, pass);
    }

    @Entao("visualizo a mensagem de erro {string}")
    public void validarErro(String mensagemEsperada) {
        Assert.assertEquals(mensagemEsperada, loginPage.obterMensagemErro());
    }

    @Entao("sou redirecionado para a home do sistema")
    public void validarHome() {
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("/home"));
    }
}
