package com.solidarizacao.controller;

import com.solidarizacao.dao.UsuarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.json.JSONObject;

import java.io.*;

@WebServlet("/editarPerfil")
public class EditarPerfilServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("email") == null) {
      response.setStatus(401); // Não autorizado
      return;
    }

    String email = (String) session.getAttribute("email");

    // Lê JSON do corpo da requisição
    BufferedReader reader = request.getReader();
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      sb.append(line);
    }

    JSONObject json = new JSONObject(sb.toString());
    String telefone = json.optString("telefone");
    String cidade = json.optString("cidade");
    String estado = json.optString("estado");

    try {
      UsuarioDAO dao = new UsuarioDAO();
      dao.atualizarPerfil(email, telefone, cidade, estado);
      response.setStatus(200);
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus(500);
    }
  }
}
