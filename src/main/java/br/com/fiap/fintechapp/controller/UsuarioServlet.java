package br.com.fiap.fintechapp.controller;

import br.com.fiap.fintechapp.dao.UsuarioDao;
import br.com.fiap.fintechapp.exception.DBException;
import br.com.fiap.fintechapp.factory.DaoFactory;
import br.com.fiap.fintechapp.model.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private UsuarioDao usuarioDao;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        usuarioDao = DaoFactory.getUsuarioDao();

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao){
            case "cadastrar":
                cadastrar(req,resp);
                break;

           case "editar":
                editar(req,resp);
                break;

           case "excluir":
                excluir(req,resp);
                    break;
        }

    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int codigo = Integer.parseInt(req.getParameter("codigoExcluir"));
        try {
            usuarioDao.excluirUsuario(codigo);
            req.setAttribute("msg", "Usuário removido!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar");
        }
        listar(req, resp);
    }


      private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String nome = req.getParameter("nomeusu").toUpperCase();
            String sobrenome = req.getParameter("sobrenomeusu").toUpperCase();
            String email = req.getParameter("emailusu").toLowerCase();
            String telefone = req.getParameter("telefonusu");
            String login = req.getParameter("login").toUpperCase();
            String senha = req.getParameter("senhausu");

            try {
                Usuario usuario = new Usuario(0, nome, sobrenome ,email, telefone, senha,login);

                usuarioDao.inserirUsuario(usuario);
                req.setAttribute ("msg","Usuário cadastrado!");

            } catch (DBException db) {
                db.printStackTrace();
                req.setAttribute("erro", "Erro ao cadastrar");
            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("erro", "Por favor, valide os dados");
            }

          listar(req, resp);
        }



        private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            int codigo = Integer.parseInt(req.getParameter("codigo"));
            String nome = req.getParameter("nomeusu");
            String sobrenome = req.getParameter("sobrenomeusu");
            String email = req.getParameter("emailusu");
            String telefone = req.getParameter("telefonusu");
            String login = req.getParameter("login");

            Usuario usuario = new Usuario(codigo, nome, sobrenome, email, telefone,  login);

            usuarioDao.alterarUsuario(usuario);
            req.setAttribute("msg", "Usuário atualizado com sucesso!");


        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Por favor, valide os dados");
        }
            listar(req, resp);
        }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "listar":
                listar(req, resp);
                break;

            case "abrir-form-edicao":
                abrirForm(req, resp);
                break;

            case "abrir-form-cadastro":
                abrirFormCadastro(req, resp);
                break;
        }

    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("codigo"));
        Usuario usuario = usuarioDao.buscarUsuario(id);
        req.setAttribute("usuario", usuario);
        req.getRequestDispatcher("editar-usuario.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> lista = usuarioDao.listar();
        req.setAttribute("usuario", lista);
        req.getRequestDispatcher("lista-usuario.jsp").forward(req, resp);

    }


    private void abrirFormCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cadastro-usuario.jsp").forward(req, resp);
    }


}
