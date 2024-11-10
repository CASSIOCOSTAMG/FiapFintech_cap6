package br.com.fiap.fintechapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        String url = req.getRequestURI();

        if (session.getAttribute("user") == null && !url.endsWith("login") && !url.contains("resources") && !url.contains("index")) {
            req.setAttribute("erro", "Entre com o usuário e senha!");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else {
            filterChain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}
