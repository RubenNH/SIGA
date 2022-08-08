<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 07/08/2022
  Time: 02:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Menu</title>
    <jsp:include page="../../Templates/head.jsp"/>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark" id="navbar" style="background-color:  #002E60;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="" alt="" width="50">
        </a>
        <h6 style="margin: 20px; color: aliceblue; font-family: 'Karla', sans-serif; ">SIGA</h6>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item" style="margin: 10px;"><a class="nav-link active" aria-current="page" href="#">Control</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="#">Historiales</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="#">Estadisticas</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="#">Mi cuenta</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="../../index.jsp">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>

<jsp:include page="./../../Templates/footer.jsp"/>
</body>
</html>