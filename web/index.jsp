<%-- 
    Document   : index
    Created on : 04/04/2019, 19:22:21
    Author     : ALUNO
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String palavra = (String) session.getAttribute("palavraSorteada");
        ArrayList<Integer> tentativas = (ArrayList<Integer>) session.getAttribute("tentativas");
        ArrayList<String> erros = (ArrayList<String>) session.getAttribute("erros");
        Integer chances = (Integer) session.getAttribute("chances");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forca</title>
        
    </head>
    <body>
        <div>
            <h1>Jogo da Forca</h1>
            <h2>Você possui <%=chances%> chances</h2>
            <%
                if (chances > 0) {
            %>
            <h3>Insira uma letra</h3>
            <form action="Analisador" method="get">
                <input type="text" name="letra">
                <input type="submit" value="tentar">
            </form>
            <%
            } else {
            %>
            <h3>Você perdeu! A palavra era <%=palavra%></h3>
            <%
                }
            %>
            <table>
                <tr>
                    <%
                        for (int i = 0; i < palavra.length(); i++) {
                    %>
                    <td>
                        <%
                            if (tentativas.contains(i)) {
                        %>
                        <%=palavra.charAt(i)%>
                        <%
                        } else {
                        %>
                        <h3>_</h3>
                        <%
                            }
                        %>
                    </td>
                    <%
                        }
                    %>
                </tr>
                <%
                    String todosErros = "";
                    for (int i = 0; i < erros.size(); i++) {
                        todosErros += " " + erros.get(i);
                    }
                %>
                <h3> Erros: <%= todosErros%></h3>
            </table>
            <form action="Recomecar" method="get">
                <input type="submit" value="nova palavra">
            </form>
        </div>
    </body>
</html>
