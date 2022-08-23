<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 19/08/2022
  Time: 01:09 AM
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
                <li class="nav-item" style="margin: 10px;"><a class="nav-link active" aria-current="page" href="#">Asesorias pendientes</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="historial-docente">Historial</a></li>
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
                    <div class="col-6">ASESORIAS PENDIENTES</div>
                </div>
            </div>
            <div class="card-body">
                <table class="table table-sm table-hover datatable">
                    <thead>
                    <th>Tema</th>
                    <th>Duda</th>
                    <th>Materia</th>
                    <th>Alumno</th>
                    <th>Tiempo de asesoria</th>
                    <th>Estado</th>
                    <th>Registrar</th>
                    <th>Rechazar</th>
                    </thead>
                    <tbody>
                    <c:forEach var="asesoria" items="${asesoris}" varStatus="status">
                        <tr>
                            <td><c:out value="${asesoria.tema}"></c:out></td>
                            <td><c:out value="${asesoria.duda}"/></td>
                            <td><c:out value="${asesoria.materias}"/></td>
                            <td><c:out value="${asesoria.alumno}"/></td>
                                <form action="add-estado" method="post">
                                    <input type="hidden" value="${asesoria.idAsesorias}" name="id"/>
                            <td>
                                <select class="form-select form-select-sm" name="time" id="time">
                                    <option value="0">Ninguno</option>
                                    <option value="15">15 Min.</option>
                                    <option value="30">30 Min.</option>
                                    <option value="45">45 Min.</option>
                                    <option value="60">1 Hora</option>
                                </select>
                            </td>
                            <td>
                                <select class="form-select form-select-sm" name="estado" id="estado">
                                    <option value="1" disabled>Pendiente</option>
                                    <option value="2">Impartida</option>
                                    <option value="3">Falta</option>
                                    <option value="6">Retardo</option>
                                </select>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-outline-success btn-sm">
                                    <i data-feather="trash-2">Listo</i>
                                </button>
                            </td>
                            </form>
                            <td>
                                <a href="get-rechazo?id=${asesoria.idAsesorias}" name="id" class="btn btn-warning
                                    btn-sm"><i data-feather="trash-2">Rechazar</i></a>
                            </td>
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
