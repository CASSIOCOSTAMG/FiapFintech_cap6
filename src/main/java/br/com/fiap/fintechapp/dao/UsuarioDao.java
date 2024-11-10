package br.com.fiap.fintechapp.dao;

import br.com.fiap.fintechapp.exception.DBException;
import br.com.fiap.fintechapp.model.Usuario;
import java.util.List;

public interface UsuarioDao {
    boolean validarUsuario(Usuario usuario);
    void inserirUsuario(Usuario usuario) throws DBException;
    void alterarUsuario(Usuario usuario) throws DBException;
    void excluirUsuario(int codusu) throws DBException;
    List<Usuario> listar() ;
    Usuario buscarUsuario(int codusu) ;


}

