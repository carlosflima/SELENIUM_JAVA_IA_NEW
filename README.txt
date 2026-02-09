======================================================================
    FRAMEWORK DE AUTOMAÇÃO HÍBRIDA (WEB & API) - JAVA/SELENIUM
======================================================================

1. DESCRIÇÃO
   Framework profissional desenvolvido para automação de testes End-to-End. 
   Utiliza Java 17, Selenium para Web, RestAssured para API e Cucumber 
   para BDD. Totalmente integrado com CI/CD (GitHub Actions) e relatórios 
   gráficos (Allure).

2. FERRAMENTAS E VERSÕES
   - Java JDK: 17 (LTS)
   - Maven: 3.8+
   - Selenium: 4.16.1
   - RestAssured: 5.4.0
   - Cucumber: 7.15.0
   - Allure Report: 2.25.0
   - IDE Sugerida: Visual Studio Code

3. PRÉ-REQUISITOS E INSTALAÇÕES
   A. Instalar Java 17:
      https://adoptium.net/temurin/releases/?version=17
   B. Instalar Maven:
      https://maven.apache.org/download.cgi
   C. Extensões VS Code (Instalar via Marketplace):
      - Extension Pack for Java (Microsoft)
      - Cucumber (Gherkin) Full Support
      - Maven for Java

4. ESTRUTURA DE PASTAS
   /src/main/java/config      -> Gestão de Variáveis (Owner)
   /src/main/java/connections -> DB, Cloud e API Clients
   /src/main/java/pages       -> Page Objects (Locators e Ações)
   /src/test/java/runner      -> Executor de Suítes (JUnit 5)
   /src/test/java/steps       -> Implementação do Gherkin (Hooks)
   /src/test/resources        -> Features e Configurações (.properties)

5. COMANDOS PRINCIPAIS (TERMINAL)
   - Executar todos os testes:
     mvn test
   
   - Executar suíte específica por Tag:
     mvn test -Dcucumber.filter.tags="@regressivo"
   
   - Executar em ambiente específico e Headless (CI):
     mvn test -Denv=hml -Dheadless=true
   
   - Gerar e abrir relatório gráfico (Gráfico de Pizza):
     mvn allure:serve

6. EXEMPLO DE FEATURE (GHERKIN)
   @regressivo
   Funcionalidade: Login
     Cenário: Sucesso
       Dado que estou na página de login
       Quando eu insiro credenciais válidas
       Então sou redirecionado para a home

7. CI/CD E RELATÓRIOS
   - GitHub Actions: O arquivo .github/workflows/main.yml automatiza o teste.
   - Relatórios: Publicados automaticamente no GitHub Pages do repositório.
   - Allure Dashboard: Apresenta falhas, bugs e tempo de execução.

8. LINKS ÚTEIS
   - Documentação Selenium: https://www.selenium.dev/documentation/
   - RestAssured Guide: https://rest-assured.io/
   - Cucumber Java: