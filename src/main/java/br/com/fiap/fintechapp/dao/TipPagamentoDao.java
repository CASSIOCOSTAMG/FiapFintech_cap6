package br.com.fiap.fintechapp.dao;

import br.com.fiap.fintechapp.model.TipPagamento;
import br.com.fiap.fintechapp.model.TipoLanc;

import java.util.List;

public interface TipPagamentoDao {

    List<TipPagamento> listarTipPagamento();

}
