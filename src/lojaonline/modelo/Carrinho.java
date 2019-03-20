package lojaonline.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Carrinho {
	public Carrinho(ArrayList<Produto> produtos) {
		super();
		this.produtos = produtos;
	}

	ArrayList<Produto> produtos;

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto(int id) {
		Produto mp = null;
		for (Produto p : produtos) {
			if (p.getId() == id) {
				return p;
			}
		}
		return mp;
	}

	public void removeProduto(int id) {
		Produto p = getProduto(id);
		produtos.remove(p);

	}

	public void addProduto(Produto p) {
		produtos.add(p);
	}
	
	public static String getCartCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String cart = null;
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("cart")) {
				cart = cookie.getValue();
			}
		}
		
		return cart;
	}
	
	public static List<Produto> getCartProducts(HttpServletRequest request) {
        ArrayList<Produto> produtos = new ArrayList<>();
        String cart = getCartCookie(request);
		String s[] = cart.split(" ");
		
		for (String op : s) {
			String item[] = op.split("Q");
			Produto produto = Produto.findById(Integer.parseInt(item[0]));
			if(produto != null)	
				produtos.add(produto);
		}
		return produtos;
	}
	
	public static String updateCartString(String cart, String command, int productId) {
		String s[] = cart.split(" ");
		int productQtd = 0;
		
		for (String op : s) {
			String item[] = op.split("Q");
			int id = Integer.parseInt(item[0]);
			int qtd = Integer.parseInt(item[1]);
			
			if(id == productId) {
				productQtd = qtd;
			}
		}
		
		if (command.equals("add")){
			if(productQtd > 0 )
				cart = cart.replace(productId+"Q"+productQtd, productId+"Q"+(productQtd+1));
			else
				cart += " "+productId+"Q"+1;
		}else if (command.equals("remove")){
			if(productQtd > 0 )
				cart = cart.replace(productId+"Q"+productQtd, "");
		}
		
		return cart;
	}
}
