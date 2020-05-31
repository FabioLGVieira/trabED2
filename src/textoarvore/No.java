package textoarvore;

public class No {

    private int cont;
    private String palavra;
    private No esq;
    private No dir;

    public No(String palavra, No esq, No dir) {
        this.cont++;
        this.palavra = palavra;
        this.esq = esq;
        this.dir = dir;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getCont() {
        return cont;
    }

    public No getEsq() {
        return esq;
    }

    public No getDir() {
        return dir;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "No{" + "elemento=" + cont + ", esq=" + esq + ", dir=" + dir + '}';
    }

}
