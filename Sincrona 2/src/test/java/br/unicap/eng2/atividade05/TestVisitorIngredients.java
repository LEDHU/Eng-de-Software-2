package br.unicap.eng2.atividade05;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.unicap.eng2.atividade05.visitors.IngredientsRecipeVisitor;

public class TestVisitorIngredients extends TestVisitorBase{
	
	@Test
	public void test03GetIngredients() {
		List<String> expected = new ArrayList<>();

		String recipe5MinuteSpaghettiPrefix = recipe5MinuteSpaghettiName + ", ";
		expected.add(recipe5MinuteSpaghettiPrefix + productNameSpaghetti);
		
		String recipeTomatoSaucePrefix = recipe5MinuteSpaghettiName + ", " + recipeTomatoSouceName + ", ";
		expected.add(recipeTomatoSaucePrefix + productNameTomato);
		expected.add(recipeTomatoSaucePrefix + productNameGarlic);
		expected.add(recipeTomatoSaucePrefix + productNameOliveOil);

		

		IngredientsRecipeVisitor visitor = new IngredientsRecipeVisitor();
		recipe5MinuteSpaghetti.accept(visitor);
		List<String> actual = visitor.getIngredients();

		Assertions.assertEquals(expected, actual);
	}

}
