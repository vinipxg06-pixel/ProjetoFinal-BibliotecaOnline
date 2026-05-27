package Acervo;

public class HQ extends Item {

    private String volume;

    public HQ(String titulo, int anoLacamento, String isbn, String volume, FaixaEtaria faixaEtaria) {
        super(titulo,anoLacamento,isbn, faixaEtaria);
        this.volume = volume;
    }




}
