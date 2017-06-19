<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../materialize/css/libs/materialize.min.css">
<link rel="stylesheet" type="text/css" href="../materialize/css/libs/google-fonts.css"/>

<title>Produtos a venda</title>

</head>
<body>
	<h1>Lista de produtos</h1>
		<table class="responsive-table centered bordered striped">
			<thead>
				<tr>
					<th>Nome: </th>
					<th>Descrição: </th>
					<th>Valor Total: </th>
					<th>Valor Frete: </th>
					<th>Quantidade: </th>
					<th>Imagem: </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items ="${produtoList}" var="produto">
				<tr>
					<td>${produto.nome}</td>
					<td>${produto.descricao}</td>
					<td>${produto.valorTotal}</td>
					<td>${produto.valorFrete}</td>
					<td>${produto.quantidade}</td>
					<td>${produto.imagem}</td>
				</tr>
				</c:forEach>
			</tbody>
		
		</table>
	
</body>
</html>