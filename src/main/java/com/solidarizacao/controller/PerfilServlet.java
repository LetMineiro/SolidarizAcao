package com.solidarizacao.controller;

import com.solidarizacao.dao.UsuarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("email") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String email = (String) session.getAttribute("email");

        try {
            UsuarioDAO dao = new UsuarioDAO();
            JSONObject perfil = dao.buscarPerfilCompleto(email);

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(perfil.toString());

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }
}
