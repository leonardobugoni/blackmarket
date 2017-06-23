<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value='materialize/css/libs/materialize.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='materialize/css/libs/google-fonts.css'/>">
<title>BLACK MARKET</title>
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
        	<li><a href="<c:url value='/produto/formulario'/>">ADICIONAR PROTUDOS</a></li>
       	 	<li><a href="<c:url value='/produto/lista'/>">LISTA DE PRODUTOS</a></li>
       	 	<li><a href="<c:url value='/login/'/>">LOGIN</a></li>
     	</ul>
   	</div>
</nav>
<div class="container">
	<div class="center"><h4>${message}</h4></div>
</div>
</body>
</html>