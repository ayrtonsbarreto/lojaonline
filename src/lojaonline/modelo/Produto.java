package lojaonline.modelo;

import java.util.List;

import lojaonline.modelo.db.ProdutoDAO;

public class Produto{

	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private int estoque;
	private int quantidade;
	private static ProdutoDAO dao = new ProdutoDAO();

	public Produto() {
		
	}

	public Produto(int Id, String Descricao) {
		this.id = Id;
		this.descricao = Descricao;
	}
	
	

	public Produto(String nome, String descricao, double preco, int estoque) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void incrementaEstoque() {
		this.estoque++;
	}
	
	public void diminuiEstoque() {
		this.estoque--;
	}
	
    public static List<Produto> all() {
        return dao.all();
    }
    
    public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void save() {
        if (id != 0) {
            dao.update(this);
        } else {
            dao.create(this);
        }
    }

    public void delete() {
        dao.delete(this);
    }

    public static Produto findById(int id) {
        return dao.findById(id);
    }

    public static List<Produto> findByName(String n) {
        return dao.findByName(n);
    }
	
}
