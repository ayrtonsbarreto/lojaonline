package lojaonline.modelo;

public class Pessoa {
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	
	public Pessoa() {
		
	}
	
	
	public Pessoa(int id, String Nome, String Email, String Senha) {
		super();
		this.id = id;
		this.nome = Nome;
		this.email = Email;
		this.senha = Senha;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
