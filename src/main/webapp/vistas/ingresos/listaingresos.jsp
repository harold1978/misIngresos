
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous"><!-- comment -->
        <title>PRINCIPAL</title>
    </head>
    <body class="container">
        <jsp:include page="/nav.jsp"/>
        <h2>INGRESO TRANSACION</h2>
        <a class="btn btn-primary btn-sm" href="tipoServlet?accion=agregar">NUEVO</a>
        <div class="table-responsive">
            <table class="table table-hover table-sm">
                <thead >
                <tr>
                    <th>ID</th>
                    <th>DETALLE</th>
                    <th>FECHA</th>
                    <th>MONTO</th>
                    <th>TIPO</th>
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
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    </body>
</html>
