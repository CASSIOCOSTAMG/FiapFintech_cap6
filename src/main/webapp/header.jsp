
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/header.css">
</head>
<nav class="navbar navbar-expand-lg navbar bg-white">
    <a class="navbar-brand"  style="color: #000;" href="#">Fintech</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item" style="color: #000;">
                <a class="nav-link"  style="color: #000;" href="#">Home</a>
            </li>
            <li class="nav-item" style="color: #000;">
                <a class="nav-link" aria-current="page" style="color: #000;" href="lancamento?acao=abrir-form-cadastro">Lan&ccedil;amento</a>
            </li>
            <li class="nav-item" style="color: #000;">
                <a class="nav-link" aria-current="page" style="color: #000;" href="lancamento?acao=listar">Listar</a>
            </li>
            <li class="nav-item" style="color: #000;">
                <a class="nav-link" aria-current="page"  style="color: #000;" href="usuario?acao=listar">Usu&aacute;rio</a>
            </li>
        </ul>
        <form class="form-inline login-form">
            <div class="col">
                <c:if test="${not empty user}">
                <span class="navbar-text" style="color: #000;" >
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
</html>