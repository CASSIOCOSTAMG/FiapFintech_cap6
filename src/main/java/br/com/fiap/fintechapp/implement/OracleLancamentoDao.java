package br.com.fiap.fintechapp.implement;

import br.com.fiap.fintechapp.connectionfactory.ConnectionFactory;
import br.com.fiap.fintechapp.dao.LancamentoDao;
import br.com.fiap.fintechapp.exception.DBException;
import br.com.fiap.fintechapp.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleLancamentoDao implements LancamentoDao {

    private Connection conexao;
    public PreparedStatement stm = null;



    @Override
    public void inserirlanc(Lancamento lancamento) throws DBException {

    }

    @Override
    public void alterarlanc(Lancamento lancamento) throws DBException {

    }

    @Override
    public void excluirlanc(int codlanc) throws DBException {

    }

    @Override
    public List<Lancamento> listar() {
        List<Lancamento> listlancamentos = new ArrayList<Lancamento>();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT L.CODLANC, L.DTLANC, L.DESCRICAO, L.VALOR, L.DOCUMENTO, " +
                    "L.T_MOVIMENTO_CODMOV, MOV.DESCRICAO AS TIPOMOV, "+
                    "L.T_TIPPAGAMENTO_CODTIPPG, PG.DESCRICAO AS NOMEPAGAMENTO, " +
                    "L.T_CONTA_CODCONTA, CT.DESCRICAO AS CONTA, "+
                    "L.T_TIPOLANC_CODTIPO, TP.DESCRICAO  AS TIPO "+
                    "FROM T_LANCAMENTO L " +
                    "INNER JOIN T_MOVIMENTO MOV ON MOV.CODMOV = L.T_MOVIMENTO_CODMOV " +
                    "INNER JOIN T_TIPPAGAMENTO PG ON PG.CODTIPPG = L.T_TIPPAGAMENTO_CODTIPPG " +
                    "INNER JOIN T_CONTA CT ON CT.CODCONTA = L.T_CONTA_CODCONTA " +
                    "INNER JOIN T_TIPOLANC TP ON TP.CODTIPO = L.T_TIPOLANC_CODTIPO " ;

            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()){

                int codigo = rs.getInt("CODLANC");
                LocalDate dtlanc = rs.getDate("DTLANC").toLocalDate();
                String descricao = rs.getString("DESCRICAO");
                double valor = rs.getDouble("VALOR");
                String documento = rs.getString("DOCUMENTO");

                int codmov = rs.getInt("T_MOVIMENTO_CODMOV");
                String descrmov = rs.getString("TIPOMOV");

                int tippgto = rs.getInt("T_TIPPAGAMENTO_CODTIPPG");
                String nomepagamento = rs.getString("NOMEPAGAMENTO");

                int codconta = rs.getInt("T_CONTA_CODCONTA");
                String descricaoconta = rs.getString("CONTA");

                int tiplanc = rs.getInt("T_TIPOLANC_CODTIPO");
                String tipo = rs.getString("TIPO");

                Lancamento lancamento = new Lancamento( codigo, dtlanc, descricao, valor, documento);

                TipPagamento tipPagamento = new TipPagamento(tippgto,nomepagamento);
                Conta conta = new Conta(codconta,descricaoconta);
                TipoLanc tipoLanc = new TipoLanc(tiplanc,tipo);
                Movimento tipmov = new Movimento(codmov,descrmov);

                lancamento.setTippagamento(tipPagamento);
                lancamento.setTiplanc(tipoLanc);
                lancamento.setConta(conta);
                lancamento.setMovimento(tipmov);

                listlancamentos.add(lancamento);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stm.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listlancamentos;
    }

    @Override
    public Lancamento buscarUsuario(int codlanc) {
        return null;
    }


}
