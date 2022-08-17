<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 14/08/2022
  Time: 06:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar</title>
    <jsp:include page="/Templates/head.jsp"/>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark" id="navbar" style="background-color:  #002E60;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="Templates/img/LOGO.png" alt="" width="60">
        </a>
        <h6 style="margin: 20px; color: aliceblue; font-family: 'Karla', sans-serif; ">SIGA</h6>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item" style="margin: 10px;"><a class="nav-link active" aria-current="page" href="get-estudiante">Mis asesorias</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="#">Solicitar asesorias</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="#">Mi cuenta</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="#">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">ACTUALIZAR ASESORIA</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form class="needs-validation" novalidate action="saveUser" method="post">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="tema">Tema</label>
                                            <input name="tema" id="tema" required
                                                   class="form-control" value="${estudiante.tema}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                            <input type="hidden" name="id" value="${asesoria.idAsesorias}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="duda">Duda</label>
                                            <input name="duda" id="duda" required
                                                   class="form-control" value="${asesoria.duda}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="button" class="btn btn-danger btn-sm">Cancelar</button>
                                            <button type="submit" class="btn btn-warning btn-sm">Actualizar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>
