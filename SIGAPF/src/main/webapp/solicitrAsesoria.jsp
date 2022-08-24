<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 18/08/2022
  Time: 05:50 PM
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
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="locate-estudiante">Mis asesorias</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="solicitrAsesoria.jsp">Solicitar asesorias</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link active" aria-current="page" href="#">Mi cuenta</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="index.jsp">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>
<form class="form-registered needs-validation" novalidate action="add-doc" method="post">

<div class="row">
    <div class="col-12">
        <c:if test="${param['result']}">
            <p><c:out value="${param['message']}"></c:out></p>
        </c:if>
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col-6">ASESORIAS</div>
                </div>
            </div>
            <div class="card-body">
                    <input class="form-text" type="text" name="tema" id="tema" placeholder="Ingrese su tema" required>
                    <div class="invalid-feedback">
                        Campo obligatorio
                    </div>
                    <input class="form-text" type="text" name="duda" id="duda" placeholder="duda" required>
                    <div class="invalid-feedback">
                        Campo obligatorio
                    </div>
                    <label class="fw-bold" for="matricula"l>Ingrese su Matricula</label>
                    <input class="controls" type="text" name="matricula" id="matricula" placeholder="20248tn047" required>
                    <div class="invalid-feedback">
                        Campo obligatorio
                    </div>
                    <label class="fw-bold" for="profe"l>Ingrese su profe</label>
                    <input class="controls" type="text" name="profe" id="profe" placeholder="profe" required>

                    <label class="fw-bold" for="genero"l>Ingrese su Genero</label>
                    <select class="controls" type="text" name="genero" id="genero" placeholder="Genero" required>
                        <c:forEach var="asesoria" items="${asesoris}" varStatus="status">
                        <option value="${asesoria.materias}">${asesoria.materias}</option>
                        </c:forEach>
                    </select>
            </div>
        </div>
    </div>
</div>
</form>

<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>
