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
	<h1 class="center-align">EDITAR CADASTRO DE UM PROFESSOR</h1>
	<div class="row">
		<form action="<c:url value='/professor/altera?='/>" method="PUT">
			<input type="hidden" name="professor.id" value="${professor.id}"/>
			<div class="col s6">
				NOME: <input type="text" name="professor.nome" value="${professor.nome}"/>
			</div>
			<div class="col s6">
				ENDEREÇO: <input type="text" name="professor.endereco" value="${professor.endereco}"/>
			</div>
			<div class="col s5">
				MATÉRIA: <input type="text" name="professor.materia" value="${professor.materia}"/>
			</div>
			<div class="col s3">
				IDADE: <input type="number" name="professor.idade" value="${professor.idade}"/>
			</div>
			<div class="col s4">
				SALÁRIO: <input type="number" name="professor.salario" value="${professor.salario}"/>
			</div>
			<div class="col s9"></div>
			<div class="col s3 right">
				<input type="submit" class="btn waves-effect waves-light btn-large right" value="ALTERAR"></input>	
			</div>
		</form>
		</form>
	</div>
</div>
</body>
</html>