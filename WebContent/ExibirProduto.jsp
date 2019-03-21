<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="produto" class="lojaonline.modelo.Produto"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Loja | Informações do Produto</title>
</head>
<body>
	<%@include  file="Cabecalho.jsp" %>

    <div>
        <h1>Informações do Produto</h1>
		<table class="table">
		  <tr>
		    <th>Nome</th>
		    <th>Descrição</th>
		    <th>Preço</th>
		    <th>Estoque</th>
		  </tr>
		  <c:forEach var="p" items="${produto.all()}">
			  <tr>
			    <td>${p.nome}</td>
			    <td>${p.descricao}</td>
			    <td>${p.preco}</td>
			    <td>${p.estoque}</td>
			  </tr>
		  </c:forEach>
		</table>
    </div>
</body>
</html>