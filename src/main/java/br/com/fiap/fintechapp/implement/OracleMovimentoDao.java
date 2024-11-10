package br.com.fiap.fintechapp.implement;

import br.com.fiap.fintechapp.connectionfactory.ConnectionFactory;
import br.com.fiap.fintechapp.dao.MovimentoDao;
import br.com.fiap.fintechapp.model.Movimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleMovimentoDao implements MovimentoDao {

    private Connection conexao;

    @Override
    public List<Movimento> listarMovimentos() {
       List<Movimento> movimentos = new ArrayList<Movimento>();
       PreparedStatement stm = null;
       ResultSet rs = null;

       try {
           conexao = ConnectionFactory.getInstance().getConnection();
           stm = conexao.prepareStatement("SELECT * FROM T_MOVIMENTO");
           rs   = stm.executeQuery();

           while (rs.next()){
               int codigo = rs.getInt("CODMOV");
               String descricao = rs.getString("DESCRICAO");
               Movimento movimento = new Movimento(codigo, descricao);
               movimentos.add(movimento);

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
        return movimentos;

    }
}
