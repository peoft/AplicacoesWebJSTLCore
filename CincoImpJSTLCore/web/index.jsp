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
     
 </body>
</html>
