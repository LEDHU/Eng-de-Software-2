package br.unicap.eng2.sincrona2;

import java.util.HashMap;
import java.util.Map;

public class VotingUnit implements VotingComponent{
    private final int populationSize;
    private final Map<String, Candidate> candidates = new HashMap<>();

    public VotingUnit(String name, int populationSize) {
        this.populationSize = populationSize;
    }

    public void addCandidate(Candidate candidate) {
        candidates.put(candidate.getName(), candidate);
    }

    public void addVotes(String candidateName, int votes) {
        candidates.get(candidateName).addVotes(votes);
    }

    @Override
    public int getVotes() {
        return candidates.values().stream().mapToInt(Candidate::getVotes).sum();
    }

    @Override
    public int getVotes(String candidateName) {
        return candidates.getOrDefault(candidateName, new Candidate(candidateName)).getVotes();
    }

    @Override
    public double getVotesProportion() {
        return (double) getVotes() / populationSize;
    }

    @Override
    public double getVotesProportion(String candidateName) {
        int votesForCandidate = candidates.containsKey(candidateName) ? candidates.get(candidateName).getVotes() : 0;
        return (double) votesForCandidate / populationSize;
    }

    @Override
    public void addChild(VotingComponent votingUnit1) {

    }
}