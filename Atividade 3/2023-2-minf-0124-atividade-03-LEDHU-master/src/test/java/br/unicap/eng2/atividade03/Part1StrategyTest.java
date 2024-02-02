/**
 * @author Diego Pinheiro <diegompin@gmail.com>
 */

package br.unicap.eng2.atividade03;

import br.unicap.eng2.atividade03.operations.Operation;
import br.unicap.eng2.atividade03.operations.OperationMultiplication;
import br.unicap.eng2.atividade03.operations.OperationSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Part1StrategyTest {
	
	private double value1;
	private double value2;
	
	@BeforeEach
	public void setUp() {
		value1 = 10;
		value2 = 20;
	}

	@Test
	public void test01OperationSum() {
		Operation operation = new OperationSum();
		double actual = operation.calculate(this.value1, this.value2);
		double expected = 30;
		Assertions.assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void test02OperationMultiplication() {
		Operation operation = new OperationMultiplication();
		double actual = operation.calculate(this.value1, this.value2);
		double expected = 200;
		Assertions.assertEquals(expected, actual, 0.0001);
	}
}
