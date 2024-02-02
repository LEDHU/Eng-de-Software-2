[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/_zceFCQy)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11806572&assignment_repo_type=AssignmentRepo)
# Lista de Exercícios
<img src="assets/images/Unicap_Icam_Tech-01.png" alt="drawing" width="200"/>

## Identificação
**Professor**: Diego Pinheiro, PhD

**Disciplina**: Engenharia de Software 2

**Atividade**: Síncrona 1 - Padrões de Projeto

## Instruções 
> 1. Sua implementação deve estar dentro da pasta src/**main**/java 
> 2. Não modifique nenhum código dentro da pasta src/**test**/java).
> 3. A submissão **não deve ser feita após o prazo** (nem 1 minuto a mais)

## Descrição da Atividade
### Questão 
O softwares utilizados mundialmente necessitam fornecer as funcionalidades em diferentes línguas. Utilize o padrão `Strategy` para implementar a interface `ControllerFactory` 

```java
public interface ControllerFactory {

    HomeView getHome();

    MenuView getMenu();
    
}
```

que retorna uma visão de boas vindas e uma visão do menu conforme a seguir.

```
public interface HomeView {

    String getGreetings();
    
}

public interface MenuView {

    public String getText();
    
}
```

Os testes unitários foram fornecidos e você precisa fazê-los passar.

> Atenção: Implemente as classes nos pacotes apropriados! s