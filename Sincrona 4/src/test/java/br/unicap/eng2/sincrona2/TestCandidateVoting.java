package br.unicap.eng2.sincrona2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCandidateVoting extends TestBase{
	
	@ParameterizedTest()
	@ValueSource(ints = {0, 10, 20, 30})
	public void testAddVotes(int newVotes) {
		votingUnit1.addVotes(nameCandidateA, newVotes);
		int expected = votesCandidateAUnit1 + newVotes;
		int actual = votingUnit1.getVotes(nameCandidateA);
		Assertions.assertEquals(expected, actual);
	}
	
}