package br.unicap.eng2.atividade05.recipes;

public abstract class RecipeVisitor {
    public abstract void visit(RecipeComposite recipeComposite);
    public abstract void visit(IngredientLeaf ingredientLeaf);
}
