package br.unicap.eng2.sincrona2;

public interface VotingComponent {
    int getVotes();
    int getVotes(String candidateName);
    double getVotesProportion();
    double getVotesProportion(String candidateName);
    void addChild(VotingComponent votingUnit);
}
