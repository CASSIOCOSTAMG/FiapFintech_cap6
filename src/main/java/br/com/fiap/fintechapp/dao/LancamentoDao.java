package br.com.fiap.fintechapp.dao;

import br.com.fiap.fintechapp.exception.DBException;
import br.com.fiap.fintechapp.model.Lancamento;
import java.util.List;
public interface LancamentoDao {

    void inserirlanc(Lancamento lancamento) throws DBException;
    void alterarlanc(Lancamento lancamento) throws DBException;
    void excluirlanc(int codlanc) throws DBException;
    List<Lancamento> listar() ;
    Lancamento buscarUsuario(int codlanc) ;



}
