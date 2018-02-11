<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de produtos</title>
</head>
<body>
	<h1>Listagem de produtos</h1>

    <table class="table table-striped table-bordered table-hover">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produto" items="${produtoList}">
                <tr>
                    <td>${produto.nome}</td>
                    <td>${produto.valor}</td>
                    <td>${produto.quantidade}</td>
	                <td><a href="<c:url value="/produto/remove?produto.id=${produto.id}"/>">Remover</a></td>
                </tr>        
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/produto/formulario'/>">
    	Adicionar mais produtos!
	</a>
	<div class="alert alert-success">${mensagem}</div>
	<a href="<c:url value='/produto/listaJson'/>">Lista em JSON</a><br/>
	<a href="<c:url value='/produto/listaXML'/>">Lista em XML</a>
</body>
</html>