package br.unicap.eng2.atividade05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.unicap.eng2.atividade05.visitors.CaloriesRecipeVisitor;


public class TestVisitorCalories extends TestVisitorBase{
	
	@Test
	public void test01GetCaloriesRecipeCompositeTomatoSauce() {
		double expected = getCaloriesTomatoSauce();
		CaloriesRecipeVisitor visitor = new CaloriesRecipeVisitor();
		recipeTomatoSouce.accept(visitor);
		double actual = visitor.getCalories();
		Assertions.assertEquals(expected, actual, 0.0001);
	}

	private double getCaloriesTomatoSauce() {
		double caloriesIngredientTomato = ingredientTomatoQuantity * caloriesTomato; 
		double caloriesIngredientGarlic = ingredientGarlicQuantity * caloriesGarlic;
		double caloriesIngredientOliveOil = ingredientOliveOilQuantity * caloriesOliveOil;
		double caloriesRecipeTomatoSauce = caloriesIngredientTomato + caloriesIngredientGarlic + caloriesIngredientOliveOil;
		return recipeTomatoSouceQuantity * caloriesRecipeTomatoSauce;
	}
	
	@Test
	public void test01GetCaloriesRecipeComposite5MinuteSpaghetti() {
		double caloriesRecipeTomatoSauce = getCaloriesTomatoSauce();
		double caloriesIngredientSpaghetti = ingredientSpaghettiQuantity * caloriesSpaghetti;
		double caloriesRecipe5MinuteSpaghetti = caloriesRecipeTomatoSauce + caloriesIngredientSpaghetti;
		double expected = recipe5MinuteSpaghettiQuantity * caloriesRecipe5MinuteSpaghetti;
		CaloriesRecipeVisitor visitor = new CaloriesRecipeVisitor();
		recipe5MinuteSpaghetti.accept(visitor);
		double actual = visitor.getCalories();
		Assertions.assertEquals(expected, actual, 0.0001);
		
	}
	

	@Test
	public void testGetCaloriesIngredientGarlic() {
		CaloriesRecipeVisitor visitor = new CaloriesRecipeVisitor();
		this.ingredientGarlic.accept(visitor);
		double actual = visitor.getCalories();
		double expected = this.ingredientGarlicQuantity * this.caloriesGarlic;
		Assertions.assertEquals(expected, actual, 0.0001);
		
	}
	


}
