package tests.java.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        // Inicializa o driver antes de cada teste
        DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        // Tira print se o teste falhar
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Evidencia_Falha");
        }
        
        // Fecha o navegador
        DriverManager.quitDriver();
    }
}
