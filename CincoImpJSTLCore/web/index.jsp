<%@ taglib prefix="fn" uri="WEB-INF/tlds/cincoimpjstlcoretag_library.tld"%>
<html>
 <head>
    <title>Custom Tags in JSP Example</title>
 </head>
 <body>
     <fn:Split sentence="teste-caroo" delimiter="-"/>
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
     <fn:Contains sentence="teste do xml com indice" word="com"/>
     <fn:Contains sentence="teste do xml com indice" word="comercio"/>
     <fn:Trim sentence=" "/>
     <fn:Trim sentence="e "/>
     <fn:Trim sentence="  teste do xml com indice   "/>
     
 </body>
</html>
