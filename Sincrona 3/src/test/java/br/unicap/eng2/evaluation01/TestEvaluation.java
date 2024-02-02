package br.unicap.eng2.evaluation01;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestEvaluation {

	private double caloriesTomato;
	private double caloriesGarlic;
	private double caloriesOliveOil;
	private double caloriesSpaghetti;

	private String productNameTomato;
	private String productNameGarlic;
	private String productNameOliveOil;
	private String productNameSpaghetti;

	private Product productTomato;
	private Product productGarlic;
	private Product productOliveOil;
	private Product productSpaghetti;

	private double ingredientTomatoQuantity;
	private double ingredientGarlicQuantity;
	private double ingredientOliveOilQuantity;

	private RecipeComponent ingredientTomato;
	private RecipeComponent ingredientGarlic;
	private RecipeComponent ingredientOliveOil;

	private double recipeTomatoSouceQuantity;
	private String recipeTomatoSouceName;
	private RecipeComponent recipeTomatoSouce;

	private RecipeComponent ingredientSpaghetti;

	private double ingredientSpaghettiQuantity;
	private double recipe5MinuteSpaghettiQuantity;
	private String recipe5MinuteSpaghettiName;
	private RecipeComponent recipe5MinuteSpaghetti;

	private RecipeComponent recipeFamilyDinner;
	private String recipeFamilyDinnerName;
	private double ingredientFamilyDinnerQuantity;

	public TestEvaluation() {
		initializeProducts();
		initializeRecipeTomatoSouce();
		initializeRecipeSpaghetti();
		initializeFamilyDinner();
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
		ingredientTomatoQuantity = 3;
		ingredientGarlicQuantity = 1;
		ingredientOliveOilQuantity = 2;

		ingredientTomato = new IngredientLeaf(productTomato, ingredientTomatoQuantity);
		ingredientGarlic = new IngredientLeaf(productGarlic, ingredientGarlicQuantity);
		ingredientOliveOil = new IngredientLeaf(productOliveOil, ingredientOliveOilQuantity);

		recipeTomatoSouceQuantity = 3;
		recipeTomatoSouceName = "Tomato Sauce";
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
		recipe5MinuteSpaghetti.addIngredient(recipeTomatoSouce);
		recipe5MinuteSpaghetti.addIngredient(ingredientSpaghetti);
	}

	private void initializeFamilyDinner() {
		recipeFamilyDinnerName = "FamilyDinner";
		ingredientFamilyDinnerQuantity = 1;
		recipeFamilyDinner = new RecipeComposite(recipeFamilyDinnerName, ingredientFamilyDinnerQuantity);
		recipeFamilyDinner.addIngredient(recipe5MinuteSpaghetti);
	}

	@Test
	public void test01GetCalories() {
		double caloriesRecipeTomatoSouce = recipeTomatoSouceQuantity * (ingredientTomatoQuantity * caloriesTomato
				+ ingredientGarlicQuantity * caloriesGarlic + ingredientOliveOilQuantity * caloriesOliveOil);

		double expected = recipe5MinuteSpaghettiQuantity
				* (ingredientSpaghettiQuantity * caloriesSpaghetti + caloriesRecipeTomatoSouce);

		double actual = recipeFamilyDinner.getCalories();
		Assertions.assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test02GetCaloriesWhenChildreenRemoved() {
		recipeTomatoSouce.removeIngredient(ingredientOliveOil);

		double caloriesRecipeTomatoSouce = recipeTomatoSouceQuantity * (ingredientTomatoQuantity * caloriesTomato
				+ ingredientGarlicQuantity * caloriesGarlic);

		double expected = recipe5MinuteSpaghettiQuantity
				* (ingredientSpaghettiQuantity * caloriesSpaghetti + caloriesRecipeTomatoSouce);

		double actual = recipeFamilyDinner.getCalories();
		Assertions.assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test03GetProducts() {
		List<Product> expected = new ArrayList<Product>();
		expected.add(new Product(productNameTomato, caloriesTomato));
		expected.add(new Product(productNameGarlic, caloriesGarlic));
		expected.add(new Product(productNameOliveOil, caloriesOliveOil));
		expected.add(new Product(productNameSpaghetti, caloriesSpaghetti));
		List<Product> actual = recipeFamilyDinner.getProducts();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test04GetProductsWhenChildrenRemoved() {
		recipeTomatoSouce.removeIngredient(ingredientTomato);

		List<Product> expected = new ArrayList<Product>();
		expected.add(new Product(productNameGarlic, caloriesGarlic));
		expected.add(new Product(productNameOliveOil, caloriesOliveOil));
		expected.add(new Product(productNameSpaghetti, caloriesSpaghetti));
		List<Product> actual = recipeFamilyDinner.getProducts();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test05GetIngredients() {
		StringBuilder ingredients = new StringBuilder();
		ingredients.append(recipeFamilyDinnerName);
		ingredients.append("(");
		ingredients.append(recipe5MinuteSpaghettiName);
		ingredients.append("(");
		ingredients.append(recipeTomatoSouceName);
		ingredients.append("(");
		ingredients.append("(" + productNameTomato + ")");
		ingredients.append("(" + productNameGarlic + ")");
		ingredients.append("(" + productNameOliveOil + ")");
		ingredients.append(")");
		ingredients.append("(" + productNameSpaghetti + ")");
		ingredients.append(")");
		ingredients.append(")");

		String expected = ingredients.toString();
		String actual = recipeFamilyDinner.toString();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test06GetIngredientsWhenChildreenIngredientAreRemoved() {
		recipeTomatoSouce.removeIngredient(ingredientOliveOil);

		StringBuilder ingredients = new StringBuilder();
		ingredients.append(recipeFamilyDinnerName);
		ingredients.append("(");
		ingredients.append(recipe5MinuteSpaghettiName);
		ingredients.append("(");
		ingredients.append(recipeTomatoSouceName);
		ingredients.append("(");
		ingredients.append("(" + productNameTomato + ")");
		ingredients.append("(" + productNameGarlic + ")");
		ingredients.append(")");
		ingredients.append("(" + productNameSpaghetti + ")");
		ingredients.append(")");
		ingredients.append(")");

		String expected = ingredients.toString();
		String actual = recipeFamilyDinner.toString();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test07GetIngredientsWhenChildreenIngredientAreRemoved() {
		recipeTomatoSouce.removeIngredient(ingredientTomato);
		recipeTomatoSouce.removeIngredient(ingredientGarlic);
		recipeTomatoSouce.removeIngredient(ingredientOliveOil);

		StringBuilder ingredients = new StringBuilder();
		ingredients.append(recipeFamilyDinnerName);
		ingredients.append("(");
		ingredients.append(recipe5MinuteSpaghettiName);
		ingredients.append("(");
		ingredients.append("(" + productNameSpaghetti + ")");
		ingredients.append(")");
		ingredients.append(")");

		String expected = ingredients.toString();
		String actual = recipeFamilyDinner.toString();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test08GetIngredientsWhenChildreenIngredientAreRemoved() {
		recipe5MinuteSpaghetti.removeIngredient(ingredientSpaghetti);
		recipe5MinuteSpaghetti.removeIngredient(recipeTomatoSouce);

		String expected = recipeFamilyDinnerName + "()";
		String actual = recipeFamilyDinner.toString();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test09GetIngredientsWhenChildreenIngredientAreRemoved() {
		recipe5MinuteSpaghetti.removeIngredient(ingredientSpaghetti);
		recipeTomatoSouce.removeIngredient(ingredientTomato);
		recipeTomatoSouce.removeIngredient(ingredientGarlic);
		recipeTomatoSouce.removeIngredient(ingredientOliveOil);

		String expected = recipeFamilyDinnerName + "()";
		String actual = recipeFamilyDinner.toString();
		Assertions.assertEquals(expected, actual);
	}
}