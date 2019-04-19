/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.util.ArrayList;
import java.util.Random;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author ALUNO
 */
public class ListenerSessao implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ArrayList<String> palavras = (ArrayList<String>) se.getSession().getServletContext().getAttribute("palavras");
        Random random = new Random();
        int x = random.nextInt(palavras.size());
        se.getSession().setAttribute("palavraSorteada", palavras.get(x));
        ArrayList<Integer> tentativas = new ArrayList<>();
        se.getSession().setAttribute("tentativas", tentativas);
        ArrayList<String> erros = new ArrayList<>();
        se.getSession().setAttribute("erros", erros);
        int chances = 5;
        se.getSession().setAttribute("chances", chances);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
