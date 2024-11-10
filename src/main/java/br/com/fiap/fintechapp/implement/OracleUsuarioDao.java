package br.com.fiap.fintechapp.implement;
import br.com.fiap.fintechapp.connectionfactory.ConnectionFactory;
import br.com.fiap.fintechapp.dao.UsuarioDao;
import br.com.fiap.fintechapp.exception.DBException;
import br.com.fiap.fintechapp.model.Usuario;
import br.com.fiap.fintechapp.util.CriptografiaUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleUsuarioDao implements UsuarioDao {
    private Connection conexao;
    private PreparedStatement stm = null;

    @Override
    public boolean validarUsuario(Usuario usuario) {

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM T_USUARIO WHERE LOGIN = ? AND SENHA = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, usuario.getLogin());
            stm.setString(2, usuario.getSenhausu());
            rs = stm.executeQuery();


            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    @Override
    public void inserirUsuario(Usuario usuario) throws DBException {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO T_USUARIO (CODUSU, NOMEUSU, SOBRENOME, LOGIN, SENHA, EMAIL, TELEFONE )" +
                    "VALUES (SEQ_USUARIO.nextval, ?, ?, ?, ?, ?, ?) ";

            stm = conexao.prepareStatement(sql);
            stm.setString(1, usuario.getNomeusu());
            stm.setString(2, usuario.getSobrenomeusu());
            stm.setString(3, usuario.getLogin());
            stm.setString(4, CriptografiaUtils.criptografar(usuario.getEmailusu()));
            stm.setString(5, usuario.getEmailusu());
            stm.setString(6, usuario.getTelefonusu());
            stm.executeUpdate();


        } catch (SQLException e) {
            throw new DBException("Erro ao Cadastrar  Usuário!", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stm.close();
                conexao.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

    }

    @Override
    public void alterarUsuario(Usuario usuario) throws DBException {

        try {

            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "UPDATE T_USUARIO SET  NOMEUSU=?, SOBRENOME=?, LOGIN=?,  EMAIL=?, TELEFONE=? WHERE CODUSU = ?  ";

            stm = conexao.prepareStatement(sql);
            stm.setString(1, usuario.getNomeusu());
            stm.setString(2, usuario.getSobrenomeusu());
            stm.setString(3, usuario.getLogin());
            stm.setString(4, usuario.getEmailusu());
            stm.setString(5, usuario.getTelefonusu());
            stm.setInt(6, usuario.getCodusu());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new DBException("Erro ao atualizar usuário!", e);

        } finally {
            try {
                stm.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void excluirUsuario(int codusu) throws DBException {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "DELETE T_USUARIO  WHERE CODUSU = ?";
            stm = conexao.prepareStatement(sql);

            stm.setInt(1, codusu);
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new DBException("Erro ao remover usuário!", e);
        } finally {
            try {
                stm.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement stm = null;
        ResultSet rs = null;


        try {

            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM T_USUARIO ORDER BY 1";
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();

            //Percorre todos os registros encontrados
            while (rs.next()) {
                int codusu = rs.getInt("CODUSU");
                String nomeusu = rs.getString("NOMEUSU");
                String sobrenome = rs.getString("SOBRENOME");
                String login = rs.getString("LOGIN");
                String email = rs.getString("EMAIL");
                String telefone = rs.getString("TELEFONE");

                Usuario usuario = new Usuario(codusu, nomeusu, sobrenome, email, telefone, login);
                lista.add(usuario);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;


    }

    @Override
    public Usuario buscarUsuario(int codusu) {
        Usuario usuario = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM T_USUARIO WHERE CODUSU = ?";

            stm = conexao.prepareStatement(sql);
            stm.setInt(1, codusu);
            rs = stm.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("CODUSU");
                String nomeusu = rs.getString("NOMEUSU");
                String sobrenome = rs.getString("SOBRENOME");
                String login = rs.getString("LOGIN");
                String email = rs.getString("EMAIL");
                String telefone = rs.getString("TELEFONE");

                usuario = new Usuario(id, nomeusu, sobrenome, email, telefone, login);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }  return usuario;

    }





}
