# Projeto CRUD Java React

Este é um projeto de aplicação web que utiliza Java e Spring Boot no back-end e React no front-end. A aplicação é um sistema CRUD (Create, Read, Update, Delete) para gerenciamento de usuários.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- React

## Funcionalidades

- Criação de usuários
- Leitura de informações dos usuários
- Atualização de informações dos usuários
- Exclusão de usuários
- Paginação na listagem de usuários

## Application Properties ___(example)___

```properties
spring.application.name=crud-java-react
spring.datasource.url=jdbc:mysql://localhost:3306/crud_java_react?useSSL=false&serverTimezone=UTC
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Como Rodar o Projeto

1. Clone o repositório para a sua máquina local.
2. Navegue até a pasta do projeto.
3. Execute o comando `mvn clean install` para construir o projeto.
4. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.
5. Acesse `http://localhost:8080` no seu navegador para visualizar a aplicação.

## Contribuição

Este é um projeto aberto e aceitamos contribuições. Por favor, faça um fork do projeto e crie um Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT.

## Contato

Se você tiver alguma dúvida ou sugestão, por favor, entre em contato.

**Nota:** Este é um README provisório e pode ser atualizado para fornecer mais detalhes sobre o projeto.
