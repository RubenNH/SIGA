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
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="locate-docente">Asesorias pendientes</a></li>
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
                    <div class="col-6">RECHAZAR</div>
                </div>
            </div>
            <div class="card-body">
                <table class="table table-sm table-hover datatable">
                    <thead>
                    <th>Razon</th>
                    <th>Listo</th>
                    </thead>
                    <tbody>
                    <form action="rechazar" method="post">
                        <td>
                            <input type="text" class="form-control" name="razon" id="razon" placeholder="Razon de rechazo" required>
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                            <input type="text" value="${id}" name="id"/>
                        </td>
                        <td>
                            <button type="submit" class="btn btn-danger btn-sm">
                                <i data-feather="trash-2">Rechazar</i>
                            </button>
                        </td>
                    </form>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>
