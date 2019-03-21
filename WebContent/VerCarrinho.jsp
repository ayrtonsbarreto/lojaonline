<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="lojaonline.modelo.Produto" %>
<%@page import="lojaonline.modelo.Produto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="carrinho" class="lojaonline.modelo.Carrinho"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja | Ver Carrinho</title>
</head>
<body>
	<%
	request.setAttribute("cart", carrinho.getCartCookie(request));

	%>
	<%@include  file="Cabecalho.jsp" %>
	
	<div>
		<h1>Lista Carrinho</h1>
		<table class="table">
		  <tr>
		    <th>Nome</th>
		    <th>Descrição</th>
		    <th>Preço</th>
		    <th>Quantidade</th>
		    <th>Remover</th>
		  </tr>
		  <c:forEach var="p" items="${carrinho.getCartProducts(requestScope.cart)}">
			  <tr>
			    <td>${p.nome}</td>
			    <td>${p.descricao}</td>
			    <td>${p.preco}</td>
			    <td>${p.quantidade}</td>
			    <td>
			    	<a href="CarrinhoServlet?id=${p.id}&comando=remove">Remover</a>
			    </td>
			  </tr>
		  </c:forEach>
		</table>
		<a href="ListaProdutos.jsp">Ver Produtos</a>
	</div>
</body>
</html>