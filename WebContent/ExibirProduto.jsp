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
<title>Loja | Informações do Produto</title>
</head>
<body>
    <div>
        <h1>Informações do Produto</h1>
        <table>

          <c:forEach var="p" items="${produto.all()}">
              <tr>
                  <th>Nome</th>
                <td>${p.nome}</td>
              </tr>
              <tr> 
                  <th>Descrição</th>
                  <td>${p.descricao}</td>
              </tr>
              <tr> 
                  <th>Preço</th>
                  <td>${p.preco}</td>
              </tr>
              <tr> 
                  <th>Estoque</th>
                  <td>${p.estoque}</td>
              </tr>
          </c:forEach>
        </table>
        <a href="LojistaPage">Página Inicial</a>
    </div>
</body>
</html>