
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous"><!-- comment -->

        <title>FORMULARIO</title>
    </head>
    <body class="container">
        <jsp:include page="/nav.jsp"/>
        <h1>PROCESAMIENTO DE TIPOS</h1>
        <form name="frm" action="tipoServlet" method="POST">
            <div class="mb-3">
                <label class="form-label">ID:</label><input class="form-control" type="text" name="id" value="${tipo.id}" />
            </div>
            <div class="mb-3">
                <label class="form-label">NOMBRE:</label><input class="form-control" type="text" name="nombre" value="${tipo.nombre}" />
            </div>
            <div class="mb-3">
                <label class="form-label">CLASE:</label><input class="form-control" type="text" name="clase" value="${tipo.clase}" />
            </div>
            <input type="submit" value="PROCESAR" />
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>

    </body>
</html>
