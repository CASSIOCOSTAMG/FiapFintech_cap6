<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fintech</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="#">Fintech</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Lançamentos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Listar Lançamentos</a>
            </li>
        </ul>
        <!-- Login form na navbar -->
        <form class="form-inline login-form">
            <div class="col">
                <c:if test="${not empty user}">
                <span class="navbar-text" >
                        ${user}
                </span>
                </c:if>
            </div>
            <div class="col">
                <a href="login" class="btn btn-outline-primary my-2 my-sm-0">Sair</a>
            </div>
        </form>
    </div>
</nav>
<!-- Mensagem de boas-vindas -->
<div class="container text-center">
    <div class="welcome-message">Bem-vindos!</div>
</div>
</body>
</html>