<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 14/08/2022
  Time: 01:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
  <title>Bienvenido</title>
  <script type="text/javascript">
    function preventBack() {
      window.history.forward();
    }
    setTimeout("preventBack()", 0);

    window.onunload = function() { null };
  </script>
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
        <li class="nav-item" style="margin: 10px;"><a class="nav-link active" aria-current="page" href="#">Inicio pendientes</a></li>
        <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="historialPrincipal.jsp">Historial</a></li>
        <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="usuarios.jsp">Usuarios</a></li>
        <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="index.jsp">Salir</a></li>
      </ul>
    </div>
  </div>
</nav> <br> <br>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-6">
      <div class="card text-center bg-success" style="color: whitesmoke">
        <div class="card-body">
          <h5 class="card-title">Asesorias solicitadas</h5>
          <img src="">
          <p class="card-text">Hombres</p>
          <p class="card-text">Mujeres</p>
          <p class="card-text">Total</p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
      </div>
    </div>
    <div class="col-sm-6">
      <div class="card text-center bg-primary" style="color: whitesmoke">
        <div class="card-body " >
          <h5 class="card-title">Asesorias Impartidas</h5>
          <img src="">
          <p class="card-text">Hombres</p>
          <p class="card-text">Mujeres</p>
          <p class="card-text">Total</p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="Templates/footer.jsp"/>
</body>
</html>