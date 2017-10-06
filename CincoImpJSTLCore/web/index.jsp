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
        
        <!--<fn:Split sentence="teste-caroo" delimiter="-"/>
        <fn:Split sentence="teste-carro*" delimiter="*"/>
        <fn:Split sentence="teste-carro*" delimiter="*-"/>
        <fn:Split sentence="teste-carro*" delimiter="-*"/>
        <fn:IndexOf sentence="teste do xml com indice" search="teste do xml com indice"/>
        <fn:IndexOf sentence="teste do xml com indice" search="xml"/>
        <fn:IndexOf sentence="teste do xml com indice" search="Indice"/>
        <fn:IndexOf sentence="teste do xml com indice" search="indice"/>
        <fn:IndexOf sentence="teste do xml com indice" search="ice"/>
        <fn:IndexOf sentence="teste do xml com indice" search=""/>
        <fn:IndexOf sentence="teste do xml com indice" search="teste do xml com indicexml"/>
        <fn:IndexOf sentence="teste do xml com indice" search="indices"/>
        <fn:Substring word="teste do xml com indice" begin="1" end="4"/>
        <fn:Trim sentence=" "/>
        <fn:Trim sentence="e "/>
        <fn:Trim sentence="  teste do xml com indice   "/>-->

    </body>
</html>
