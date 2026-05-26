package Acervo;

import Acervo.Item;

import java.util.ArrayList;
import java.util.List;

    public class Unidade {

        private String nome;
        private String bairro;
        private ArrayList<Item> acervo;

        public Unidade(String nome, String bairro) {
            this.nome = nome;
            this.bairro = bairro;
            this.acervo = new ArrayList<>();
        }

        public void adicionarItem(Item item) {
            acervo.add(item);
        }

        public List<Item> listarAcervo() {
            return this.acervo;
        }

        public String getNome() {
            return nome;
        }

        public String getBairro() {
            return bairro;
        }

        public List<Item> getAcervo() {
            return acervo;
        }
    }

