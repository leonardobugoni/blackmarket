<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../materialize/css/libs/materialize.min.css">
<link rel="stylesheet" type="text/css" href="../materialize/css/libs/google-fonts.css">
<title>BLACK MARKET</title>
</head>
<body class="container">

	<h1 class="center-align">ADICIONAR PRODUTOS</h1>
	<div class="row">
		<form action="<c:url value='/produto/adiciona'/>" method="POST">
			<div class="col s6">
			NOME: <input type="text" name="produto.nome"/>
			</div>
			<div class="col s6">
			DESCRIÇÃO: <input type="text" name="produto.descricao"/>
			</div>
			<div class="col s4">
			QUANTIDADE: <input type="number" name="produto.quantidade"/>
			</div>
			<div class="col s4">
			VALOR: <input type="number" name="produto.valor"/>
			</div>
			<div class="col s4">
			VALOR DO FRETE: <input type="number" name="produto.valorFrete"/>
			</div>
			<div class="col s9"></div>
			<div class="col s3 right">
			<input type="submit" class="btn waves-effect waves-light btn-large right" value="ADICIONAR"></input>	
			</div>
		</form>
	</div>
</body>
</html>