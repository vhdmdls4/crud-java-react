MODEL-VIEW-CONTROLLER (MVC)

- Model: regras de negócio, entidades, camada de acesso a dados
- Controller: intermédio entre o fluxo da view e a model, o fluxo completo da aplicação, é quem recebe a solicitação
- View: interação com usuário, renderiza a página de resposta, requisição, etc, template engine, html, css, javascript

O Tomcat da aplicação roda na porta 8080 e acessa o front controller da aplicação

Spring tem um front controller que consegue enxergar todos as classses anotadas como @controller
e redirecionar o fluxo de acordo com o caminho (URL) da requisição
