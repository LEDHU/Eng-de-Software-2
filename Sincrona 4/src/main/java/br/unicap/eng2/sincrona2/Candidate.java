package br.unicap.eng2.sincrona2;

public class Candidate {
    private final String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVotes(int votes) {
        this.votes += votes;
    }
}