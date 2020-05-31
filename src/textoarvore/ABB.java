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

        //Buscar onde inserir o novo
        while (p != null) {
            pai = p;
            if (palavra.compareTo(p.getPalavra()) > 0) {
                p = p.getEsq();
            } else if (palavra.compareTo(p.getPalavra()) < 0) {
                p = p.getDir();
            } else {
                p.setCont(p.getCont() + 1);
                return;
            }
        }
        //Árvore vazia
        if (pai == null) {
            raiz = novo;
        } else if (palavra.compareTo(p.getPalavra()) > 0) {
            pai.setEsq(novo);
        } else {
            pai.setDir(novo);
        }
    }
/*
    public void insereR(int elemento) {
        No novo = new No(elemento, null, null);
        if (raiz == null) {
            raiz = novo;
        } else {
            insereR(raiz, novo);
        }
    }

    private void insereR(No p, No novo) {
        if (novo.getElemento() < p.getElemento()) {
            if (p.getEsq() == null) {
                p.setEsq(novo);
            } else {
                insereR(p.getEsq(), novo);
            }
        } else if (p.getDir() == null) {
            p.setDir(novo);
        } else {
            insereR(p.getDir(), novo);
        }
    }
*/
    //      MUDAR A LOGICA PARA USAR O PREORDEM COMUM
    public void listarFrequencia(List<Frequencia> lista){
        
        listarFrequencia(lista, raiz);
    }
    
    private void listarFrequencia(List<Frequencia>lista, No p) {
       
        if (p != null){
           listarFrequencia(lista, p.getEsq());
           lista.add(new Frequencia(p.getPalavra(),p.getCont()));
           listarFrequencia(lista, p.getDir());
       }
    }
    
    @Override
    public String toString() {
        return "ABB{" + "raiz=" + raiz + '}';
    }

    /*
    public void preOrdem(){
        preOrdem(raiz);
    }
    
    private void preOrdem(No p) {
       if (p != null){
           System.out.print(p.getElemento() + " ");
           preOrdem(p.getEsq());
           preOrdem(p.getDir());
       }
    }
    
    public void inOrdem(){
        inOrdem(raiz);
    }
    
    private void inOrdem(No p) {
       if (p != null){
           inOrdem(p.getEsq());
           System.out.print(p.getElemento() + " ");
           inOrdem(p.getDir());
       }
    }
    public void posOrdem(){
        posOrdem(raiz);
    }
    
    private void posOrdem(No p) {
       if (p != null){      
           posOrdem(p.getEsq());
           posOrdem(p.getDir());
           System.out.print(p.getElemento() + " ");
       }
    }*/

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
/*
    public No buscaR(int elemento) {
        return buscaR(raiz, elemento);
    }

    private No buscaR(No p, int elemento) {
        if (p == null) {
            return null; //NÃO achou
        }
        if (elemento == p.getElemento()) {
            return p;    //Achou
        }
        if (elemento < p.getElemento()) {
            return buscaR(p.getEsq(), elemento);
        } else {
            return buscaR(p.getDir(), elemento);
        }
    }*/
    /*
    public int contaNos(){
        return contaNos(raiz);
    }
    
    public int contaNos(No p){
        if (p == null)
            return 0;
        return contaNos(p.getEsq()) + contaNos(p.getDir()) + 1;
    }
    
     public int altura(){
        return altura(raiz);
    }
    
    public int altura(No p){
        if (p == null)
            return -1;
        int he = altura(p.getEsq());
        int hd = altura(p.getDir());
        if (he > hd)
            return he + 1;
        else 
            return hd + 1;
    }
    
    public void inOrdemFolhas(){
        inOrdemFolhas(raiz);
    }
    
    private void inOrdemFolhas(No p) {
       if (p != null){
           inOrdemFolhas(p.getEsq());
           if (p.getEsq() == null && p.getDir() == null)
                System.out.print(p.getElemento() + " ");
           inOrdemFolhas(p.getDir());
       }
    }
    
    public No menorIt(){
        No p = raiz;
        
        while (p.getEsq() != null)
            p = p.getEsq();
        
        return p;
    }
    
    public No menor(){
        return menor(raiz);
    }
    public No menor(No p){
        if (p.getEsq() == null)
            return p;
        return menor(p.getEsq());
    }
    
    public No maior(){
        return maior(raiz);
    }
    public No maior(No p){
        if (p.getDir() == null)
            return p;
        return maior(p.getDir());
    }
    
    //Método que remove um nó na ABB
    public No remove(int elemento){
        return remove(raiz,elemento);
    }
    public No remove(No p, int elemento){
        if (p==null)
            return null; //Não achei
        
        if (elemento<p.getElemento())
            p.setEsq(remove(p.getEsq(),elemento));
        else if (elemento>p.getElemento())
            p.setDir(remove(p.getDir(),elemento));
        else {
             //elemento==p.getElemento()
             //Verifica se o elemento será removido tem subárvore esquerda
             if (p.getEsq()!=null){
                //busca o maior na subárvore esquerda
                No aux = maior(p.getEsq());
                //Copia o elemento maior da subarv esq para p
                p.setElemento(aux.getElemento());
                //Remove elemento copiado recursivamente
                p.setEsq(remove(p.getEsq(),aux.getElemento()));
              }
             //Verifica se o elemento será removido tem subárvore direita
               else if (p.getDir()!=null){
                //busca o menor na subárvore direita
                No aux = menor(p.getDir());
                //Copia o elemento menor da subarv dir para p
                p.setElemento(aux.getElemento());
                //Remove elemento copiado recursivamente
                p.setDir(remove(p.getDir(),aux.getElemento()));
                }
               else 
                   //Verifica se é folha
                   return null;
            }
            return p;
        };*/

}
