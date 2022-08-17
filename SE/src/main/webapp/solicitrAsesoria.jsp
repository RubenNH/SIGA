<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 12/08/2022
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar pokemon</title>
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
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="get-estudiante">Mis asesorias</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link active" aria-current="page"href="#">Solicitar asesorias</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="#">Mi cuenta</a></li>
                <li class="nav-item" style="margin: 10px;"><a class="nav-link" href="#">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>
<form class="needs-validation" novalidate action="add-asesoria" method="post">
    <div class="container">
        <p>
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#Materias" aria-expanded="false" aria-controls="Materias">
                Selecciona la materia que deseas
            </button>
        </p>
        <c:forEach var="asesoria" items="${asesorias}" varStatus="status">
        <div class="collapse" id="Materias">
            <div class="card card-body">
                <td><c:out value="${asesoria.materias}"/></td>
            </div>
        </div>
        </c:forEach>
    </div>
</form>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')
        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })();
    const handleFileChange = () => {
        let inputFile = document.getElementById("pokemonImg").files;1
        for (let i = 0; i < inputFile.length; i++) {
            let reader = new FileReader();
            reader.onloadend = (result) => {
                let preview = document.getElementById("preview");
                preview.innerHTML = "";
                preview.innerHTML = "<img src='" + result.target.result
                    + "' style='height: 200px;width: auto;'/>";
            }
            reader.readAsDataURL(inputFile[i]);
        }
    }
    $(document).ready(() => {
        document.getElementById("loaderDiv").style.display = "none";
    });
</script>
<jsp:include page="/Templates/footer.jsp"/>
</body>
</html>