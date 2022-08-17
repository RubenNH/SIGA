<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 13/08/2022
  Time: 03:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title >Formulario Registro</title>
    <jsp:include page="/Templates/head.jsp"/>
    <link rel="stylesheet" href="Templates/css/style.css">
</head>
<body>
<form class="form-registered needs-validation" novalidate action="add-user" method="post">
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
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')
        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
<jsp:include page="/Templates/footer.jsp"/>