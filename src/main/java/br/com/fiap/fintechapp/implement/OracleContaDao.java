package br.com.fiap.fintechapp.implement;

import br.com.fiap.fintechapp.connectionfactory.ConnectionFactory;
import br.com.fiap.fintechapp.dao.ContaDao;
import br.com.fiap.fintechapp.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleContaDao implements ContaDao {

    private Connection conexao;

    @Override
    public List<Conta> listarContas() {

        List<Conta> contas = new ArrayList<Conta>();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_CONTA");
            rs = stmt.executeQuery();

            //Percorre todos os registros encontrados
            while (rs.next()) {
                int codigo = rs.getInt("CODCONTA");
                String nome = rs.getString("DESCRICAO");
                Conta conta = new Conta(codigo, nome);
                contas.add(conta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contas;
    }
}
