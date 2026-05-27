package Acervo;

import java.util.SplittableRandom;

public class Livro extends Item {

    private String capitulo;

    public Livro(String titulo, int anoLancamento, String isbn, FaixaEtaria faixaEtaria, Unidade unidade, String capitulo) {
        super(titulo, anoLancamento, isbn, faixaEtaria, unidade);
        this.capitulo = capitulo;
    }
    @Override
    public int getPrazoEmprestimoPadra(){
        return 14;
    }
    public String getCapitulo() {
        return capitulo;
    }
    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }
}