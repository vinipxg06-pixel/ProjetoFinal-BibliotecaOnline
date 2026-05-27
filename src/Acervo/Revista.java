package Acervo;

public class Revista extends Item {

    private String catalogo;

    public Revista(String titulo, int anoLancamento, String isbn,  FaixaEtaria faixaEtaria, Unidade unidade, String catalogo) {
        super(titulo, anoLancamento, isbn, faixaEtaria, unidade);
        this.catalogo = catalogo;
    }
    @Override
    public int getPrazoEmprestimoPadra() {
        return 7;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }
}
