package br.unicap.eng2.evaluation01;

import java.util.List;

interface RecipeComponent {
    double getCalories();

    void addIngredient(RecipeComponent ingredient);

    void removeIngredient(RecipeComponent ingredient);

    List<Product> getProducts();

    String toString();

    void removeObserver(RecipeComposite recipeComposite);

    void addObserver(RecipeComposite recipeComposite);
}
