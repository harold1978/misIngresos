
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORMULARIO</title>
    </head>
    <body>
        <h1>PROCESAMIENTO DE TIPOS</h1>
        <form name="frm" action="tipoServlet" method="POST">
            <label>ID:</label><input type="text" name="id" value="" />
            <label>NOMBRE:</label><input type="text" name="nombre" value="" />
            <label>CLASE:</label><input type="text" name="clase" value="" />
            <input type="submit" value="PROCESAR" />
        </form>
        
    </body>
</html>
