package textoarvore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestaFreqPalavra {

    public static void main(String[] args) {
        leArquivo("original");
    }

    static void leArquivo(String nome) {
        try {
            File arquivoLido = new File(nome + ".txt");
            FileReader fr = new FileReader(arquivoLido);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();//ou builder
            StringBuffer novalinha = new StringBuffer();
            String linha;

            while ((linha = br.readLine()) != null) {
                /*
                
                ARRUMAR A CLASSE 'ABB' ANTES DAQUI
                
                le o arquivo
                adiciona a primeira palavra como raiz
                usa o metodo compareTo pra ver se ta alfabetico e adiciona
                se ja estiver adicionado aumenta contador
                no fim do texto, faz uma lista em ordem alfabetica e com a quantidade de vezes que apareceu cada palavra
                */
            }

        } catch (IOException e) {
            System.out.println("ocorreu um erro ao ler ou compactar o arquivo!");
        }
    }

}
