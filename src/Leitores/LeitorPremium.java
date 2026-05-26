package Leitores;

public class LeitorPremium extends Leitor {

    public LeitorPremium(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 7;
    }

    public int aumentarPrazo(int prazoOriginal) {

        double prazoComAumento = prazoOriginal * 1.5;

        return (int) Math.ceil(prazoComAumento);
    }
}