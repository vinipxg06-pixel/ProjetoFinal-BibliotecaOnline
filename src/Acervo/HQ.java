package Acervo;

public class HQ extends Item {

    private String volume;

    public HQ(String titulo, int anoLacamento, String isbn,FaixaEtaria faixaEtaria, String volume) {
        super(titulo,anoLacamento,isbn, faixaEtaria);
        this.volume = volume;
    }




}
