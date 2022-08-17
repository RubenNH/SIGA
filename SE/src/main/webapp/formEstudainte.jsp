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
<form class="form-registered needs-validation" novalidate action="add-estudiante" method="post">
    <h4 id="pete">Hola!</h4>
    <label class="fw-bold" for="id_Matricula"l>Ingrese su Matricula</label>
    <input class="controls" type="text" name="id_Matricula" id="id_Matricula" placeholder="20248tn047" required>
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
        <label class="fw-bold" for="Fk_Carrera"l>Carrera</label>
        <select class="controls" name="Fk_Carrera" id="Fk_Carrera" placeholder="Tipo de usuario" required>
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
        <label class="fw-bold" for="Fk_Cuatri"l>Cuatrimestre</label>
        <select class="controls" name="Fk_Cuatri" id="Fk_Cuatri" placeholder="Tipo de usuario" required>
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
</body>
</html>