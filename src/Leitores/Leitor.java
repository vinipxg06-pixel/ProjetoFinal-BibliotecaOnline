public class Main {
    public static void main(String[] args) {

        System.out.println("====== INICIANDO TESTES DO SISTEMA LEITORLIVRE ======\n");


        System.out.println("--- Cenário A: Cadastro e Empréstimo Simples ---");
        Leitor leitorComum = new Leitor("Pedro", 14, "COMUM"); 
        Leitor leitorPremium = new Leitor("Ana", 30, "PREMIUM");

        String itemJuvenil = "Harry Potter (Livro)";
        String itemAdulto = "Direito Civil (Livro)";

        if (!leitorComum.temMulta() && !leitorComum.atingiuLimite() && leitorComum.temIdadePermitida("Juvenil")) {
            leitorComum.itensEmprestados.add(itemJuvenil);
            System.out.println("[SUCESSO] Empréstimo de '" + itemJuvenil + "' realizado para " + leitorComum.nome);
        }

        System.out.println("\n--- Cenário B: Limite de Empréstimos Atingido ---");

        leitorComum.itensEmprestados.add("Livro Extra 1");
        leitorComum.itensEmprestados.add("Livro Extra 2");

        System.out.println("Pedro tenta pegar um 4º item...");
        if (leitorComum.atingiuLimite()) {
            System.out.println("[RECUSADO] O sistema recusou o empréstimo. Motivo: O leitor " + leitorComum.nome + " é do tipo " + leitorComum.tipoPerfil + " e já atingiu o limite máximo de 3 itens.");
        }

        System.out.println("\n--- Cenário D: Restrição por Faixa Etária ---");

        System.out.println("Pedro (14 anos) tenta pegar um livro com classificação 'Adulto'...");
        if (!leitorComum.temIdadePermitida("Adulto")) {
            System.out.println("[RECUSADO] O sistema recusou o empréstimo. Motivo: O leitor " + leitorComum.nome + " tem " + leitorComum.idade + " anos e não tem a idade mínima para a classificação Adulto (18+).");
        }

        System.out.println("Ana (30 anos) tenta pegar um livro com classificação 'Infantil'...");
        if (!leitorPremium.temIdadePermitida("Infantil")) {
            System.out.println("[RECUSADO] O sistema recusou o empréstimo. Motivo: O leitor " + leitorPremium.nome + " tem " + leitorPremium.idade + " anos e a classificação Infantil é exclusiva para menores de 12 anos.");
        }
    }
}