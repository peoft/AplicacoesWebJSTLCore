<%-- 
    Document   : substring
    Created on : Oct 4, 2017, 11:56:19 PM
    Author     : peof
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fn" uri="WEB-INF/tlds/cincoimpjstlcoretag_library.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de teste do Substring!</title>
    </head>
    <body>
        <form method="post">            
            Sentença:
            <input type="text" size="20" name="sentenca">
            <p>
            Início:
            <input type="number" size="5" name="inicio">
            <p>
            Fim:
            <input type="number" size="5" name="fim">
            <p>            
            <input type="submit" value="ok">
        </form>              
           
        <c:choose>
            <c:when test="${param.sentenca!=null}">       
              <c:set  var="sentenca" value="${param.sentenca}"/>
              <c:set  var="inicio" value="${param.inicio}"/>
              <c:set  var="fim" value="${param.fim}"/>
              <fn:Substring word="${sentenca}" begin="${inicio}" end="${fim}"/>
             <br />
            </c:when>    
        </c:choose>
    </body>
</html>
