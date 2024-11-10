package br.com.fiap.fintechapp.factory;

import br.com.fiap.fintechapp.dao.*;
import br.com.fiap.fintechapp.implement.*;
import br.com.fiap.fintechapp.model.Usuario;

public class DaoFactory {


    public static UsuarioDao getUsuarioDao() {
            return new OracleUsuarioDao();
    }


    public static LancamentoDao getLancamentoDao() {
        return new OracleLancamentoDao();
    }

    public static TipPagamentoDao getTipPagamentoDao() {
        return new OracleTipPagamentoDao();
    }

    public static TipoLancDao getTipoLancDao() {
            return new OracleTipoLancDao();
    }

    public static ContaDao getContaDao() {
        return new OracleContaDao();
    }

    public static MovimentoDao getMovimentoDao() {
        return new OracleMovimentoDao();
    }



}
