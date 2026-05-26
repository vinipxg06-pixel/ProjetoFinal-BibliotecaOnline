package Leitores;

public abstract class Leitor {
        private String nome;
        private int idade;
        private double multaPendente;
        public Leitor(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }
        public abstract int getLimiteEmprestimos();
        public boolean podeEmprestar(int emprestimosAtivos) {

            return emprestimosAtivos < getLimiteEmprestimos()
                    && multaPendente <= 0;
        }


        public boolean possuiMulta() {
            return multaPendente > 0;
        }
        public void adicionarMulta(double valor) {
            multaPendente += valor;
        }
        public void quitarMulta() {
            multaPendente = 0;
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