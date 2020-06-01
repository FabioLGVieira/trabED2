// VE QUANTAS VEZES A PALAVRA APARECE
package textoarvore;

public class Frequencia { //struct

    private String palavra;
    private int frequencia;

    Frequencia(String palavra, int freq) {
        this.palavra = palavra;
        this.frequencia = freq;
    }

    public String getPalavra() {
        return palavra;
    }

    public int getFrequencia() {
        return frequencia;
    }
}
