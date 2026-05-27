package Leitores;

public abstract class Leitor {
    private String nome;
    private int idade;
    private double multaPendente;

    public Leitor(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.multaPendente = 0.0;
    }



    public abstract int getLimiteEmprestimo();

    public abstract int aumentarPrazo(int prazoOriginal);

    public boolean emprestar(int emprestimosAtivos) {
        return emprestimosAtivos <= getLimiteEmprestimo() && multaPendente <= 0;
    }

    public boolean possuiMulta() {
        return multaPendente > 0;
    }

    public boolean idadePermitida(String classificacaoItem) {
        if (classificacaoItem.equalsIgnoreCase("Adulto") && this.idade < 18) {
            return false;
        }
        if (classificacaoItem.equalsIgnoreCase("Juvenil") && this.idade < 12 || this.idade > 17) {
            return false;
        }
        if (classificacaoItem.equalsIgnoreCase("Infantil") && this.idade >= 12) {
            return false;
        }
        return true;
    }

    public void adicionarMulta(double valor) {
        this.multaPendente += valor;
    }

    public void removerMulta() {
        this.multaPendente -= 0;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getMultaPendente() {
        return multaPendente;
    }

}


