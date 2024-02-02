[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/uFsbA2aE)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11680895&assignment_repo_type=AssignmentRepo)
# Lista de Exercícios
<img src="assets/images/Unicap_Icam_Tech-01.png" alt="drawing" width="200"/>

## Identificação
**Professor**: Diego Pinheiro, PhD

**Disciplina**: Engenharia de Software 2

**Atividade**: Atividade 03 - Padrões de Projeto

## Instruções 
> 1. Sua implementação deve estar dentro da pasta src/**main**/java 
> 2. Não modifique nenhum código dentro da pasta src/**test**/java).
> 3. A submissão **não deve ser feita após o prazo** (nem 1 minuto a mais)

## Descrição da Atividade
### Questão 01
Utilize o padrão `Strategy` para definir uma família de algorítmos `Operation`. Esconda as decisões de projeto das operações de soma e multiplicação nas subclasses `OperationSum` e `OperationMultiplication`, respectivamente. 

<img src="assets/images/fig1.png" alt="drawing" width="600"/>

### Questão 02
Utilize o padrão de projeto `AbstractFactory` para possibilitar a criação de estratégias `OperationSum` e `OperationMultiplication` através da interface `FactoryOperations`. Para a `FactoryOperationsSumThenMultiplication`, os métodos `createBottomOperation` e `createTopOperation` criam `OperationSum` e `OperationMultiplication`, respectivamente. Para a `FactoryOperationsMultiplicationThenSum`, os métodos `createBottomOperation` e `createTopOperation` criam `OperationMultiplication` e `OperationSum`, respectivamente.

<img src="assets/images/fig2.png" alt="drawing" width="600"/>

<img src="assets/images/fig3.png" alt="drawing" width="600"/>

<img src="assets/images/fig4.png" alt="drawing" width="600"/>

