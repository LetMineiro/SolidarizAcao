package com.solidarizacao.controller;

import com.solidarizacao.dao.UsuarioDAO;
import com.solidarizacao.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginUsuario")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.buscarPorEmailESenha(email, senha);

            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("email", usuario.getEmail());
                session.setAttribute("nome", usuario.getNome());
                response.sendRedirect("perfil.html");
            } else {
                response.sendRedirect("login.html?erro=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao realizar login.");
        }
    }
}