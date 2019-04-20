<%-- 
    Document   : index
    Created on : 04/04/2019, 19:22:21
    Author     : ALUNO
--%>

<%@page import="model.Forca"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Forca forca = (Forca) session.getAttribute("forca");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forca</title>
    </head>
    <body>
        <div>
            <h1>Jogo da Forca</h1>
            <h2>Você possui <%= forca.getTentativas() %> chances</h2>
            <%
                if (forca.getTentativas() > 0) {
            %>
            <h3>Insira uma letra</h3>
            <form action="Analisador" method="get">
                <input type="text" name="letra">
                <input type="submit" value="tentar">
            </form>
            <%
            } else {
            %>
            <h3>Você perdeu! A palavra era <%= forca.getPalavra() %></h3>
            <%
                }
            %>
            <table>
                <tr>
                    <%
                        for (int i = 0; i < forca.getPalavra().length(); i++) {
                    %>
                    <td><%= forca.getAcertos()[i] %></td>
                    <%
                        }
                    %>
                </tr>
                <%
                    String todosErros = "";
                    for (int i = 0; i < forca.getErros().length; i++) {
                        todosErros += " " + String.valueOf(forca.getErros()[i]);
                    }
                %>
                <h3> Erros: <%= todosErros %></h3>
            </table>
            <form action="Recomecar" method="get">
                <input type="submit" value="nova palavra">
            </form>
        </div>
    </body>
</html>
