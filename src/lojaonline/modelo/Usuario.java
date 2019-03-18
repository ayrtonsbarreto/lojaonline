package lojaonline.modelo;

import java.util.ArrayList;
import java.util.List;
import lojaonline.modelo.db.UsuarioDAO;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private boolean admin;
	private static UsuarioDAO dao = new UsuarioDAO();
	
	public Usuario() {
		
	}
	
	
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}


	public Usuario(int id, String Nome, String Email, String Senha, boolean Admin) {
		super();
		this.id = id;
		this.nome = Nome;
		this.email = Email;
		this.senha = Senha;
		this.admin = Admin;
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


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
    public static List<Usuario> all() {
        return dao.all();
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
    
    public static Usuario findById(int id) {
        return dao.findById(id);
    }

    public static Usuario login(String email, String senha) {
        return dao.login(email, senha);
    }
	
}
