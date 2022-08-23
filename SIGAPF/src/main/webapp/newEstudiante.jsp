<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 13/08/2022
  Time: 04:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title >NewEstudiante</title>
    <jsp:include page="/Templates/head.jsp"/>
    <link rel="stylesheet" href="Templates/css/style.css">
</head>
<body>
<form class="form-registered needs-validation" novalidate action="add-est" method="post">
    <h4 id="pete">Hola!</h4>
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
    <label class="fw-bold" for="matricula"l>Ingrese su Matricula</label>
    <input class="controls" type="text" name="matricula" id="matricula" placeholder="20248tn047" required>
    <div class="invalid-feedback">
        Campo obligatorio
    </div>
    <label class="fw-bold" for="telefono"l>Ingrese su telefono</label>
    <input class="controls" type="number" name="telefono" id="telefono" placeholder="77742584454" required>

    <label class="fw-bold" for="genero"l>Ingrese su Genero</label>
    <select class="controls" type="text" name="genero" id="genero" placeholder="Genero" required>
        <option value="1">Hombre</option>
        <option value="2">Mujer</option>
        <option value="3">Otro</option>
    </select>

    <div class="input-group mb-3">
        <label class="fw-bold" for="carrera"l>Carrera</label>
        <select class="controls" name="carrera" id="carrera" placeholder="Tipo de usuario" required>
            <option value="1">DSM</option>
            <option value="2">DM</option>
            <option value="3">IRD</option>
            <option value="4">DD</option>
        </select>
        <div class="invalid-feedback">
            Campo obligatorio
        </div>
    </div>
    <div class="input-group mb-3">
        <label class="fw-bold" for="cuatri"l>Cuatrimestre</label>
        <select class="controls" name="cuatri" id="cuatri" placeholder="Tipo de usuario" required>
            <option value="1">Primero</option>
            <option value="2">Segundo</option>
            <option value="3">Tercero</option>
            <option value="4">Cuarto</option>
            <option value=5">Quinto</option>
        </select>
        <div class="invalid-feedback">
            Campo obligatorio
        </div>
    </div>
    <input class="botons" type="submit" value="Registrar" required>
    <p><a href="index.jsp">¿Ya tengo Cuenta?</a></p>
</form>
<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>