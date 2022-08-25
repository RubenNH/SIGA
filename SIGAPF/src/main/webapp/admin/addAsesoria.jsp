<%@ page import="pf.siga.model.users.usersBean" %><%--
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
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="locate-estudiante">Mis asesorias</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="new-asesoria">Solicitar asesorias</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="get-cuentaEst">Mi cuenta</a></li>
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
                    <div class="col-6">PASOS FINALES</div>
                </div>
            </div>
            <div class="card-body">
                <table class="table table-sm table-hover datatable">
                    <thead>
                    <th>Tema</th>
                    <th>Duda</th>
                    <th>Confirmar</th>
                    </thead>
                    <tbody>
                    <tr>
                        <form action="add-asesorias" method="post">
                            <input type="hidden" value="${id}" name="id"/>
                            <td>
                                <input class="form-control" type="text" name="tema" id="tema" placeholder="Escriba el tema" required>
                                <div class="invalid-feedback">
                                    Campo obligatorio
                                </div>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="duda" id="duda" placeholder="Escriba su duda" required>
                                <div class="invalid-feedback">
                                    Campo obligatorio
                                </div>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-outline-success btn-sm">
                                    <i data-feather="trash-2">Listo</i>
                                </button>
                            </td>
                        </form>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>
