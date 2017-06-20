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
	<h1 class="center-align">LOGIN</h1>
	<form action="<c:url value='autentica'/>" method="POST">
	<div class="col s4">
		USUARIO: <input type="text" name="usuario.nome"/>
	</div>
	<div class="col s4">
		SENHA: <input type="password" name="usuario.senha"/>
	</div>
	<div class="col s3 right">
		<input type="submit" class="btn waves-effect waves-light btn-large right" value="LOGIN"></input>
	</div>
	
	</form>
	<c:forEach items="${errors}" var="erro">
		${erro.category} - ${erro.message} <br>
	</c:forEach>
</body>
</html>