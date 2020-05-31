package textoarvore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class TestaFreqPalavra {

    public static void main(String[] args) {

        String sb = leArquivo("original");
        List<Frequencia> freq = ListaPalavra(sb);
        EscreveArquivo("listaFrequencia", freq);
    }

    static void EscreveArquivo(String novoNome, List<Frequencia> frequencia) {
        File arquivo = new File(novoNome + ".txt");
        FileWriter escritor;
        try {
            escritor = new FileWriter(arquivo);
            for (Frequencia freq : frequencia) {
                String linha = String.format("%s -> apareceu %d %s\n",
                        freq.getPalavra(), freq.getFrequencia(), ((freq.getFrequencia() > 1) ? "vez" : "vezes"));
                escritor.append(linha);
            }
            escritor.close();
        } catch (IOException ex) {
            System.out.println("ocorreu um erro ao escrever arquivo!");
        }
    }

    static String leArquivo(String nome) {
        StringBuilder sb = new StringBuilder();
        try {
            File arquivoLido = new File(nome + ".txt");
            FileInputStream fis = new FileInputStream(arquivoLido);
            InputStreamReader inputSR = new InputStreamReader((InputStream) fis, "UTF-8");
            BufferedReader br = new BufferedReader(inputSR);

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
        ABB abb = StringToArvore(sb);
        List<Frequencia> freq = new ArrayList<Frequencia>();
        abb.listarFrequencia(freq);

        return freq;
    }

    private static ABB StringToArvore(String sb) {
        ABB abb = new ABB();
        String[] palavras = sb.split("([ \\/,.\\-+=@*$%()!&']){1,5}");
        for (String palavra : palavras) {//adiciona as palavras na arvore, e o metodo insere ja incrementa caso exista
            abb.insere(palavra);
        }
        return abb;
    }
}
