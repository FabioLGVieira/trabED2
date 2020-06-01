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
 
        String sb = leArquivo("original"); // ARQUIVO ORIGINAL 
        List<Frequencia> freq = ListaPalavra(sb); // CHAMA O MÉTODO LISTA PALAVRA PASSANDO SB(ARQUIVO)
        EscreveArquivo("listaFrequencia", freq); // ESCREVE NO ARQUIVO 
    }

    static void EscreveArquivo(String novoNome, List<Frequencia> frequencia) {
        File arquivo = new File(novoNome + ".txt");
        FileWriter escritor;
        try {
            escritor = new FileWriter(arquivo);
            for (Frequencia freq : frequencia) {
                String linha = String.format("%s -> apareceu %d %s\n",
                        freq.getPalavra(), freq.getFrequencia(), ((freq.getFrequencia() > 1) ? "vezes" : "vez"));
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
            }

        } catch (IOException e) {
            System.out.println("ocorreu um erro ao ler ou compactar o arquivo!");
        }
        return sb.toString();
    }

    //metodo que gera a alista a partir da leitura da arvore PREORDEM
    private static List<Frequencia> ListaPalavra(String sb) { //
        ABB abb = StringToArvore(sb); // CHAMA O MÉTODO StringToArvore PASSANDO A STRING SB (ARQUIVO)
        List<Frequencia> freq = new ArrayList<Frequencia>(); // CRIA UMA LISTA DO OBJETO FREQUENCIA 
        abb.listarFrequencia(freq); // RETORNA UMA LISTA COM TODOS OS ELEMENTOS DA ARVORE 

        return freq; // RETORNA A LISTA PARA O MAIN
    }

    private static ABB StringToArvore(String sb) {
        ABB abb = new ABB(); // ARVORE BINÁRIA (OBJETO)
        String[] palavras = sb.split("([ \\/,.\\-+=@*$%()!&']){1,5}"); // DIVIDIR EM UM VETOR DE PALAVRAS 
        for (String palavra : palavras) {//ENQUANTO TIVER PALAVRAS NO VETOR INSERE NA ARVORE 
            abb.insere(palavra); // INSERE A PALAVVRA QUE ESTÁ NO VETOR NA ARVORE 
        }
        return abb; // RETORNA A ARVORE PARA O LISTAPALAVRA
    }
}
