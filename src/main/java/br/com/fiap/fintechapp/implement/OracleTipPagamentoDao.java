package br.com.fiap.fintechapp.implement;

import br.com.fiap.fintechapp.connectionfactory.ConnectionFactory;
import br.com.fiap.fintechapp.dao.TipPagamentoDao;
import br.com.fiap.fintechapp.model.Movimento;
import br.com.fiap.fintechapp.model.TipPagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleTipPagamentoDao implements TipPagamentoDao {

    private Connection conexao;

    @Override
    public List<TipPagamento> listarTipPagamento() {

            List<TipPagamento> pagamentos = new ArrayList<TipPagamento>();
            PreparedStatement stm = null;
            ResultSet rs = null;

            try {
                conexao = ConnectionFactory.getInstance().getConnection();
                stm = conexao.prepareStatement("SELECT * FROM T_TIPPAGAMENTO");
                rs   = stm.executeQuery();

                while (rs.next()){
                    int codigo = rs.getInt("CODTIPPG");
                    String descricao = rs.getString("DESCRICAO");
                    TipPagamento movimento = new TipPagamento(codigo, descricao);
                    pagamentos.add(movimento);

                }


            }catch (SQLException e) {
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
            return pagamentos;

        }
}
