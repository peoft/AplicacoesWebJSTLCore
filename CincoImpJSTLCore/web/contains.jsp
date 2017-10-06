<%-- 
    Document   : contains
    Created on : Oct 4, 2017, 11:25:00 PM
    Author     : peof
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fn" uri="WEB-INF/tlds/cincoimpjstlcoretag_library.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contains Page</title>
    </head>
    <body>
        
        <form method="post">            
            Sentença:
            <input type="text" size="10" name="sentenca">
            <p>
            Palavra:
            <input type="text" size="5" name="palavra">
            <p>            
            <input type="submit" value="ok">

        </form>              
           
   <c:choose>
    <c:when test="${param.sentenca!=null}">       
         <c:set  var="sentenca" value="${param.sentenca}"/>
         <c:set  var="palavra" value="${param.palavra}"/>
         <fn:Contains sentence="${sentenca}" word="${palavra}"/>
        <br />
    </c:when>    
</c:choose>
           
        
    </body>
</html>
