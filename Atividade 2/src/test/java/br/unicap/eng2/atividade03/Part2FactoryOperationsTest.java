/**
 * @author Diego Pinheiro <diegompin@gmail.com>
 */

package br.unicap.eng2.atividade03;

import br.unicap.eng2.atividade03.operations.Operation;
import br.unicap.eng2.atividade03.operations.OperationMultiplication;
import br.unicap.eng2.atividade03.operations.OperationSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.unicap.eng2.atividade03.operations.FactoryOperations;
import br.unicap.eng2.atividade03.operations.FactoryOperationsMultiplicationThenSum;
import br.unicap.eng2.atividade03.operations.FactoryOperationsSumThenMultiplication;

public class Part2FactoryOperationsTest {
	
	@Test
	public void test01FactorySumThenMultiplicationBottomOperation() {
		FactoryOperations factoryOperations = new FactoryOperationsSumThenMultiplication();
		Operation operation = factoryOperations.createBottomOperation();
		Assertions.assertTrue(operation instanceof OperationSum);
	}
	
	@Test
	public void test02FactorySumThenMultiplicationTopOperation() {
		FactoryOperations factoryOperations = new FactoryOperationsSumThenMultiplication();
		Operation operation = factoryOperations.createTopOperation();
		Assertions.assertTrue(operation instanceof OperationMultiplication);
	}
	
	@Test
	public void test03FactoryMultiplicationThenSumBottomOperation() {
		FactoryOperations factoryOperations = new FactoryOperationsMultiplicationThenSum();
		Operation operation = factoryOperations.createBottomOperation();
		Assertions.assertTrue(operation instanceof OperationMultiplication);
	}
	
	@Test
	public void test04FactoryMultiplicationThenSumTopOperation() {
		FactoryOperations factoryOperations = new FactoryOperationsMultiplicationThenSum();
		Operation operation = factoryOperations.createTopOperation();
		Assertions.assertTrue(operation instanceof OperationSum);
	}
}
