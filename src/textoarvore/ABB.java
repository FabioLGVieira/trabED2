package textoarvore;

import java.util.List;
import textoarvore.Frequencia;

public class ABB {

    private No raiz;

    //Cria uma árvore vazia
    public ABB() {
        this.raiz = null;
    }

    public void insere(String palavra) {
        No pai = null; 
        No p = raiz;
        No novo = new No(palavra, null, null);

        //BUSCA ONDE INSERIR A PALAVRA NA ARVORE 
        while (p != null) {
            pai = p;
            
            // COMPARA A PALAVRA INSERIDA COM CADA NÓ DA ARVORE SE O RESULTADO FOR MENOR QUE 0 VAI PRA 
            //ESQUERDA SE NAO VAI PRA DIREITA SE FOR IGUAL A 0 ELE ADICIONA NO CONTADOR
            if (palavra.compareToIgnoreCase(p.getPalavra()) < 0) { 
                p = p.getEsq(); 
            } else if (palavra.compareToIgnoreCase(p.getPalavra()) > 0) { 
                p = p.getDir();
            } else {
                p.setCont(p.getCont() + 1);
                return;
            }
        }
        
        //INSERE NA ARVORE 
        if (pai == null) {
            raiz = novo;
        } else {
            if (palavra.compareToIgnoreCase(pai.getPalavra()) < 0) {
                pai.setEsq(novo);
            } else {
                pai.setDir(novo);
            }
        }
    }
    

    //MUDAR A LOGICA PARA USAR O INORDEM
    public void listarFrequencia(List<Frequencia> lista) {
        //PERCORRER A ARVORE INORDEM  E ADICIONAR NA LISTA
        listarFrequencia(lista, raiz);
    }

    private void listarFrequencia(List<Frequencia> lista, No p) {

        if (p != null) {
            listarFrequencia(lista, p.getEsq());
            lista.add(new Frequencia(p.getPalavra(), p.getCont()));
            listarFrequencia(lista, p.getDir());
        }
    }

    @Override
    public String toString() {
        return "ABB{" + "raiz=" + raiz + '}';
    }

    public No buscaIt(String palavra) {
        No p = raiz;

        while (p != null) {
            if (palavra.compareTo(p.getPalavra()) == 0) {
                return p; //Achou
            }
            if (palavra.compareTo(p.getPalavra()) > 0) {
                p = p.getEsq();
            } else {
                p = p.getDir();
            }
        }
        return null; //Não achou

    }
}
