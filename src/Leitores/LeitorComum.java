package Leitores;

public class LeitorComum extends Leitor {

    public LeitorComum(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }
}