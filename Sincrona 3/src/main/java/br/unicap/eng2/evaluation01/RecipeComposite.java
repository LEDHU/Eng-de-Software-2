package br.unicap.eng2.evaluation01;

import java.util.ArrayList;
import java.util.List;

class RecipeComposite implements RecipeComponent, Observer {
    private String name;
    private double quantity;
    private List<RecipeComponent> ingredients;
    private List<Observer> observers;

    public RecipeComposite(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
        this.ingredients = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public double getCalories() {
        double calories = 0;
        for (RecipeComponent ingredient : ingredients) {
            calories += ingredient.getCalories();
        }
        return calories * quantity;
    }

    @Override
    public void addIngredient(RecipeComponent ingredient) {
        ingredients.add(ingredient);
        ingredient.addObserver(this);
        notifyObservers();
    }

    @Override
    public void removeIngredient(RecipeComponent ingredient) {
        ingredients.remove(ingredient);
        ingredient.removeObserver(this);
        notifyObservers();
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (RecipeComponent ingredient : ingredients) {
            products.addAll(ingredient.getProducts());
        }
        return products;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name).append("(");
        for (RecipeComponent ingredient : ingredients) {
            result.append(ingredient.toString());
        }
        result.append(")");
        return result.toString();
    }

    @Override
    public void update() {
        // Called when a child ingredient is added or removed
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
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