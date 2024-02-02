package br.unicap.eng2.atividade05.visitors;

import java.util.ArrayList;
import java.util.List;

import br.unicap.eng2.atividade05.recipes.IngredientLeaf;
import br.unicap.eng2.atividade05.recipes.Product;
import br.unicap.eng2.atividade05.recipes.RecipeComposite;
import br.unicap.eng2.atividade05.recipes.RecipeVisitor;

public class ProductsRecipeVisitor extends RecipeVisitor {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void visit(IngredientLeaf ingredientLeaf) {
        products.add(ingredientLeaf.getProduct());
    }

    @Override
    public void visit(RecipeComposite recipeComposite) {
        products.addAll(recipeComposite.getProducts());
    }
}
