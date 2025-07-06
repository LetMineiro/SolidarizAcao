package com.solidarizacao.controller;

import com.solidarizacao.dao.UsuarioDAO;
import com.solidarizacao.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            UsuarioDAO dao = new UsuarioDAO();

            if (dao.emailExiste(email)) {
                response.getWriter().println("Email já cadastrado. <a href='cadastro.html'>Tentar novamente</a>");
                return;
            }

            Usuario u = new Usuario();
            u.setNome(nome);
            u.setEmail(email);
            u.setSenha(senha);

            dao.cadastrar(u);

            response.sendRedirect("login.html");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao cadastrar usuário.");
        }
    }
}