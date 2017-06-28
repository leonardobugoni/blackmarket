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
     	<a href="#!" class="brand-logo center">UNIVERSIDADE</a>
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
	<h1 class="center-align">COMPUTADORES</h1>
	<table class="centered bordered striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>DESCRICAO</th>
				<th>QUANTIDADE</th>
				<th>VALOR</th>
				<th>EDITAR</th>
				<th>REMOVER</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${computadorList}" var="computador">
				<tr>
					<td>${computador.id}</td>			
					<td>${computador.nome}</td>			
					<td>${computador.descricao}</td>			
					<td>${computador.quantidade}</td>			
					<td>${computador.valor}</td>			
					<td>
						<form action="<c:url value='/computador/editar?id=${computador.id}'/>" method="POST">
							<!-- <input type="hidden" name="_method" value="DELETE" /> -->
							<div class="col s4 right">
								<input type="submit" class="btn waves-effect waves-light btn-small right" value="EDITAR"></input>
							</div>
						</form>
					</td>
					<td>
						<form action="<c:url value='/computador/remove?id=${computador.id}'/>" method="POST">
							<input type="hidden" name="_method" value="DELETE" />
							<div class="col s4 right">
								<input type="submit" class="btn waves-effect waves-light btn-small right" value="REMOVER"></input>
							</div>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="center"><h4>${message}</h4></div>
<div class="right"><a href="<c:url value='/computador/formulario'/>" class="btn waves-effect waves-light btn-small right" >ADICIONAR</a></div>
</div>	
</body>
</html>