package br.com.fiap.fintechapp.controller;

import br.com.fiap.fintechapp.bo.EmailBo;
import br.com.fiap.fintechapp.dao.UsuarioDao;
import br.com.fiap.fintechapp.exception.EmailException;
import br.com.fiap.fintechapp.factory.DaoFactory;
import br.com.fiap.fintechapp.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDao usuarioDao;
    private EmailBo bo;

    String mensagem = "Um login foi realizado na plataforma em " + LocalDate.now();

    public LoginServlet() {
        usuarioDao = DaoFactory.getUsuarioDao();
        bo = new EmailBo();
    }


    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(login, senha);

        if (usuarioDao.validarUsuario(usuario)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", login);

            request.getRequestDispatcher("home.jsp").forward(request, response);

            try {
                bo.enviarEmail("cassiomilkbh@gmail.com", "Login Realizado", mensagem);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            try {
                bo.enviarEmail("cassiomilkbh@gmail.com", "Login NÃO Realizado", mensagem);
            } catch (EmailException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("erro", "Usuário e/ou senha inválidos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }


    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }


}
