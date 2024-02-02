package br.unicap.eng2.evaluation01;

import java.util.ArrayList;
import java.util.List;

class IngredientLeaf implements RecipeComponent {
    private Product product;
    private double quantity;

    public IngredientLeaf(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public double getCalories() {
        return product.getCalories() * quantity;
    }

    @Override
    public void addIngredient(RecipeComponent ingredient) {
        // Leaf nodes don't have children
    }

    @Override
    public void removeIngredient(RecipeComponent ingredient) {
        // Leaf nodes can't remove ingredients
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }

    @Override
    public String toString() {
        return "(" + product.toString() + ")";
    }

    @Override
    public void removeObserver(RecipeComposite recipeComposite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeObserver'");
    }

    @Override
    public void addObserver(RecipeComposite recipeComposite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addObserver'");
    }
}
