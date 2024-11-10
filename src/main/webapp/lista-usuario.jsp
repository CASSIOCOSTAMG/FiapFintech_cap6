<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fintech</title>
    <meta  name="viewport"  content="width=device-width, initial-scale=1.0"  >
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
    <link rel="stylesheet" href="./resources/css/home.css">
</head>
<%@include file="header.jsp" %>
<body>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">LISTA DE USUÁRIOS</div>
            <div class="card-body">
                <c:if test="${not empty msg }">
                    <div class="alert alert-success">${msg}</div>
                </c:if>
                <c:if test="${not empty erro }">
                    <div class="alert alert-danger">${erro}</div>
                </c:if>
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Sobrenome</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Login</th>
                        <th>Ação</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${usuario}" var="usuario">
                     <tr>
                             <td>${usuario.codusu}</td>
                             <td>${usuario.nomeusu}</td>
                             <td>${usuario.sobrenomeusu}</td>
                             <td>${usuario.emailusu}</td>
                             <td>${usuario.telefonusu}</td>
                             <td>${usuario.login}</td>
                             <td class="text-center">
                                <c:url value="usuario" var="link">
                                    <c:param name="acao" value="abrir-form-edicao"/>
                                    <c:param name="codigo" value="${usuario.codusu }"/>
                                </c:url>
                                <a href="${link}" class="btn btn-primary">Editar</a>

                                <!-- Button trigger modal -->
                                <button
                                        type="button"
                                        class="btn btn-danger"
                                        data-bs-toggle="modal"
                                        data-bs-target="#excluirModal"
                                        onclick="codigoExcluir.value = ${usuario.codusu}"> Excluir</button>

                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a  href="usuario?acao=abrir-form-cadastro"    class="btn btn-primary">Adicionar Usuário </a>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div
        class="modal fade"
        id="excluirModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1  class="modal-title fs-5"  id="exampleModalLabel">
                    Confirmar Exclusão
                </h1>
                <button  type="button"  class="btn-close" data-bs-dismiss="modal"  aria-label="Close">
                </button>
            </div>
            <div class="modal-body" style="color: #000;">
                <h4>Você confirma a exclusão deste usuário?</h4>
                <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
            </div>
            <div class="modal-footer">
                <form action="usuario" method="post">
                    <input  type="hidden"  name="acao" value="excluir">
                    <input  type="hidden" name="codigoExcluir" id="codigoExcluir">
                    <button type="button"  class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
                    <button type="submit" class="btn btn-danger">Sim</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%--    fim modal--%>
<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>