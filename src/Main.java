public class Main {
    public static void main(String[] args){
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

                System.out.println("\n--- Cenário E: Devolução com Atraso ---");

                Leitor leitorAtrasado = new Leitor("Carlos", 20, "COMUM");

               int diasDeAtraso = 4;
               double valorMultaPorDia = 1.50;
               double multaCalculada = diasDeAtraso * valorMultaPorDia;

               leitorAtrasado.multaPendente = multaCalculada;

               System.out.println("Carlos devolveu um item com " + diasDeAtraso + " dias de atraso.");
        System.out.println("O sistema calculou a multa: " + diasDeAtraso + " dias x R$ 1,50 = R$ " + leitorAtrasado.multaPendente);

        System.out.println("Carlos tenta realizar um novo empréstimo antes de pagar a multa...");
        if (leitorAtrasado.temMulta()) {
            System.out.println("[RECUSADO] O sistema recusou o empréstimo. Motivo: O leitor " + leitorAtrasado.nome + " possui multa pendente de R$ " + leitorAtrasado.multaPendente + " e está bloqueado até quitar.");
        }

        System.out.println("\n--- Cenário F: Renovação de Itens ---");

        String tipoItem1 = "LIVRO";
        String tipoItem2 = "REVISTA";
        int qtdRenovacoesLivro = 0;

        System.out.println("Tentando renovar um Livro pela 1ª vez...");
        if (tipoItem1.equals("LIVRO") && qtdRenovacoesLivro < 1) {
            qtdRenovacoesLivro++;
            System.out.println("[SUCESSO] Livro renovado com sucesso! (Total de renovações: " + qtdRenovacoesLivro + ")");
        }

        System.out.println("Tentando renovar o mesmo Livro pela 2ª vez...");
        if (tipoItem1.equals("LIVRO") && qtdRenovacoesLivro >= 1) {
            System.out.println("[RECUSADO] Não foi possível renovar. Motivo: Livros só podem ser renovados uma única vez.");
        }

        System.out.println("Tentando renovar uma Revista...");
        if (tipoItem2.equals("REVISTA") || tipoItem2.equals("HQ")) {
            System.out.println("[RECUSADO] Não foi possível renovar. Motivo: Revistas e HQs não podem ser renovadas.");
        }


        System.out.println("\n--- Cenário G: Extrato de Empréstimos ---");

        Leitor leitorExtrato = new Leitor("Mariana", 22, "PREMIUM");

        System.out.println("=== EXTRATO DE EMPRÉSTIMOS ATIVOS ===");
        System.out.println("Leitora: " + leitorExtrato.nome + " | Perfil: " + leitorExtrato.tipoPerfil);
        System.out.println("----------------------------------------------------------------");

        System.out.println("- Item: Dom Casmurro (Livro)   | Data Limite: 10/06/2026 | Situação: EM DIA (pode renovar)");
        System.out.println("- Item: Revista Veja           | Data Limite: 24/05/2026 | Situação: ATRASADO");
        System.out.println("- Item: Harry Potter (Livro)   | Data Limite: 01/06/2026 | Situação: EM DIA (já renovado)");
        System.out.println("----------------------------------------------------------------");

        System.out.println("\n====== FIM DOS TESTES DO SISTEMA ======");
            }
        }


