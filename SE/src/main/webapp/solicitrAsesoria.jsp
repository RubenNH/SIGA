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
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">SOLICITAR ASESORIA</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form class="needs-validation" novalidate action="add-pokemon" method="post"
                                  enctype="multipart/form-data">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="pokemon">Nombre</label>
                                            <input name="name" id="pokemon" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="health">Puntos de salud</label>
                                            <input name="health" id="health" required
                                                   class="form-control" type="number"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="type">Tipo</label>
                                            <input name="type" id="type" required
                                                   class="form-control"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="heigth">Estatura</label>
                                            <input name="estatura" id="heigth" required
                                                   class="form-control" type="number"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="power">Puntos de ataque</label>
                                            <input name="damage" id="power" required
                                                   class="form-control" type="number"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="weigth">Peso</label>
                                            <input name="peso" id="weigth" required
                                                   class="form-control" type="number"/>
                                            <div class="invalid-feedback">
                                                Campo obligatio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12">
                                            <label for="pokemonImg">Imagen del pokemon</label>
                                            <input type="file" name="pokemonFile"
                                                   class="form-control form-control-sm"
                                                   onchange="handleFileChange()"
                                                   id="pokemonImg" required accept="image/*"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                            <div id="preview" class="mt-3"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="button" class="btn btn-danger btn-sm">Cancelar</button>
                                            <button type="submit" class="btn btn-success btn-sm">Guardar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
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