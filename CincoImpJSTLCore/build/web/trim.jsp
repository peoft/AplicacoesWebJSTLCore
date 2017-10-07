<%-- 
    Document   : trim
    Created on : Oct 4, 2017, 11:56:39 PM
    Author     : peof
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fn" uri="WEB-INF/tlds/cincoimpjstlcoretag_library.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de teste do Trim!</title>
    </head>
    <body>
        <form method="post">            
            Sentença:
            <input type="text" size="20" name="sentenca">
            <p>
            <input type="submit" value="ok">
            <p>
        </form>              
           
        <c:choose>
            <c:when test="${param.sentenca!=null}">       
              <c:set  var="sentenca" value="${param.sentenca}"/>
              <fn:Trim sentence="${sentenca}"/>
             <br />
            </c:when>    
        </c:choose>
    </body>
</html>
