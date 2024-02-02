package br.unicap.eng2.atividade05.visitors;

import br.unicap.eng2.atividade05.recipes.IngredientLeaf;
import br.unicap.eng2.atividade05.recipes.RecipeComposite;
import br.unicap.eng2.atividade05.recipes.RecipeVisitor;

public class CaloriesRecipeVisitor extends RecipeVisitor {
    private double totalCalories;

    public CaloriesRecipeVisitor(double totalCalories){
        this.totalCalories = totalCalories;
    }

    public double getCalories() {
        return totalCalories;
    }

    @Override
    public void visit(IngredientLeaf ingredientLeaf) {
        totalCalories += ingredientLeaf.getCalories();
    }

    @Override
    public void visit(RecipeComposite recipeComposite) {
        totalCalories += recipeComposite.getCalories();
    }
}
