import Leitores.Leitor;
import Leitores.LeitorComum;
import Leitores.LeitorPremium;
import Acervo.HQ;
import Acervo.Livro;
import Acervo.Revista;
import Acervo.FaixaEtaria;
import Finanças.Emprestimo;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("//   INICIANDO SISTEMA LEITORLIVRE   //");

        System.out.println("-----Cenário A: Cadastro e empréstimo simples");

        Unidade unidadePrimeira = new Unidade();
        Unidade unidadeSegunda = new Unidade();
        System.out.println("CADASTRO: 2 Unidades criadas com sucesso.");

        Livro livro1 = new Livro("Livro", 1899, "978-85", "UM", FaixaEtaria.LIVRE);
        Revista revista1 = new Revista("Revista", 2026, "ISSN-123","Abril", FaixaEtaria.ADULTO);
        HQ hq1 = new HQ("HQ", 1987, "978-14", "UM", FaixaEtaria.JUVENIL);
        Livro livroInfantil = new Livro("Borboletinha", 2013, "978-20", "UM", FaixaEtaria.INFANTIL);
        System.out.println("ACERVO: 4 Itens cadastrados com sucesso.");

        Leitor pedro = new LeitorComum("Pedro", 14);
        Leitor julia = new LeitorPremium("Julia", 30);
        System.out.println("LEITORES: " + pedro.getNome() + " (Comum) e " + julia.getNome() + " (Premium) cadastrados.");

        System.out.println("Realizando empréstimo válido para " + pedro.getNome() + "...");
        int emprestimosPedro = 0;
        if (pedro.idadePermitida("JUVENIL")) {
            Emprestimo empPedro = new Emprestimo(pedro, "Batman", "HQ");
            System.out.println("SUCESSO: " + pedro.getNome() + " realizou o empréstimo.");
        }

        System.out.println("Realizando empréstimo válido para " + julia.getNome() + "...");
        int emprestimosJulia = 0;
        if (julia.idadePermitida("LIVRE")) {
            Emprestimo empJulia = new Emprestimo(julia, "Tartarugas", "LIVRO");
            System.out.println("SUCESSO: " + julia.getNome() + " realizou o empréstimo.");
        }

        System.out.println("====================================================================");


        System.out.println("-----Cenário B: Limite de Empréstimos Atingido");
        emprestimosPedro = 3;
        System.out.println(pedro.getNome() + " já possui " + emprestimosPedro + " empréstimos ativos.");
        System.out.println("Tentando realizar o empréstimo de mais um livro para " + pedro.getNome() + "...");

        if (pedro.emprestar(emprestimosPedro + 1)) {
            Emprestimo empExcedente = new Emprestimo(pedro, "Aquele", "LIVRO");
            System.out.println("SUCESSO: Empréstimo realizado.");
        } else {
            System.out.println("RECUSADO: Operação negada! Motivo: O leitor atingiu o limite de " + pedro.getLimiteEmprestimo() + " empréstimos ativos.");
        }
        System.out.println("====================================================================");


        System.out.println("-----Cenário C: Prazos Diferenciados do Premium");
        System.out.println("Teste com Leitor Comum (Pedro):");
        Emprestimo empLivroComum = new Emprestimo(pedro, "Dom Casmurro", "LIVRO");
        Emprestimo empRevistaComum = new Emprestimo(pedro, "Revista Veja", "REVISTA");

        System.out.println("Prazo do Livro para Comum (Esperado: 14 dias): " + empLivroComum.getDataLimite());
        System.out.println("Prazo da Revista para Comum (Esperado: 7 dias): " + empRevistaComum.getDataLimite());

        System.out.println("Teste com Leitor Premium (Júlia):");
        Emprestimo empLivroPremium = new Emprestimo(julia, "O Alquimista", "LIVRO");
        Emprestimo empRevistaPremium = new Emprestimo(julia, "Revista Época", "REVISTA");
        Emprestimo empHqPremium = new Emprestimo(julia, "Batman: Ano Um", "HQ");

        System.out.println("Prazo do Livro para Premium (Esperado: 21 dias): " + empLivroPremium.getDataLimite());
        System.out.println("Prazo da Revista para Premium (Esperado: 11 dias devido ao arredondamento): " + empRevistaPremium.getDataLimite());
        System.out.println("Prazo da HQ para Premium (Esperado: 15 dias): " + empHqPremium.getDataLimite());
        System.out.println("====================================================================");

        System.out.println("-----Cenário D: Restrição por Faixa Etária");

        System.out.println(pedro.getNome() + " (14 anos) tenta pegar um item com classificação Adulto...");
        if (!pedro.idadePermitida("Adulto")) {
            System.out.println("[RECUSADO] Operação recusada. Motivo: Idade inadequada para a classificação do item.");
        }
        System.out.println(julia.getNome() + " (30 anos) tenta pegar um item com classificação Infantil...");
        if (!julia.idadePermitida("Infantil")) {
            System.out.println("[RECUSADO] Operação recusada. Motivo: Idade acima do permitido para a classificação Infantil (Máx: 11 anos).");
        } else {
            System.out.println("[SUCESSO] Empréstimo autorizado.");
        }
        System.out.println("====================================================================");


        System.out.println("-----Cenário E: Devolução com Atraso");
        Emprestimo empAtrasado = new Emprestimo(pedro,"Ablabla", "LIVRO");
        LocalDate dataDevolucaoComAtraso = empAtrasado.getDataLimite().plusDays(4);
        System.out.println("Simulando devolução realizada na data: " + dataDevolucaoComAtraso + " (4 dias de atraso)");

        empAtrasado.devolver(dataDevolucaoComAtraso);

        System.out.println("Verificando situação de " + pedro.getNome() + " após a devolução com atraso:");
        System.out.println("Multa pendente no cadastro: R$ " + pedro.getMultaPendente());
        System.out.println("Tentando realizar um NOVO empréstimo com a multa ativa...");

        int novosEmprestimosPedro = 0;
        if (pedro.emprestar(novosEmprestimosPedro)) {
            System.out.println("[SUCESSO] Novo empréstimo autorizado.");
        } else {
            if (pedro.possuiMulta()) {
                System.out.println("[RECUSADO] Empréstimo negado pelo sistema. Motivo: O leitor " + pedro.getNome() +
                        " possui uma multa pendente de R$ " + pedro.getMultaPendente() + " e está bloqueado.");
            }
        }
        System.out.println("====================================================================");

        System.out.println("-----Cenário F: Renovação");
        System.out.println("Tentando renovar a Revista de " + pedro.getNome() + "...");
        empRevistaComum.renovar();

        System.out.println("Tentando a primeira renovação do Livro de " + pedro.getNome() + "...");
        empLivroComum.renovar();

        System.out.println("Tentando a segunda renovação do mesmo Livro...");
        empLivroComum.renovar();
        System.out.println("====================================================================");


        System.out.println("-----Cenário G: Extrato de Empréstimos");
        Emprestimo emp1EmDia = new Emprestimo(julia, "blabla (Livro)", "LIVRO");
        Emprestimo emp2Atrasado = new Emprestimo(julia, "bleble (Livro)", "LIVRO");
        Emprestimo emp3Renovado = new Emprestimo(julia, "blibli (Livro)", "LIVRO");
        LocalDate dataHoje = LocalDate.now();
        emp3Renovado.renovar();

        System.out.println("EXTRATO DE EMPRÉSTIMOS ATIVOS");
        System.out.println("Leitora: " + julia.getNome() + " | Perfil: Premium (Limite: " + julia.getLimiteEmprestimo() + " itens)");

        System.out.println("Item: " + emp1EmDia.getNomeItem());
        System.out.println("Data Limite: " + emp1EmDia.getDataLimite());
        System.out.println("Situação: EM DIA (Pode renovar)");
        System.out.println("--------------------------------------------------------------------");

        System.out.println("Item: " + emp2Atrasado.getNomeItem());
        System.out.println("Data Limite: " + dataHoje.minusDays(2) + " (Vencido)");
        System.out.println("Situação: ATRASADO (Bloqueia novos empréstimos)");
        System.out.println("--------------------------------------------------------------------");

        System.out.println("Item: " + emp3Renovado.getNomeItem());
        System.out.println("Data Limite: " + emp3Renovado.getDataLimite());
        System.out.println("Situação: RENOVADO (Atingiu o limite de renovações)");
        System.out.println("====================================================================");

        System.out.println("FIM DOS TESTES DO SISTEMA");
    }
}