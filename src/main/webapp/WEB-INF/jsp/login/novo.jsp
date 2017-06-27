<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../materialize/css/libs/materialize.min.css">
<link rel="stylesheet" type="text/css" href="../materialize/css/libs/google-fonts.css">
<title>UNIVERSIDADE</title>
</head>
<body>
<nav>
   	<div class="nav-wrapper teal lighten-1">
     	<a href="#!" class="brand-logo center">BLACK MARKET</a>
     	<ul class="right hide-on-med-and-down">
     		<li><a class="">${usuarioLogado.usuario.nome}</a></li>
     		<li><a class="" value="LOGOUT"></a></li>
     	</ul>
      	<ul class="left hide-on-med-and-down">
        	<li><a href="<c:url value='/produto/formulario'/>">ADICIONAR COMPUTADOR</a></li>
       	 	<li><a href="<c:url value='/produto/lista'/>">LISTA DE COMPUTADORES</a></li>
       	 	<li><a href="<c:url value='/login/'/>">LOGIN</a></li>
     	</ul>
   	</div>
</nav>

<div class="container">

	<h1 class="center-align">ADICIONAR PRODUTOS</h1>
	<div class="row">
		<form action="<c:url value='/login/adiciona'/>" method="POST">
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
	<c:forEach items="${errors}" var="erro">
		${erro.category} - ${erro.message} <br>
	</c:forEach>
</div>

<%-- <div class="container">
<h1 class="center-align">CRIAR CONTA</h1>
	<div class="row">
		<form action="<c:url value='/produto/adiciona'/>" method="POST">
			<div class="col s6">
				NOME:<input type="text" name="usuario.nome"/>
			</div>
			<div class="col s6">
				SENHA: <input type="password" name="usuario.senha"/>
			</div>
			<div class="col s3 right">
				<input type="submit" class="btn waves-effect waves-light btn-large right" value="CRIAR"></input>	
			</div>	
		</form>
	</div>
	<c:forEach items="${errors}" var="erro">
		${erro.category} - ${erro.message} <br>
	</c:forEach>
</div> --%>
</body>
</html>