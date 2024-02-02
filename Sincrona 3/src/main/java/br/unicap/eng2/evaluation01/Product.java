package br.unicap.eng2.evaluation01;

public class Product {
    private String name;
    private double calories;

    public Product(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
