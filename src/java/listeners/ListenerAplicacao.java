package listeners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author ALUNO
 */
public class ListenerAplicacao implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Scanner in = new Scanner(System.in);
        //o path total do arquivo que contém a base de palavras
        String path = "C:\\Users\\Victor Oliveira\\Documents\\projetosGitHub\\JogoDaForca\\build\\web\\wordlist_pt_br.txt";
        
        ArrayList<String> palavras = new ArrayList<>();
        try {//leitura do arquivo sendo feita linha por linha
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                palavras.add(linha);
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        // atributo de contexto da aplicação possui todas as palavras salvas
        sce.getServletContext().setAttribute("palavras", palavras);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
