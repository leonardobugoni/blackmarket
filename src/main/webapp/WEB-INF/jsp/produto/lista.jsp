<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../materialize/css/libs/materialize.min.css">
<link rel="stylesheet" type="text/css" href="../materialize/css/libs/google-fonts.css">
<title>Produtos</title>
</head>
<body class="container">
	<div class="col s4 right">${usuarioLogado.usuario.nome}</div>
	<h1 class="center-align">PRODUTOS</h1>
	<table class="centered bordered striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>DESCRICAO</th>
				<th>QUANTIDADE</th>
				<th>VALOR</th>
				<th>VALOR FRETE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtoList}" var="produto">
				<tr>
					<td>${produto.id}</td>			
					<td>${produto.nome}</td>			
					<td>${produto.descricao}</td>			
					<td>${produto.quantidade}</td>			
					<td>${produto.valor}</td>			
					<td>${produto.valorFrete}</td>			
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${message}
	
	
		
	
	<div class="row">
		<form action="<c:url value='/produto/remove'/>" method="DELETE">
			<div class="col s4">
				REMOVER PELO ID:<input type="text" />
			</div>
			<div class="col s4 right">
				<input type="submit" class="btn waves-effect waves-light btn-large right" value="REMOVER"></input>
			</div>
		</form>
	</div>
</body>
</html>