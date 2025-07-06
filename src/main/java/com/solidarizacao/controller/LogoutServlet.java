package com.solidarizacao.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Tenta recuperar a sessão existente
        HttpSession session = request.getSession(false);

        // Invalida a sessão se existir
        if (session != null) {
            session.invalidate();
        }

        // Retorna para login
        response.sendRedirect("login.html");
    }
}
