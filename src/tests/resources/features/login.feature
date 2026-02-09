# language: pt
@regressivo @web
Funcionalidade: Login no Sistema
  Como um usuário cadastrado
  Quero realizar login na plataforma
  Para acessar minhas informações

  Contexto: 
    Dado que estou na página de login

  @smoke
  Cenário: Login com sucesso
    Quando eu insiro credenciais válidas
    Então sou redirecionado para a home do sistema

  Cenário: Login com senha inválida
    Quando eu insiro usuário "admin" e senha "errada123"
    Então visualizo a mensagem de erro "Invalid credentials"