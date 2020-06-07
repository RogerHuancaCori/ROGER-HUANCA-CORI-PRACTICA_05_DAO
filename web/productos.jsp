<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        
            <h1>GESTIONAR ALMACEN DE PRODUCTOS</h1>
            <p><a href="Servlet_Controlador?action=add">NUEVO PRODUCTO</a></p>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>descripcion</th>
                    <th>stock</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${almacen}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.descripcion}</td>
                        <td>${item.stock}</td>
                        <td><a href="Servlet_Controlador?action=edit&id=${item.id}">Editar</a></td>
                        <td><a href="Servlet_Controlador?action=delete&id=${item.id}"onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </table>
       
    </body>
</html>
