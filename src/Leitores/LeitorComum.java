package Leitores;

public class LeitorComum extends Leitor {

    public LeitorComum(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public int getLimiteEmprestimo() {
        return 3;
    }

    @Override
    public int aumentarPrazo(int prazoOriginal) {
        return 0;
    }
}