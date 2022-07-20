<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title >Formulario Registro</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="templates/css/bootstrap.min.css">
    <link rel="stylesheet" href="templates/css/style.css">
</head>
<body>
    <section class="form-register">
        <h4 id="pete">Inicio de Sesión</h4>
        <form class="needs-validation" novalidate action="add-pokemon" method="post">
            <input class="controls" type="email" name="correo" id="correo" placeholder="Ingrese su Correo" required>
            <div class="invalid-feedback">
                Coloca un correo valido
            </div>
            <input class="controls" type="password" name="passwd" id="passwd" placeholder="Ingrese su Contraseña" required>
            <div class="invalid-feedback">
                Campo obligatorio
            </div>
            <input class="botons" type="submit" value="Iniciar Sesión">
        </form>
        <div>
            <p><a href="views/Seguridad/tipoUsr.jsp">¿No tienes Cuenta?</a></p>
            <p><a href="views/Seguridad/recPasswd.jsp">¿Olvidaste tu contraseña?</a></p>
            <p><a href="views/Seguridad/cprA">ADMINISTRACION</a></p>
            <a href="get-pokemons"></a>
        </div>

    </section>
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
    <script src="templates/js/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="templates/js/bootstrap.min.js" integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous"></script>
</body>
</html>