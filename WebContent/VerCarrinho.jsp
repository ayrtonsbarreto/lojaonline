<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="produto" class="lojaonline.modelo.Produto"/>
<jsp:useBean id="carrinho" class="lojaonline.modelo.Carrinho"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table, th, td {
		border: 1px solid black;
	}
</style>
<title>Loja | Ver Carrinho</title>
</head>
<body>
	<%
	%>
	<div>
		<h1>Lista Carrinho</h1>
		<table>
		  <tr>
		    <th>Nome</th>
		    <th>Descrição</th>
		    <th>Preço</th>
		    <th>Quantidade</th>
		    <th>Remover</th>
		  </tr>
		  <c:forEach var="p" items="${produto.all()}">
			  <tr>
			    <td>${p.nome}</td>
			    <td>${p.descricao}</td>
			    <td>${p.preco}</td>
			    <td>${p.estoque}</td>
			    <td>
			    	<c:if test="${p.estoque < 1}">Sem estoque</c:if>
			    	<c:if test="${p.estoque > 0}">
			    		<a href="CarrinhoServlet?id=${p.id}&comando=add">Adicionar</a>
			    	</c:if>
			    </td>
			  </tr>
		  </c:forEach>
		</table>
		<a href="ListaProdutos.jsp">Ver Produtos</a>
	</div>
</body>
</html>