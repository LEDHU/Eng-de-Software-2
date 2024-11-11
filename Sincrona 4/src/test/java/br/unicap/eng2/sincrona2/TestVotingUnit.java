package br.unicap.eng2.sincrona2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestVotingUnit extends TestBase{

	@ParameterizedTest()
	@ValueSource(ints = {0, 10, 20, 30})
	public void testAddVotes(int newVotes) {
		votingUnit1.addVotes(nameCandidateA, newVotes);
		int expected = votesCandidateAUnit1 + newVotes;
		int actual = votingUnit1.getVotes(nameCandidateA);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotes() {
		int expected = votesCandidateAUnit1 + votesCandidateBUnit1;
		int actual = votingUnit1.getVotes();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesCandidateA() {
		int expected = votesCandidateAUnit1;
		int actual = votingUnit1.getVotes(nameCandidateA);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesCandidateB() {
		int expected = votesCandidateBUnit1;
		int actual = votingUnit1.getVotes(nameCandidateB);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVotesProportion() {
		double expected = (double) (votesCandidateAUnit1 + votesCandidateBUnit1) / populationSizeVotingUnit1;
		double actual = votingUnit1.getVotesProportion();
		Assertions.assertEquals(expected, actual);
	}

	
	@Test
	public void testGetVotesProportingCandidateA() {
		double expected = (double) votesCandidateAUnit1 / populationSizeVotingUnit1;
		double actual = votingUnit1.getVotesProportion(nameCandidateA);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesProportingCandidateB() {
		double expected = (double) votesCandidateBUnit1 / populationSizeVotingUnit1;
		double actual = votingUnit1.getVotesProportion(nameCandidateB);
		Assertions.assertEquals(expected, actual);
	}

}