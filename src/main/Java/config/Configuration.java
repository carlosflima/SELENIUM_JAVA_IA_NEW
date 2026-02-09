package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:environments/${env}.properties", // Busca o arquivo baseado na variável de ambiente
    "classpath:environments/hml.properties"      // Default caso não informe nada
})
public interface Configuration extends Config {

    @Key("url.web")
    String urlWeb();

    @Key("url.api")
    String urlApi();

    @Key("db.url")
    String dbUrl();

    @Key("db.user")
    String dbUser();

    @Key("db.pass")
    String dbPass();

    @Key("timeout")
    @DefaultValue("10")
    int timeout();
}

/*Configuration config = ConfigFactory.create(Configuration.class);
driver.get(config.urlWeb()); // Vai abrir a URL de HML ou DEV automaticamente*/