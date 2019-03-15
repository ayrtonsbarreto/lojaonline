package lojaonline.modelo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lojaonline.modelo.Usuario;


public class UsuarioDAO extends Database implements Dao<Usuario> {
    @Override
    public void create(Usuario usuario) {
        open();
        String query = "INSERT INTO usuario(nome, email, senha) VALUES (?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar o usuario! " + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void delete(Usuario usuario) {
        open();
        String query = "DELETE FROM usuario WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, usuario.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar a usuario " + usuario.getId() + ":" + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void update(Usuario usuario) {
        open();
        String query = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.setInt(4, usuario.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o usuario: " + usuario.getId() + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public List<Usuario> all() {
        open();
        ArrayList<Usuario> usuarioList = new ArrayList<>();
        String query = "SELECT * FROM usuario;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                boolean admin = rs.getBoolean("admin");
                Usuario u = new Usuario(id, nome, email, senha, admin);
                usuarioList.add(u);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar os alimentos:" + e.getMessage());
        } finally {
            close();
        }
        return usuarioList;
    }

    @Override
    public Usuario findById(int id) {
        open();
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM usuario WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setAdmin(admin);

            }

        } catch (SQLException e) {
            System.err.println("Erro ao procurar usuario: " + id + e.getMessage());
        } finally {
            close();
        }
        return usuario;
    }

    public Usuario login(String email, String senha) {
        String query = "SELECT * FROM usuario WHERE email = ? and senha = ?";
        Usuario usuario = new Usuario();

        try {
            open();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                boolean admin = rs.getBoolean("admin");
                
                usuario.setId(id);
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setAdmin(admin);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao efetuar login: " + e.getMessage());
        } finally {
            close();
        }
        return usuario;
    }
}
