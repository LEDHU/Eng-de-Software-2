[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Ci38QkXr)
# Lista de Exercícios
<img src="assets/images/Unicap_Icam_Tech-01.png" alt="drawing" width="200"/>

## Identificação
**Professor**: Diego Pinheiro, PhD

**Disciplina**: Engenharia de Software 2

**Atividade**: Atividade 5

## Instruções 
> 1. Sua implementação deve estar dentro da pasta src/**main**/java 
> 2. Não modifique nenhum código dentro da pasta src/**test**/java).
> 3. A submissão **não deve ser feita após o prazo** (nem 1 minuto a mais)

## Descrição da Atividade
Considere o projeto de objetos de receitas culinárias anterior. Utilizando o conceito de `double dispath`, o padrão `Visitor` possibilitará representar operações distintas a serem executadas sobre os objetos terminais `IngredientLeaf` e composições de objetos `RecipeComposite`. 

<img src="assets/images/recipe.png" alt="drawing" width="600"/>

## Questão 1
Remova as operações `getCalories`, `getIngredients` e `getProducts` das classes `RecipeComponent`, `RecipeComposite` e `IngredientLeaf`. Estes métodos serão implementados nos `CaloriesRecipeVisitor` (questão 4), `ProductsRecipeVisitor` (questão 5), e `IngredientsRecipeVisitor` (questão 6).

## Questão 2
Crie uma classe abstrata `RecipeVisitor` com as operações 
1.	public abstract void visit(RecipeComposite recipeComposite);
2.	public abstract void visit(IngredientLeaf ingredientLeaf);

## Questão 3
Altere a classe `RecipeComponent` e, para possibilitar o double dispatch, inclua a operação

1.	 public abstract void accept(RecipeVisitor visitor)

## Questão 4
Crie a classe `CaloriesRecipeVisitor` que extends de `RecipeVisitor` e implementa o método `getCalories()`. Para isso, a classe deve `overrides` as operações
1.	public void visit(IngredientLeaf ingredientLeaf)
2.	public void visit(RecipeComposite recipeComposite)

## Questão 5
Crie a classe `ProductsRecipeVisitor` que extends de `RecipeVisitor` e implementa o método `getProducts()`. Para isso, a classe deve `overrides` as operações
1.	public void visit(IngredientLeaf ingredientLeaf)
2.	public void visit(RecipeComposite recipeComposite)


## Questão 6
Crie a classe `IngredientsRecipeVisitor` que `extends` de `RecipeVisitor` e implementa o método `getIngredients()`. Para isso, a classe deve `overrides` as operações
1.	public void visit(IngredientLeaf ingredientLeaf)
2.	public void visit(RecipeComposite recipeComposite)
