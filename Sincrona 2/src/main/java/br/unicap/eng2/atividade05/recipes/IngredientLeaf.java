package br.unicap.eng2.atividade05.recipes;

public class IngredientLeaf extends RecipeComponent {
    private Product product;
    private double quantity;

    public IngredientLeaf(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    //so se tivesse os gets aqui

    @Override
    public void accept(RecipeVisitor visitor) {
        visitor.visit(this);
    }
}
