package Acervo;

public class HQ extends Item {

    private String volume;

    public HQ(String titulo, int anoLacamento, String isbn,FaixaEtaria faixaEtaria, Unidade unidade, String volume) {
        super(titulo,anoLacamento,isbn, faixaEtaria, unidade);
        this.volume = volume;
    }

    @Override
    public int getPrazoEmprestimoPadra() {
        return 10;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
