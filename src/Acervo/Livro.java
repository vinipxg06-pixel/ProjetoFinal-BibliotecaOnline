package Acervo;

public class Livro extends Item {

    private String capitulo;

    public Livro(String titulo, int anoLancamento, String isbn, String capitulo, FaixaEtaria faixaEtaria) {
        super(titulo, anoLancamento, isbn, faixaEtaria);
        this.capitulo = capitulo;

    }




}