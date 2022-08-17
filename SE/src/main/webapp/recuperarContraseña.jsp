<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 17/08/2022
  Time: 01:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recuperar Contraseña</title>
    <link rel="stylesheet" href="Templates/css/style.css">
    <jsp:include page="/Templates/head.jsp"/>
</head>
<body>
<div class="container-fluid ">
    <div class="row">
        <div class="col align-middle">
            <div class="position-absolute top-50 start-50 translate-middle" style="width: 30%">
                    <form class="form-register" action="send-email" method="post">
                        <h4 id="pete">Porfavor ingrese su correo y de existir el usuario se le enviara un correo</h4>
                        <div class="form-group mb-3">
                            <label for="username">Usuario</label>
                            <input name="username" placeholder="20213@utez.edu.mx" id="username" class="form-control controls" type="text" required/>
                        </div>
                        <button class="btn btn-secondary btn-sm col-md-12" type="submit">
                            <i data-feather="send"></i> Enviar
                        </button>
                        <a href="index.jsp">volver al inicio</a>
                    </form>
            </div>
        </div>
    </div>
</div>


<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>
