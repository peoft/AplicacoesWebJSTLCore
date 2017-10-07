<%-- 
    Document   : indexof
    Created on : Oct 4, 2017, 11:55:21 PM
    Author     : peof
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fn" uri="WEB-INF/tlds/cincoimpjstlcoretag_library.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de teste do IndexOf!</title>
    </head>
    <body>
        <form method="post">            
            Sentença:
            <input type="text" size="20" name="sentenca">
            <p>
            Procurar por:
            <input type="text" size="10" name="procurar">
            <p>            
            <input type="submit" value="ok">
        </form>              
           
        <c:choose>
            <c:when test="${param.sentenca!=null}">       
              <c:set  var="sentenca" value="${param.sentenca}"/>
              <c:set  var="procurar" value="${param.procurar}"/>
              <fn:IndexOf sentence="${sentenca}" search="${procurar}"/>
             <br />
            </c:when>    
        </c:choose>
    </body>
</html>
