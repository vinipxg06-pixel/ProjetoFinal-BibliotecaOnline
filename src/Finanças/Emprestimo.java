package Finanças;
import Leitores.Leitor;
import java.time.LocalDate;

public class Emprestimo {
    private Leitor leitor;
    private String nomeItem;
    private String tipoItem;
    private LocalDate dataEmprestimo;
    private LocalDate dataLimite;
    private int qtdRenovacoes;
    private boolean ativo;

    public Emprestimo(Leitor leitor, String nomeItem, String tipoItem) {
        this.leitor = leitor;
        this.nomeItem = nomeItem;
        this.tipoItem = tipoItem.toUpperCase();
        this.dataEmprestimo = LocalDate.now();
        this.qtdRenovacoes = 0;
        this.ativo = true;

        this.dataLimite = calcularDataLimite();
    }

    private LocalDate calcularDataLimite() {
        int prazoOriginal = 0;

        if (this.tipoItem.equals("LIVRO")) {
            prazoOriginal = 14;
        } else if (this.tipoItem.equals("REVISTA")) {
            prazoOriginal = 7;
        } else if (this.tipoItem.equals("HQ")) {
            prazoOriginal = 10;
        }

        int prazoFinal = leitor.aumentarPrazo(prazoOriginal);
        return this.dataEmprestimo.plusDays(prazoFinal);
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public int getQtdRenovacoes() {
        return qtdRenovacoes;
    }

    public String getSituacao() {
        if (!ativo) {
            return "DEVOLVIDO";
        }
        if (LocalDate.now().isAfter(dataLimite)) {
            return "ATRASADO";
        }
        if (tipoItem.equals("LIVRO") && qtdRenovacoes == 0) {
            return "EM DIA (pode renovar)";
        }
        return "EM DIA";
    }

    public void devolver(LocalDate dataDevolucaoEfetiva) {
        this.ativo = false;
        if (dataDevolucaoEfetiva.isAfter(this.dataLimite)) {
            long diasAtraso = java.time.temporal.ChronoUnit.DAYS.between(this.dataLimite, dataDevolucaoEfetiva);
            double valorMulta = diasAtraso * 1.50;

            this.leitor.adicionarMulta(valorMulta);
            System.out.println("[Devolução com Atraso] Item entregue com " + diasAtraso + " dias de atraso. Multa aplicada: R$ " + valorMulta);
        } else {
            System.out.println("[Sucesso] Item devolvido em dia!");
        }
    }

    public boolean renovar() {
        if (!this.ativo) {
            System.out.println("[Erro] Este empréstimo já foi encerrado.");
            return false;
        }

        if (this.tipoItem.equals("REVISTA") || this.tipoItem.equals("HQ")) {
            System.out.println("[RECUSADO] Revistas e HQs não podem ser renovadas.");
            return false;
        }

        if (this.tipoItem.equals("LIVRO") && this.qtdRenovacoes >= 1) {
            System.out.println("[RECUSADO] Livros só podem ser renovados uma única vez.");
            return false;
        }
        this.qtdRenovacoes++;

        int prazoRenovacao = leitor.aumentarPrazo(14);
        this.dataLimite = this.dataLimite.plusDays(prazoRenovacao);

        System.out.println("[SUCESSO] Item renovado! Nova data limite: " + this.dataLimite);
        return true;
    }
}