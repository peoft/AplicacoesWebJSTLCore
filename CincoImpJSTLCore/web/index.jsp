<%@ taglib prefix="myprefix" uri="WEB-INF/tlds/cincoimpjstlcoretag_library.tld"%>
<html>
 <head>
    <title>Custom Tags in JSP Example</title>
 </head>
 <body>
     <myprefix:Split word="teste-caroo" delimiter="-"/>
     <myprefix:Split word="teste-carro*" delimiter="*"/>
     <myprefix:Split word="teste-carro*" delimiter="*-"/>
     <myprefix:Split word="teste-carro*" delimiter="-*"/>
     <myprefix:IndexOf sentence="teste do xml com indice" search="teste do xml com indice"/>
     <myprefix:IndexOf sentence="teste do xml com indice" search="xml"/>
     <myprefix:IndexOf sentence="teste do xml com indice" search="indice"/>
     <myprefix:IndexOf sentence="teste do xml com indice" search="ice"/>
     <myprefix:IndexOf sentence="teste do xml com indice" search=""/>
     <myprefix:IndexOf sentence="teste do xml com indice" search="teste do xml com indicexml"/>
     <myprefix:IndexOf sentence="teste do xml com indice" search="indices"/>
     <myprefix:Substring word="teste do xml com indice" begin="1" end="4"/>
     
 </body>
</html>
