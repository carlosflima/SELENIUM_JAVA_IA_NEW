package tests.java.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import connections.api.ApiClient;
import org.junit.Assert;

public class ApiSteps {

    private ApiClient api = new ApiClient();
    private Response response;

    @Quando("eu consulto o endpoint de usuários")
    public void consultarUsuarios() {
        response = api.get("/users");
    }

    @Entao("o status code deve ser {int}")
    public void validarStatusCode(int code) {
        // Tratamento de erro integrado com Assert do JUnit
        Assert.assertEquals("Erro na validação do status code!", code, response.getStatusCode());
    }

    /*"Com base na estrutura de Page Objects e ApiClient acima, gere um arquivo Gherkin (.feature) 
    para o fluxo de 'Esqueci minha senha' e os respectivos métodos Java utilizando RestAssured para 
    validar o envio do e-mail via API e Selenium para a interface Web. Utilize as tags @regressivo e @api."*/
}
