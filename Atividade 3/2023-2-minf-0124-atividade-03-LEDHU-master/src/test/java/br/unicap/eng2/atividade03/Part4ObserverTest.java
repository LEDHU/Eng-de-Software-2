/**
 * @author Diego Pinheiro <diegompin@gmail.com>
 */

package br.unicap.eng2.atividade03;

import br.unicap.eng2.atividade03.operations.FactoryOperations;
import br.unicap.eng2.atividade03.operations.FactoryOperationsSumThenMultiplication;
import br.unicap.eng2.atividade03.results.observer.ResultBuilder;
import br.unicap.eng2.atividade03.results.observer.ResultComponent;
import br.unicap.eng2.atividade03.results.observer.ResultLeaf;
import br.unicap.eng2.atividade03.results.observer.ResultObserver;
import br.unicap.eng2.atividade03.results.observer.ResultSubject;
import br.unicap.eng2.atividade03.results.observer.ResultComposite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Part4ObserverTest {

	private class TestObserverUpdated implements ResultObserver {
		private ResultSubject resultComponent;

		@Override
		public void update(ResultSubject subject) {
			this.resultComponent = subject;
		}

		public ResultSubject getResultSubject() {
			return this.resultComponent;
		}

	}

	private ResultLeaf resultLeaf1;
	private ResultLeaf resultLeaf2;
	private ResultLeaf resultLeaf3;
	private ResultLeaf resultLeaf4;
	private ResultLeaf[] resultLeafLeftValues;
	private ResultLeaf[] resultLeafRightValues;
	private ResultBuilder resultBuilder;
	private FactoryOperations factoryOperations;
	private ResultComposite resultCompositeBottomLeft;
	private ResultComposite resultCompositeBottomRight;
	private TestObserverUpdated observerResultLeaf1;
	private TestObserverUpdated observerResultLeaf2;
	private TestObserverUpdated observerResultCompositeBottomLeft;
	private TestObserverUpdated observerResultCompositeBottomRight;

	private ResultComponent resultComponent;

	@BeforeEach
	public void setUp() {
		createLeafs();
		createResultComponent();
		attachObservers();
	}

	private void attachObservers() {
		this.observerResultLeaf1 = new TestObserverUpdated();
		this.observerResultLeaf2 = new TestObserverUpdated();
		this.observerResultCompositeBottomLeft = new TestObserverUpdated();
		this.observerResultCompositeBottomRight = new TestObserverUpdated();
		this.resultLeaf1.attach(this.observerResultLeaf1);
		this.resultLeaf2.attach(this.observerResultLeaf2);
		this.resultCompositeBottomLeft.attach(this.observerResultCompositeBottomLeft);
		this.resultCompositeBottomRight.attach(this.observerResultCompositeBottomRight);
	}

	private void createResultComponent() {
		this.factoryOperations = new FactoryOperationsSumThenMultiplication();
		this.resultBuilder = new ResultBuilder(this.factoryOperations);
		this.resultCompositeBottomLeft = new ResultComposite(this.factoryOperations.createBottomOperation());
		this.resultCompositeBottomRight = new ResultComposite(this.factoryOperations.createBottomOperation());
		this.resultComponent = this.resultBuilder.buildOperations(this.resultLeafLeftValues, this.resultLeafRightValues,
				this.resultCompositeBottomLeft, this.resultCompositeBottomRight);
	}

	private void createLeafs() {
		this.resultLeaf1 = new ResultLeaf(1);
		this.resultLeaf2 = new ResultLeaf(2);
		this.resultLeaf3 = new ResultLeaf(3);
		this.resultLeaf4 = new ResultLeaf(4);
		this.resultLeafLeftValues = new ResultLeaf[] { resultLeaf1, resultLeaf2 };
		this.resultLeafRightValues = new ResultLeaf[] { resultLeaf3, resultLeaf4 };
	}

	@Test
	public void test01SetValueResultLeafLeft1() {
		this.resultLeaf1.setResult(3);
		double expected = 35;
		double actual = this.resultComponent.getResult();
		Assertions.assertEquals(expected, actual, 0.0001);

	}

	@Test
	public void test02SetValueResultLeafLeft2() {
		this.resultLeaf2.setResult(3);
		double expected = 28;
		double actual = this.resultComponent.getResult();
		Assertions.assertEquals(expected, actual, 0.0001);

	}

	@Test
	public void test03SetValueResultLeafLeftNotifyObserverResultLeafLeft() {
		this.resultLeaf1.setResult(3);
		ResultSubject expected = this.resultLeaf1;
		ResultSubject actual = this.observerResultLeaf1.getResultSubject();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test04SetValueResultLeafRightNotifyObserverResultLeafRight() {
		this.resultLeaf2.setResult(3);
		ResultSubject expected = this.resultLeaf2;
		ResultSubject actual = this.observerResultLeaf2.getResultSubject();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void test05AddResultCompositeBottomLeft() {
		this.resultCompositeBottomLeft.addResult(this.resultLeaf1);
		double expected = 28;
		double actual = this.resultComponent.getResult();
		Assertions.assertEquals(expected, actual, 0.0001);

	}

	@Test
	public void test06AddResultCompositeBottomLeftNotifyResultCompositeBottomLeft() {
		this.resultCompositeBottomLeft.addResult(this.resultLeaf1);
		ResultSubject expected = this.resultCompositeBottomLeft;
		ResultSubject actual = this.observerResultCompositeBottomLeft.getResultSubject();
		Assertions.assertEquals(expected, actual);

	}

	@Test
	public void test07AddResultCompositeBottomRightNotifyResultCompositeBottomRight() {
		this.resultCompositeBottomRight.addResult(this.resultLeaf1);
		ResultSubject expected = this.resultCompositeBottomRight;
		ResultSubject actual = this.observerResultCompositeBottomRight.getResultSubject();
		Assertions.assertEquals(expected, actual);

	}

}
