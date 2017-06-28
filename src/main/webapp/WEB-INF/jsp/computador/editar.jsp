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
     	<a href="<c:url value='/'/>" class="brand-logo center">UNIVERSIDADE</a>
     	<ul class="right hide-on-med-and-down">
     		<li><a class="">${usuarioLogado.usuario.nome}</a></li>
     		<li><a class="" value="LOGOUT"></a></li>
     	</ul>
      	<ul class="left hide-on-med-and-down">
       	 	<li><a href="<c:url value='/login/'/>">LOGIN</a></li>
      	 	<li><a href="<c:url value='/computador/lista'/>">COMPUTADORES</a></li>
      	 	<li><a href="<c:url value='/aluno/lista'/>">ALUNOS</a></li>
      	 	<li><a href="<c:url value='/professor/lista'/>">PROFESSORES</a></li>
     	</ul>
   	</div>
</nav>
<div class="container">
	<h1 class="center-align">EDITAR REGISTRO DE UM COMPUTADOR</h1>
	<div class="row">
		<form action="<c:url value='/computador/altera?='/>" method="PUT">
			<input type="hidden" name="computador.id" value="${computador.id}"/>
			<div class="col s6">
				NOME: <input type="text" name="computador.nome" value="${computador.nome}"/>
			</div>
			<div class="col s6">
				DESCRIÇÃO: <input type="text" name="computador.descricao" value="${computador.descricao}"/>
			</div>
			<div class="col s4">
				QUANTIDADE: <input type="number" name="computador.quanitdade" value="${computador.quantidade}"/>
			</div>
			<div class="col s4">
				VALOR: <input type="number" name="computador.valor" value="${computador.valor}"/>
			</div>
			<div class="col s9"></div>
			<div class="col s3 right">
				<input type="submit" class="btn waves-effect waves-light btn-large right" value="SALVAR"></input>	
			</div>
		</form>
	</div>
</div>
</body>
</html>