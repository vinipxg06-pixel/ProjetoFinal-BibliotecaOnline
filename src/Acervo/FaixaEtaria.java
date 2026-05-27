package Acervo;

public enum FaixaEtaria {
    LIVRE(0, Integer.MAX_VALUE),
    INFANTIL(0, 11 ),
    JUVENIL(12, 17),
    ADULTO(18, Integer.MAX_VALUE);

    private final int idadeMinima;
    private final int idadeMaxima;

    FaixaEtaria(int idadeMinima, int idadeMaxima) {
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
    }

    public boolean idadePermitida(int idade){
        if (idade>= idadeMinima && idade<=idadeMaxima){
            return true;
        } else {
            return false;
        }
    }

}
