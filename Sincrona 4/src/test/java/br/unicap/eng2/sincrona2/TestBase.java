package br.unicap.eng2.sincrona2;

import org.junit.jupiter.api.BeforeEach;

public class TestBase {

	String nameVotingUnit1;
	int populationSizeVotingUnit1;
	VotingUnit votingUnit1;

	String nameVotingUnit2;
	int populationSizeVotingUnit2;
	VotingUnit votingUnit2;
		
	int votesCandidateAUnit1;
	int votesCandidateAUnit2;
	String nameCandidateA;
		
	int votesCandidateBUnit1; 
	int votesCandidateBUnit2; 
	String nameCandidateB;

	VotingComponent votingComposite1;
	VotingComponent votingComposite2;

	String nameVotingComposite1;
	String nameVotingComposite2;

	public TestBase() {
		
	}

	@BeforeEach
	void setUp(){
		createVotingUnit1();
		createVotingUnit2();
		createCandidateA();
		createCandidateB();
		nameVotingComposite1 = "Nordeste";
		votingComposite1 = new VotingComposite(nameVotingComposite1);
		votingComposite1.addChild(votingUnit1);
		votingComposite1.addChild(votingUnit2);
		nameVotingComposite2 = "Brasil";
		votingComposite2 = new VotingComposite(nameVotingComposite2);
		votingComposite2.addChild(votingComposite1);
	}

	private void createVotingUnit1() {
		nameVotingUnit1 = "Pernambuco";
		populationSizeVotingUnit1 = 100;
		votingUnit1 = new VotingUnit(nameVotingUnit1, populationSizeVotingUnit1);
	}

	private void createVotingUnit2() {
		nameVotingUnit2 = "Alagoas";
		populationSizeVotingUnit2 = 1000;
		votingUnit2 = new VotingUnit(nameVotingUnit2, populationSizeVotingUnit2);
	}

	private void createCandidateA() {
		votesCandidateAUnit1 = 1;
		votesCandidateAUnit2 = 2;
		nameCandidateA = "Candidate A";
		createCandidate(nameCandidateA, votingUnit1, votesCandidateAUnit1);
		createCandidate(nameCandidateA, votingUnit2, votesCandidateAUnit2);
	}
	private void createCandidateB() {
		votesCandidateBUnit1 = 10;
		votesCandidateBUnit2 = 20;
		nameCandidateB = "Candidate B";
		createCandidate(nameCandidateB, votingUnit1, votesCandidateBUnit1);
		createCandidate(nameCandidateB, votingUnit2, votesCandidateBUnit2);
	}

	private void createCandidate(String nameCandidate, VotingUnit votingUnit, int votesCandidate) {
		Candidate newCandidate = new Candidate(nameCandidate);
		votingUnit.addCandidate(newCandidate);
		votingUnit.addVotes(nameCandidate, votesCandidate);
	}
}