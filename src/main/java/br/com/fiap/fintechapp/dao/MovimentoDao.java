package br.com.fiap.fintechapp.dao;
import br.com.fiap.fintechapp.model.Movimento;
import java.util.List;

public interface MovimentoDao {

    List<Movimento> listarMovimentos();
}
