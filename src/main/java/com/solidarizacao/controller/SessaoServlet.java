/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidarizacao.controller;

/**
 *
 * @author Janylson
 */
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessao")
public class SessaoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        boolean logado = (session != null && session.getAttribute("email") != null);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"logado\": " + logado + "}");
    }
}
