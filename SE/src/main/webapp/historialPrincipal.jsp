<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 14/08/2022
  Time: 06:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
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
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="admin.jsp">Inicio pendientes</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link active" aria-current="page" href="#">Historial</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="usuarios.jsp">Usuarios</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="index.jsp">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>
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
                <table class="table table-sm table-hover datatable">
                    <thead>
                    <th>#</th>
                    <th>Tema</th>
                    <th>Duda</th>
                    <th>Materia</th>
                    <th>Profesor</th>
                    </thead>
                    <tbody>
                    <c:forEach var="asesoria" items="${asesorias}" varStatus="status">
                        <tr>
                            <td><c:out value="${status.count}"></c:out></td>
                            <td><c:out value="${asesoria.tema}"></c:out></td>
                            <td><c:out value="${asesoria.duda}"/></td>
                            <td><c:out value="${asesoria.materias}"/></td>
                            <td><c:out value="${asesoria.profesores}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<form action="delete-hist" method="post">
    <button type="submit" class="btn btn-danger btn-sm">
        <i data-feather="trash-2">Cancelar</i>
    </button>
</form>
<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>