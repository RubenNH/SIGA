<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 07/08/2022
  Time: 02:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title >Formulario Registro</title>
    <jsp:include page="../../Templates/head.jsp"/>
    <link rel="stylesheet" href="../../Templates/css/style.css">
</head>
<body>
<form class="form-registered needs-validation" novalidate action="add-user" method="post">
    <h4 id="pete">Registrarse</h4>
    <input class="controls" type="email" name="correo" id="correo" placeholder="Ingrese su Correo" required>
    <div class="invalid-feedback">
        Campo obligatorio
    </div>
    <input class="controls" type="password" name="passwd" id="passwd" placeholder="Ingrese su Contraseña" required>
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
    <input class="controls" type="text" name="Usuario" id="Usuario" placeholder="Tipo de usuario" list="l1sa" required>
    <datalist id="l1sa" name="Carrera">
        <option>Docente</option>
        <option>Estudiante</option>
    </datalist>
    <div class="invalid-feedback">
        Campo obligatorio
    </div>
    <input class="botons" type="submit" value="Registrar" required>
    <p><a href="Login.html">¿Ya tengo Cuenta?</a></p>
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
<jsp:include page="./../../Templates/footer.jsp"/>
</body>
</html>
