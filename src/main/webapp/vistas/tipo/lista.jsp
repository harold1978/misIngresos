
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRINCIPAL</title>
    </head>
    <body>
        <h1>TIPOS TRANSACION</h1>
        <a href="tipoServlet?accion=agregar">NUEVO</a>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>CLASE</th>
                    <th>COMANDOS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${lista}">
                    <tr>
                        <td>${item.getId()}</td>
                        <td>${item.getNombre()}</td>
                        <td>${item.getClase()}</td>
                        <td>
                            <a href="tipoServlet?accion=editar&id=${item.getId()}">EDITAR</a>
                            <a href="tipoServlet?accion=eliminar&id=${item.getId()}">ELIMINAR</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>


    </body>
</html>
