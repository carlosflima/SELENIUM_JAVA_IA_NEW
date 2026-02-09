package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverThread.get() == null) {
            // Pega o navegador definido no Maven ou usa Chrome por padrão
            String browser = System.getProperty("browser", "chrome").toLowerCase();

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    // Se estiver no CI (GitHub Actions), roda em modo Headless (sem interface)
                    if ("true".equals(System.getProperty("headless"))) {
                        options.addArguments("--headless=new");
                    }
                    driverThread.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverThread.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverThread.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Navegador não suportado: " + browser);
            }
            
            driverThread.get().manage().window().maximize();
        }
        return driverThread.get();
    }

    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }
}