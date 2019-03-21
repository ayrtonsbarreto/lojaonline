<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
</head>
<body>
	<nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Loja online</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				
				<c:if test="${sessionScope.usuario != null}">
					<c:if test="${sessionScope.usuario.admin}">
						<li class="nav-item"><a class="nav-link"
							href="ExibirProduto.jsp">Produtos<span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="CadastroProduto.jsp">Cadastrar Produto</a></li>
						
					</c:if>
					<c:if test="${sessionScope.usuario.admin == false}">
						<li class="nav-item"><a class="nav-link"
							href="ListaProdutos.jsp">Produtos<span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="VerCarrinho.jsp">Carrinho</a>
						</li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="Deslogar">Sair</a></li>
				</c:if>
				<c:if test="${sessionScope.usuario == null}">
					<li class="nav-item"><a class="nav-link" href="Login.html">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="CadastroUsuario.html">Cadastre-se</a></li>					
				</c:if>
			</ul>
		</div>
		<c:if test="${sessionScope.usuario != null}">
			<span class="navbar-text"> Usuário
				${sessionScope.usuario.nome} </span>
		</c:if>
	</nav>
	<br />
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>