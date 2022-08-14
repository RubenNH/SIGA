<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Iniciar sesión</title>
    <jsp:include page="Templates/head.jsp"/>
    <link rel="stylesheet" href="Templates/css/style.css">
</head>
<body>
<div class="container-fluid form-register">
    <div class="row">
        <div> <h4 id="pete">Inicio de Sesión</h4></div>
        <div>
            <form action="login" method="post">
                <div class="form-group mb-3">
                    <label for="username">Usuario</label>
                    <input name="username" placeholder="20213@utez.edu.mx" id="username" class="controls" type="text" required/>
                </div>
                <div class="form-group mb-3">
                    <label for="password">Contraseña</label>
                    <input type="password" placeholder="**********" id="password" name="password" class="controls" required/>
                </div>
                <button class="btn btn-outline-info botons btn-sm col-md-12" type="submit">INICIAR SESIÓN</button>
            </form>
        </div>
    </div>
    <p><a href="NewUser.jsp">¿No tienes Cuenta?</a></p>
    <p><a href="#">¿Olvidaste tu contraseña?</a></p>
</div>
<jsp:include page="Templates/footer.jsp"/>
</body>
</html>