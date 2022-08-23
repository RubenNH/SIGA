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
  <jsp:include page="Templates/head.jsp"/>
</head>
<body>
<div class="container-fluid ">
  <div class="row">
    <div class="col align-middle">
      <div class="position-absolute top-50 start-50 translate-middle" style="width: 30%">
        <div class="form-register">
          <h4 id="pete">Porfavor ingrese el tipo de usuario que deseas registrar</h4>
          <div class="d-grid gap-2">
            <a href="newEstudiante.jsp" class="btn btn-primary btn-sm"><i data-feather="edit">Estudiante</i></a> <br>
            <a href="newDocente.jsp" class="btn btn-primary btn-sm"><i data-feather="edit">Docente</i></a> <br><br>
            <a href="index.jsp">volver al inicio</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="Templates/footer.jsp"/>
</body>
</html>
