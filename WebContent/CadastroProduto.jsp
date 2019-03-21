<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja | Cadastro Produtos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<%@include  file="Cabecalho.jsp" %>
	
	<form method="post" action="SalvarProduto" class="container">
		<div class="form-group">
	    	<label for="exampleInputEmail1">Nome</label>
	    	<input name="nome" class="form-control">
	 	</div>
	 	<div class="form-group">
	    	<label for="exampleInputEmail1">Descrição</label>
	    	<input name="descricao" class="form-control">
	 	</div>
	 	<div class="form-group">
	    	<label for="exampleInputEmail1">Preço</label>
	    	<input name="preco" class="form-control">
	 	</div>
	 	<div class="form-group">
	    	<label for="exampleInputEmail1">Estoque</label>
	    	<input name="estoque" class="form-control">
	 	</div>
		
		<button class="btn btn-success" name="botao" type="submit">Cadastrar</button>
	</form>
	
</body>
</html>