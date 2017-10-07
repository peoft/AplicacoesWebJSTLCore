<%-- 
    Document   : split
    Created on : Oct 4, 2017, 11:56:00 PM
    Author     : peof
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fn" uri="WEB-INF/tlds/cincoimpjstlcoretag_library.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de teste do Split!</title>
    </head>
    <body>
        <form method="post">            
            Sentença:
            <input type="text" size="20" name="sentenca">
            <p>
            Separador:
            <input type="text" size="5" name="separador">
            <p>            
            <input type="submit" value="ok">
        </form>              
           
        <c:choose>
            <c:when test="${param.sentenca!=null}">       
              <c:set  var="sentenca" value="${param.sentenca}"/>
              <c:set  var="separador" value="${param.separador}"/>
              <fn:Split sentence="${sentenca}" delimiter="${separador}"/>
             <br />
            </c:when>    
        </c:choose>    </body>
</html>
