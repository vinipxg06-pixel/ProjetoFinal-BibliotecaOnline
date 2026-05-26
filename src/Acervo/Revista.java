package Acervo;

public class Revista extends Item {

    private String catalogo;

    public Revista(String titulo, int anoLancamento, String isbn, String catalogo, FaixaEtaria faixaEtaria) {
        super(titulo, anoLancamento, isbn, faixaEtaria);
        this.catalogo = catalogo;
    }


}
