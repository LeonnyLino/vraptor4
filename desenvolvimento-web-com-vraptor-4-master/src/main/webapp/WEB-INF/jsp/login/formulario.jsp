<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="autentica" method="post">
			<h2 class="form-signin-heading">Fa�a login para acessar o VRaptor-Produtos</h2>
			<input type='text' class="form-control" name='usuario.nome' placeholder="nome"/>
			<input type='password' class="form-control" name='usuario.senha' placeholder="senha"/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
	</div>
	
	<c:if test='${not empty errors}'>
		<div class="alert alert-danger">
			<c:forEach var='error' items='${errors}'>
				${error.category} - ${error.message}<br/>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>