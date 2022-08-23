<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 19/08/2022
  Time: 01:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>SIGA</title>
  <link rel="stylesheet" href="Templates/css/style.css">
  <jsp:include page="Templates/head.jsp"/>
</head>
<body>
<form class="form-registered needs-validation" novalidate action="add-doc" method="post">
  <h4 id="pete">Registrarse</h4>
  <input class="controls" type="username" name="username" id="username" placeholder="Ingrese su Correo" required>
  <div class="invalid-feedback">
    Campo obligatorio
  </div>
  <input class="controls" type="password" name="password" id="password" placeholder="Ingrese su Contraseña" required>
  <div class="invalid-feedback">
    Campo obligatorio
  </div>
  <input class="controls" type="text" name="nombres" id="nombres" placeholder="Ingrese su Nombre" required>
  <div class="invalid-feedback">
    Campo obligatorio
  </div>
  <input class="controls" type="text" name="apellidos" id="apellidos" placeholder="Apellido" required>
  <div class="invalid-feedback">
    Campo obligatorio
  </div>
  <div class="input-group mb-3">
    <select class="controls" name="estatus" id="estatus" placeholder="Tipo de usuario">
      <option value="1">Estudiante</option>
      <option value="2">Profesor</option>
    </select>
  </div>
  <div class="invalid-feedback">
    Campo obligatorio
  </div>
  <input class="botons" type="submit" value="Registrar" required>
  <p><a href="index.jsp">¿Ya tengo Cuenta?</a></p>
</form>
<jsp:include page="Templates/footer.jsp"/>
</body>
</html>
