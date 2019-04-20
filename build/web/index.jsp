<%-- 
    Document   : index
    Created on : 04/04/2019, 19:22:21
    Author     : ALUNO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forca</title>
    </head>
    <body>
        <div>
            <h1>Jogo da Forca</h1>
            <h2>Você possui ${ forca.getTentativas() } chances</h2>
            
            <form action="Recomecar" method="get">
                <input type="submit" value="nova palavra">
            </form>

            <c:choose>
                <c:when test="${forca.jogoGanho() == true}">
                    <h3>Você ganhou!!! Parabéns!</h3>
                </c:when>
                <c:when test="${forca.getTentativas() > 0}">
                    <h3>Insira uma letra</h3>
                    <form action="Analisador" method="get">
                        <input type="text" name="letra">
                        <input type="submit" value="tentar">
                    </form>
                </c:when>
                <c:otherwise>
                    <h3>Você perdeu! A palavra era ${ forca.getPalavra() }</h3>
                </c:otherwise>
            </c:choose>
                    
            <table>
                <tr>
                    <c:forEach items="${forca.getAcertos()}" var="letra">
                        <c:out value="${letra}"/>
                    </c:forEach>
                </tr>
            </table>
                    
            <h3> Erros: </h3>
            <c:forEach items="${forca.getErros()}" var="letra">
                <c:out value="${letra}"/>
            </c:forEach>
        </div>
    </body>
</html>
