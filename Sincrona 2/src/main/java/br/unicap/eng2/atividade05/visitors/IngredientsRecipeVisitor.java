package br.unicap.eng2.atividade05.visitors;

import java.util.ArrayList;
import java.util.List;

import br.unicap.eng2.atividade05.recipes.IngredientLeaf;
import br.unicap.eng2.atividade05.recipes.RecipeComposite;
import br.unicap.eng2.atividade05.recipes.RecipeVisitor;

public class IngredientsRecipeVisitor extends RecipeVisitor {
    private List<String> ingredients = new ArrayList<>();

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public void visit(IngredientLeaf ingredientLeaf) {
        ingredients.add(ingredientLeaf.toString());
    }

    @Override
    public void visit(RecipeComposite recipeComposite) {
        ingredients.addAll(recipeComposite.getIngredients());
    }
}
