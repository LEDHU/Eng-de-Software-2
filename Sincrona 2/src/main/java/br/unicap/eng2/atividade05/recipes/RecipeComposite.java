package br.unicap.eng2.atividade05.recipes;

public class RecipeComposite extends RecipeComponent {
    @Override
    public void accept(RecipeVisitor visitor) {
        visitor.visit(this);
    }
}
