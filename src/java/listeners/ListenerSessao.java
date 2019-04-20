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
import model.Forca;

/**
 * Web application lifecycle listener.
 *
 * @author ALUNO
 */
public class ListenerSessao implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //recuperando palavras salvas no contexto de aplicação
        ArrayList<String> palavras = (ArrayList<String>) se.getSession().getServletContext().getAttribute("palavras");
        
        //número aleatório para obter palavra de qualquer lugar do array
        Random random = new Random();
        int x = random.nextInt(palavras.size());
        String palavraSorteada = palavras.get(x);
        
        //cada sessão contará com uma palavra diferente
        Forca forca = new Forca(palavraSorteada);
        se.getSession().setAttribute("forca", forca);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
