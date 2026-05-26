package Acervo;

public abstract class Item {
    protected String titulo, isbn;
    protected int anoLancamento;
    protected FaixaEtaria faixaEtaria;
    public Item(String titulo, int anoLancamento, String isbn, FaixaEtaria faixaEtaria) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.isbn = isbn;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
