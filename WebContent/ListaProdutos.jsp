<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="produto" class="lojaonline.modelo.Produto"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Loja | Lista Produtos</title>
</head>
<body>
	<div>

		<%@include  file="Cabecalho.jsp" %>
		
		<h2>Lista Produtos</h2>
		<table class="table">
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
			    	<c:if test="${p.estoque < 1}">Sem estoque</c:if>
			    	<c:if test="${p.estoque > 0}">
			    		<a href="CarrinhoServlet?id=${p.id}&comando=add">Adicionar</a>
			    	</c:if>
			    </td>
			  </tr>
		  </c:forEach>
		</table>
		<a href="VerCarrinho.jsp">Ver Carrinho</a>
	</div>
</body>
</html>