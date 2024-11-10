package br.com.fiap.fintechapp.implement;

import br.com.fiap.fintechapp.connectionfactory.ConnectionFactory;
import br.com.fiap.fintechapp.dao.TipoLancDao;
import br.com.fiap.fintechapp.model.Movimento;
import br.com.fiap.fintechapp.model.TipoLanc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleTipoLancDao implements TipoLancDao {
    private Connection conexao;

    @Override
    public List<TipoLanc> listarTipoLanc() {
      List<TipoLanc> listaTipoLanc = new ArrayList<TipoLanc>();

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            stm = conexao.prepareStatement("SELECT * FROM T_TIPOLANC");
            rs   = stm.executeQuery();

            while (rs.next()){
                int codigo = rs.getInt("CODTIPO");
                String descricao = rs.getString("DESCRICAO");
                TipoLanc tipoLanc = new TipoLanc(codigo, descricao);
                listaTipoLanc.add(tipoLanc);

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
        return listaTipoLanc;

    }

}
