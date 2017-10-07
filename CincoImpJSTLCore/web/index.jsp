<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
    <head>
        <title>Custom Tags in JSP Example</title>
    </head>
    <body>
        Selecione uma das funções:<p>
        
        <a href="contains.jsp"><c:out value="Contains"/></a><p>
        <a href="indexof.jsp"><c:out value="IndexOf" /></a><p>
        <a href="split.jsp"><c:out value="Split" /></a><p>
        <a href="substring.jsp"><c:out value="Substring" /></a><p>
        <a href="trim.jsp"><c:out value="Trim" /></a><p>
    </body>
</html>
