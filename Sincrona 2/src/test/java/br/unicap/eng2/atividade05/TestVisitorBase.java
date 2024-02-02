package br.unicap.eng2.atividade05;

import br.unicap.eng2.atividade05.recipes.IngredientLeaf;
import br.unicap.eng2.atividade05.recipes.Product;
import br.unicap.eng2.atividade05.recipes.RecipeComponent;
import br.unicap.eng2.atividade05.recipes.RecipeComposite;

public abstract class TestVisitorBase {

	protected double caloriesTomato;
	protected double caloriesGarlic;
	protected double caloriesOliveOil;
	protected double caloriesSpaghetti;

	protected String productNameTomato;
	protected String productNameGarlic;
	protected String productNameOliveOil;
	protected String productNameSpaghetti;

	protected Product productTomato;
	protected Product productGarlic;
	protected Product productOliveOil;
	protected Product productSpaghetti;

	protected double ingredientTomatoQuantity;
	protected double ingredientGarlicQuantity;
	protected double ingredientOliveOilQuantity;

	protected IngredientLeaf ingredientTomato;
	protected IngredientLeaf ingredientGarlic;
	protected IngredientLeaf ingredientOliveOil;

	protected double recipeTomatoSouceQuantity;
	protected String recipeTomatoSouceName;
	protected RecipeComposite recipeTomatoSouce;

	protected IngredientLeaf ingredientSpaghetti;

	protected double ingredientSpaghettiQuantity;
	protected double recipe5MinuteSpaghettiQuantity;
	protected String recipe5MinuteSpaghettiName;
	protected RecipeComponent recipe5MinuteSpaghetti;

	public TestVisitorBase() {
		initializeProducts();
		initializeRecipeTomatoSouce();
		initializeRecipeSpaghetti();
	}
	
	
	private void initializeProducts() {
		caloriesTomato = 7.5;
		caloriesGarlic = 5.65;
		caloriesOliveOil = 70.72;
		caloriesSpaghetti = 1800;

		productNameTomato = "Tomato";
		productNameGarlic = "Garlic";
		productNameOliveOil = "Olive Oil";
		productNameSpaghetti = "Spaghetti";

		productTomato = new Product(productNameTomato, caloriesTomato);
		productGarlic = new Product(productNameGarlic, caloriesGarlic);
		productOliveOil = new Product(productNameOliveOil, caloriesOliveOil);
		productSpaghetti = new Product(productNameSpaghetti, caloriesSpaghetti);
	}

	private void initializeRecipeTomatoSouce() {
		recipeTomatoSouceName = "Tomato Sauce";

		ingredientTomatoQuantity = 3;
		ingredientGarlicQuantity = 1;
		ingredientOliveOilQuantity = 1;

		ingredientTomato = new IngredientLeaf(productTomato, ingredientTomatoQuantity);
		ingredientGarlic = new IngredientLeaf(productGarlic, ingredientGarlicQuantity);
		ingredientOliveOil = new IngredientLeaf(productOliveOil, ingredientOliveOilQuantity);

		recipeTomatoSouceQuantity = 3;
		recipeTomatoSouce = new RecipeComposite(recipeTomatoSouceName, recipeTomatoSouceQuantity);
		recipeTomatoSouce.addIngredient(ingredientTomato);
		recipeTomatoSouce.addIngredient(ingredientGarlic);
		recipeTomatoSouce.addIngredient(ingredientOliveOil);
	}

	private void initializeRecipeSpaghetti() {
		recipe5MinuteSpaghettiName = "5 Minute Spaghetti";
		ingredientSpaghettiQuantity = 2;
		recipe5MinuteSpaghettiQuantity = 3;
		ingredientSpaghetti = new IngredientLeaf(productSpaghetti, ingredientSpaghettiQuantity);
		recipe5MinuteSpaghetti = new RecipeComposite(recipe5MinuteSpaghettiName, recipe5MinuteSpaghettiQuantity);
		
		recipe5MinuteSpaghetti.addIngredient(ingredientSpaghetti);
		recipe5MinuteSpaghetti.addIngredient(recipeTomatoSouce);
	}
}
