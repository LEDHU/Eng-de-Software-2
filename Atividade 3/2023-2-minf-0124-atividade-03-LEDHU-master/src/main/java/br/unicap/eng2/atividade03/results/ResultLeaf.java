package br.unicap.eng2.atividade03.results;

public class ResultLeaf implements ResultComponent {
    private double valor;

    public ResultLeaf(double valor) {
        this.valor = valor;
    }

    @Override
    public double getResult() {
        return valor;
    }
}