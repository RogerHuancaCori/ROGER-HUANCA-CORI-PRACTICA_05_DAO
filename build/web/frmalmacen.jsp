<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
              
       
            <h1>
                <c:if test="${almacen.id == 0}">NUEVO</c:if>
                <c:if test="${almacen.id != 0}">MODIFICAR</c:if> PRODUCTO
            </h1>
            
            <form action="Servlet_Controlador" method="post">
                
                    <input type="hidden" name="id" value="${almacen.id}" />
                
                    <label>descripcion:</label>
                    <input type="text" name="descripcion" value="${almacen.descripcion}"  >
                
                
                    <label>Stock</label>
                    
                    <input type="int" name="stock" value="${almacen.stock}"  >
                
                <button type="submit" >Enviar</button>
            </form>
        
      
    </body>
</html>
