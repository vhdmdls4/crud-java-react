# Repository
- Reponsável por fazer a comunicação com o banco de dados.
- Extende a interface JpaRepository que é responsável por fazer as operações básicas de um CRUD.
- A interface específica do repository extende a JpaRepository que recebe a entidade Foo e o tipo do id da entidade que geralmente é Long.
- A interface não possui métodos, pois a JpaRepository já possui todos os métodos necessários para fazer um CRUD, entretanto, em contextos específicos é possível criar métodos personalizados.
- A interface nesse caso é uma interface de marcação, ou seja, não possui implementação.

```java
@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {
}
```
