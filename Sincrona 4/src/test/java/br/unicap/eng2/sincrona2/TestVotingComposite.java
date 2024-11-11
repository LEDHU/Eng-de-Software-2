package br.unicap.eng2.sincrona2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVotingComposite extends TestBase{

	@Test
	public void testGetVotesComposite1() {
		int expected = votingUnit1.getVotes() + votingUnit2.getVotes();
		int actual = votingComposite1.getVotes();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVotesCandidateAComposite1() {
		int expected = votesCandidateAUnit1 + votesCandidateAUnit2;
		int actual = votingComposite1.getVotes(nameCandidateA);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesProportionCandidateAComposite1() {
		double expected = (double) (votesCandidateAUnit1 + votesCandidateAUnit2) / (populationSizeVotingUnit1 + populationSizeVotingUnit2);
		double actual = votingComposite1.getVotesProportion(nameCandidateA);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesProportionCandidateBComposite1() {
		double expected = (double) (votesCandidateBUnit1 + votesCandidateBUnit2 ) / (populationSizeVotingUnit1 + populationSizeVotingUnit2);
		double actual = votingComposite1.getVotesProportion(nameCandidateB);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesProportionComposite1() {
		double expected = (double) (votesCandidateAUnit1 + votesCandidateAUnit2 + votesCandidateBUnit1 + votesCandidateBUnit2) / (populationSizeVotingUnit1 + populationSizeVotingUnit2) ;
		double actual = votingComposite1.getVotesProportion();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesComposite2() {
		int expected = votingUnit1.getVotes() + votingUnit2.getVotes();
		int actual = votingComposite2.getVotes();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVotesCandidateAComposite2() {
		int expected = votesCandidateAUnit1 + votesCandidateAUnit2;
		int actual = votingComposite2.getVotes(nameCandidateA);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesProportionCandidateAComposite2() {
		double expected = (double) (votesCandidateAUnit1 + votesCandidateAUnit2) / (populationSizeVotingUnit1 + populationSizeVotingUnit2);
		double actual = votingComposite2.getVotesProportion(nameCandidateA);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesProportionCandidateBComposite2() {
		double expected = (double) (votesCandidateBUnit1 + votesCandidateBUnit2 ) / (populationSizeVotingUnit1 + populationSizeVotingUnit2);
		double actual = votingComposite2.getVotesProportion(nameCandidateB);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetVotesProportionComposite2() {
		double expected = (double) (votesCandidateAUnit1 + votesCandidateAUnit2 + votesCandidateBUnit1 + votesCandidateBUnit2) / (populationSizeVotingUnit1 + populationSizeVotingUnit2) ;
		double actual = votingComposite2.getVotesProportion();
		Assertions.assertEquals(expected, actual);
	}

	
}