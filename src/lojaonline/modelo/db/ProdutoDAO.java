package lojaonline.modelo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import lojaonline.modelo.Produto;

/**
 * @author arthur
 */
public class ProdutoDAO extends Database implements Dao<Produto> {
    @Override
    public void create(Produto produto) {
        open();
        String query = "INSERT INTO produtos(nome, descricao, preco, estoque) VALUES (?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getPreco());
            pst.setInt(4, produto.getEstoque());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao criar o porco! " + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void delete(Produto produto) {
        open();
        String query = "DELETE FROM produtos WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, produto.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar a produtos " + produto.getId() + ":" + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void update(Produto produto) {
        open();
        String query = "UPDATE produtos SET nome = ?, descricao = ?, preco = ?, estoque = ? WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getPreco());
            pst.setInt(4, produto.getEstoque());
            pst.setInt(5, produto.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o materiais: " + produto.getId() + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public List<Produto> all() {
        open();
        ArrayList<Produto> produtosList = new ArrayList<>();
        String query = "SELECT * FROM produtos;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao").trim();
                boolean disponivel = rs.getBoolean("disponivel");
                Produto m = new Produto(id, desc);
                produtosList.add(m);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar os materiais:" + e.getMessage());
        } finally {
            close();
        }
        return produtosList;
    }

    @Override
    public Produto findById(int id) {
        open();
        Produto produto = new Produto();
        String query = "SELECT * FROM produtos WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao").trim());
            }

        } catch (SQLException e) {
            System.err.println("Erro ao procurar produtos: " + id + e.getMessage());
        } finally {
            close();
        }
        return produto;
    }

    public ArrayList<Produto> findByName(String n) {
        open();
        ArrayList<Produto> lista = new ArrayList<>();
        String query = "SELECT * FROM produtos WHERE descricao ILIKE ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, "%" + n + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("descricao").trim();
                boolean disponivel = rs.getBoolean("disponivel");
                Produto m = new Produto(id, desc);
                lista.add(m);
            }

        } catch (SQLException e) {
        	System.err.println("Erro ao procurar produtos: " + n + e.getMessage());
        } finally {
            close();
        }
        return lista;
    }
}
