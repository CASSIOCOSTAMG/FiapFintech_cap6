<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuário</title>
    <meta name="viewport"  content="width=device-width, initial-scale=1.0">
    <link  rel="stylesheet" href="./resources/css/bootstrap.css" >
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                EDIÇÃO DE USUÁRIO
            </div>
            <c:if test="${not empty mensagem}">
                <div
                        class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem}
                </div>
            </c:if>
            <c:if test="${not empty erro}">
                <div
                        class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}
                </div>
            </c:if>
            <div class="card-body">
                <form  action="usuario" method="post">

                    <input  type="hidden" value="editar" name="acao" >
                    <input  type="hidden" value="${usuario.codusu}" name="codigo" >
                    <div class="form-group">
                        <label for="id-nomeusu">Nome</label>
                        <input type="text" name="nomeusu" id="id-nomeusu" class="form-control" value="${usuario.nomeusu}" >
                    </div>
                    <div class="form-group">
                        <label for="id-sobrenomeusu">Sobrenome </label>
                        <input type="text" name="sobrenomeusu" id="id-sobrenomeusu" class="form-control" value="${usuario.sobrenomeusu}" >
                    </div>
                    <div class="form-group">
                        <label for="id-emailusu">E-mail </label>
                        <input type="text" name="emailusu" id="id-emailusu" class="form-control" value="${usuario.emailusu}" >
                    </div>
                    <div class="form-group">
                        <label for="id-telefonusu">Telefone </label>
                        <input type="text" name="telefonusu" id="id-telefonusu" class="form-control" value="${usuario.telefonusu}" >
                    </div>
                    <div class="form-group">
                        <label for="id-login">Login</label>
                        <input type="text" name="login" id="id-login" class="form-control" value="${usuario.login}" >
                    </div>
                    <input  type="submit" value="Salvar"  class="btn btn-primary mt-3">
                    <a href="usuario?acao=listar" class="btn btn-warning mt-3">Cancelar </a>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>