<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 17/08/2022
  Time: 01:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PERMISO DENEGADO</title>
    <link rel="stylesheet" href="Templates/css/style.css">
    <jsp:include page="Templates/head.jsp"/>
</head>
<body>
<div class="container-fluid ">
    <div class="row">
        <div class="col align-middle">
            <div class="position-absolute top-50 start-50 translate-middle" style="width: 30%">
                <div class="form-register">
                    <h4 id="pete">No cuenta con el permiso necesario para acceder, de ser un error por favor comuniquese con el administrador</h4>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="Templates/footer.jsp"/>
</body>
</html>
