package textoarvore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class TestaFreqPalavra {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hdo";
        System.out.println(s1.compareTo(s2));

        String sb = leArquivo("original");
        List<Frequencia> freq = ListaPalavra(sb);
        
        for (Frequencia frequencia : freq) {
            System.out.printf("%s apareceu %d vezes",frequencia.getPalavra(),frequencia.getFrequencia());
        }
    }

    static String leArquivo(String nome) {
        StringBuilder sb = new StringBuilder();
        try {
            File arquivoLido = new File(nome + ".txt");
            FileReader fr = new FileReader(arquivoLido);
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                sb.append(linha);

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
        return sb.toString();
    }

    //metodo que gera a alista a partir da leitura da arvore PREORDEM
    private static List<Frequencia> ListaPalavra(String sb) {
        ABB abb = insereArvore(sb);
        List<Frequencia> freq = new ArrayList<Frequencia>();
        abb.listarFrequencia(freq);

        return freq;
    }

    private static ABB insereArvore(String sb) {
        ABB abb = new ABB();
        String[] palavras = sb.split(" /,.-+=@/*$%()&'");
        for (String palavra : palavras) {//adiciona as palavras na arvore, e o metodo insere ja incrementa caso exista
            abb.insere(palavra);
        }
        return abb;
    }
}
