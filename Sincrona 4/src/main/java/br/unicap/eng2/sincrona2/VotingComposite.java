package br.unicap.eng2.sincrona2;

import java.util.ArrayList;
import java.util.List;

public class VotingComposite implements VotingComponent {
    private final List<VotingComponent> children = new ArrayList<>();

    public VotingComposite(String name) {
    }

    public void addChild(VotingComponent child) {
        children.add(child);
    }

    @Override
    public int getVotes() {
        return children.stream().mapToInt(VotingComponent::getVotes).sum();
    }

    @Override
    public int getVotes(String candidateName) {
        return children.stream().mapToInt(child -> child.getVotes(candidateName)).sum();
    }

    @Override
    public double getVotesProportion() {
        int totalVotes = getVotes();
        int totalPopulation = children.size();
        return (double) totalVotes / totalPopulation;
    }

    @Override
    public double getVotesProportion(String candidateName) {
        int totalVotes = getVotes(candidateName);
        int totalPopulation = children.size();
        return (double) totalVotes / totalPopulation;
    }
}
