<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 18/08/2022
  Time: 04:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/Templates/head.jsp"/>
</head>
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
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="locate-admin">Inicio</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="get-all">Historial</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link active" aria-current="page" href="#">Profesores nuevos</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="index.jsp">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col-6">TODOS LOS PROFESORES REGISTRADOS</div>
                </div>
            </div>
            <div class="card-body">
                <table class="table table-sm table-hover datatable">
                    <thead>
                    <th>#</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Cuenta</th>
                    <th>Cambiar permiso</th>
                    <th>Confirmar</th>
                    </thead>
                    <tbody>
                    <jsp:useBean id="asesorias" scope="request" type="java.util.List"/>
                    <c:forEach var="asesoria" items="${asesorias}" varStatus="status">
                        <tr>
                            <td><c:out value="${status.count}"></c:out></td>
                            <td><c:out value="${asesoria.profesor}"></c:out></td>
                            <td><c:out value="${asesoria.alumno}"/></td>
                            <td><c:out value="${asesoria.username}"/></td>
                        <form action="dar-permiso" method="post">
                            <input type="hidden" value="${asesoria.idUsers}" name="id"/>
                            <td>
                                <select class="form-select form-select-sm" name="permiso" id="permiso">
                                    <option value="1">Inactivo</option>
                                    <option value="2">Activo</option>
                                </select>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-outline-success btn-sm">
                                    <i data-feather="trash-2">Confirmar</i>
                                </button>
                            </td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>

<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>
