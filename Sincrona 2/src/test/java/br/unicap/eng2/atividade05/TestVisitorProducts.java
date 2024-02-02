package br.unicap.eng2.atividade05;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.unicap.eng2.atividade05.recipes.Product;
import br.unicap.eng2.atividade05.visitors.ProductsRecipeVisitor;

public class TestVisitorProducts extends TestVisitorBase {

	@Test
	public void test02GetProducts() {
		List<Product> expected = new ArrayList<Product>();
		expected.add(new Product(productNameSpaghetti, caloriesSpaghetti));
		expected.add(new Product(productNameTomato, caloriesTomato));
		expected.add(new Product(productNameGarlic, caloriesGarlic));
		expected.add(new Product(productNameOliveOil, caloriesOliveOil));
		
		
		ProductsRecipeVisitor visitor = new ProductsRecipeVisitor();
		recipe5MinuteSpaghetti.accept(visitor);
		List<Product> actual = visitor.getProducts();
		
		Assertions.assertEquals(expected, actual);
	}


}
