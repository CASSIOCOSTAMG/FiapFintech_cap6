package br.com.fiap.fintechapp.controller;

import br.com.fiap.fintechapp.dao.*;
import br.com.fiap.fintechapp.factory.DaoFactory;
import br.com.fiap.fintechapp.model.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/lancamento")
public class LancamentoServlet extends HttpServlet {


    private LancamentoDao lancamentoDao;
    private MovimentoDao movimentoDao;
    private TipoLancDao tipoLancDao;
    private ContaDao contaDao;
    private TipPagamentoDao tipPagamentoDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        lancamentoDao = DaoFactory.getLancamentoDao();
        movimentoDao = DaoFactory.getMovimentoDao();
        tipoLancDao = DaoFactory.getTipoLancDao();
        contaDao = DaoFactory.getContaDao();
        tipPagamentoDao = DaoFactory.getTipPagamentoDao();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

    }


    private void carregarOpcoesMovimento(HttpServletRequest request) {
        List<Movimento> lista = movimentoDao.listarMovimentos();
        request.setAttribute("movimento", lista);
    }

    private void carregarOpcoesTipLancamento(HttpServletRequest request) {
        List<TipoLanc> lista = tipoLancDao.listarTipoLanc();
        request.setAttribute("tipolanc", lista);
    }

    private void carregarOpcoesConta(HttpServletRequest request) {
        List<Conta> lista = contaDao.listarContas();
        request.setAttribute("conta", lista);
    }

    private void carregarOpcoesTipPagamento(HttpServletRequest request) {
        List<TipPagamento> lista = tipPagamentoDao.listarTipPagamento();
        request.setAttribute("tipopagamento", lista);
    }


    private void abrirFormCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        carregarOpcoesMovimento(req);
        carregarOpcoesTipLancamento(req);
        carregarOpcoesConta(req);
        req.getRequestDispatcher("cadastro-lancamento.jsp").forward(req, resp);
    }


    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lancamento> lista = lancamentoDao.listar();
        req.setAttribute("lancamento", lista);
        req.getRequestDispatcher("lista-lancamento.jsp").forward(req, resp);
    }


}
