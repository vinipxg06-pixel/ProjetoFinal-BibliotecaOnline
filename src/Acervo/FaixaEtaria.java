package Acervo;

public enum FaixaEtaria {
    INFANTIL(0, 11 ),
    JUVENIL(12, 17),
    ADULTO(18, Integer.MAX_VALUE);

    private final int idadeMinima;
    private final int idadeMaxima;

    FaixaEtaria(int idadeMinima, int idadeMaxima) {
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
    }

}
