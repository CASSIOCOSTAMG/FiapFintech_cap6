<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuário</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" >
    <link  rel="stylesheet" href="./resources/css/bootstrap.css" >
    <link rel="stylesheet" href="./resources/css/home.css">
 </head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                CADASTRO DE USUARIO
            </div>
            <c:if test="${not empty mensagem}">
                <div class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem} </div>
            </c:if>
            <c:if test="${not empty erro}">
                <div class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}</div>
            </c:if>
            <div class="card-body">
                <form  action="usuario?acao=cadastrar"  method="post">
                    <div class="form-group">
                        <label for="id-nomeusu">Nome</label>
                        <input  type="text" name="nomeusu" id="id-nomeusu" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="id-sobrenomeusu">Sobrenome</label>
                        <input  type="text" name="sobrenomeusu" id="id-sobrenomeusu" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="id-emailusu">Email</label>
                        <input  type="text" name="emailusu" id="id-emailusu" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="id-telefonusu">Telefone</label>
                        <input  type="text" name="telefonusu" id="id-telefonusu" class="form-control" >
                    </div>
                    <div class="form-group">
                        <label for="id-login">Login</label>
                        <input  type="text" name="login" id="id-login" class="form-control" >
                    </div>

                    <div class="form-group">
                        <label for="id-senhausu">Senha</label>
                        <input  type="password" name="senhausu" id="id-senhausu" class="form-control" >
                    </div>

                    <input type="submit"  value="Salvar" class="btn btn-primary mt-3">
                    <a href="index.jsp"  class="btn btn-warning mt-3">Voltar a tela inicial
                    </a>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>