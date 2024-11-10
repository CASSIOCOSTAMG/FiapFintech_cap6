<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>APP FINTECH - Acesso</title>
<link rel="../resources/css/login.css" href="styles.css">
<link rel="stylesheet" href="./resources/css/login.css">
</head>
<body>
<c:if test="${empty user}" >
<form class="form-inline my-lg-0" action="login" method="post">
<div class="login-container">
    <h1>APP FINTECH</h1>
    <h2>Acesso</h2>
    <input type="text" name="login" placeholder="Usuário">
    <input type="password" name="senha" placeholder="Senha">
    <span class="navbar-text text-danger" style="margin-right:10px" >
    ${erro }
    <button type="submit">Acessar</button>
    <div class="alternative-login">Faça Login com outra conta:</div>
    <div class="icons">
        <img src="https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg" alt="Apple">
        <img src="https://upload.wikimedia.org/wikipedia/commons/4/4a/Logo_2013_Google.png" alt="Google">
    </div>
    </c:if>
    <c:if test="${empty user}">
          <h5>Para acessar o sistema, identifique-se!</h5>
    </c:if>
    <c:if test="${not empty user}">
        <h5>Seu login foi efetuado com sucesso!</h5>
    </c:if>
    <button class="register-btn" href="usuario?acao=abrir-form-cadastro">Cadastrar</button>
    <div class="footer-text">By Fintech 2024</div>
</div>
</form>
<script src="./resources/js/bootstrap.bundle.js"></script>
</body>
</html>
