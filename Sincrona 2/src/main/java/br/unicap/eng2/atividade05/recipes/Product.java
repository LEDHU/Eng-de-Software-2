package br.unicap.eng2.atividade05.recipes;

public class Product {
    private String name;
    private double calories;

    public Product(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

}
