package br.unicap.eng2.atividade05.recipes;

public abstract class RecipeComponent {
  public abstract void accept(RecipeVisitor visitor);
}