/**
 * @author Diego Pinheiro <diegompin@gmail.com>
 */

package br.unicap.eng2.atividade03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.unicap.eng2.atividade03.operations.FactoryOperations;
import br.unicap.eng2.atividade03.operations.FactoryOperationsMultiplicationThenSum;
import br.unicap.eng2.atividade03.operations.FactoryOperationsSumThenMultiplication;
import br.unicap.eng2.atividade03.results.ResultBuilder;
import br.unicap.eng2.atividade03.results.ResultComponent;
import br.unicap.eng2.atividade03.results.ResultLeaf;

public class Part3CompositeTest {
	
	@Test
	public void test01CompositeLeafOnly() {
		double result = 3;
		ResultComponent resultComponent = new ResultLeaf(result);
		double actual = resultComponent.getResult();
		double expected = 3;
		Assertions.assertEquals(expected, actual, 0.001);
	}

	@Test
	public void test02SumThenMultiplication() {
		FactoryOperations operationsFactory = new FactoryOperationsSumThenMultiplication();
		ResultBuilder resultBuilder = new ResultBuilder(operationsFactory);
		double[] leftValues = new double[] { 1, 2 };
		double[] rightValues = new double[] { 3, 4 };
		ResultComponent resultComponent = resultBuilder.buildOperations(leftValues, rightValues);
		double actual = resultComponent.getResult();
		double expected = 21;
		Assertions.assertEquals(expected, actual, 0.001);
	}

	@Test
	public void test03MultiplicationThenSum() {
		FactoryOperations operationsFactory = new FactoryOperationsMultiplicationThenSum();
		ResultBuilder resultBuilder = new ResultBuilder(operationsFactory);
		double[] leftValues = new double[] { 1, 2 };
		double[] rightValues = new double[] { 3, 4 };
		ResultComponent resultComponent = resultBuilder.buildOperations(leftValues, rightValues);
		double actual = resultComponent.getResult();
		double expected = 14;
		Assertions.assertEquals(expected, actual, 0.001);
	}

}
