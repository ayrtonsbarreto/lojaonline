<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="produto" class="lojaonline.modelo.Produto"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table, th, td {
		border: 1px solid black;
	}
</style>
<title>Loja | Lista Produtos</title>
</head>
<body>
	<div>
		<h1>Lista Produtos</h1>
		<table>
		  <tr>
		    <th>Nome</th>
		    <th>Descrição</th>
		    <th>Preço</th>
		    <th>Estoque</th>
		    <th>Carrinho</th>
		  </tr>
		  <c:forEach var="p" items="${produto.all()}">
			  <tr>
			    <td>${p.nome}</td>
			    <td>${p.descricao}</td>
			    <td>${p.preco}</td>
			    <td>${p.estoque}</td>
			    <td>
			    	<a href="#">Adicionar</a>
			    </td>
			  </tr>
		  </c:forEach>
		</table>
		<a href="#">Ver Carrinho</a>
	</div>
</body>
</html>