package com.solidarizacao.controller;

import com.solidarizacao.dao.DoadorDAO;
import com.solidarizacao.dao.DoacaoDAO;
import com.solidarizacao.model.Doador;
import com.solidarizacao.model.Doacao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet("/cadastrarDoacao")
public class DoacaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // 1. Preenche doador
            Doador doador = new Doador();
            doador.setNome(request.getParameter("nome"));
            doador.setCep(request.getParameter("cep"));
            doador.setRua(request.getParameter("rua"));
            doador.setNumero(request.getParameter("numero"));
            doador.setComplemento(request.getParameter("complemento"));
            doador.setBairro(request.getParameter("bairro"));
            doador.setCidade(request.getParameter("cidade"));
            doador.setEstado(request.getParameter("uf"));
            doador.setTelefone(request.getParameter("telefone"));
            doador.setEmail(request.getParameter("email"));
            doador.setMensagem(request.getParameter("mensagem"));
            
            int idDoador = new DoadorDAO().salvar(doador);
            
            // 2. Preenche doação
            Doacao doacao = new Doacao();
            doacao.setIdDoador(idDoador);
            doacao.setRoupas(parseIntSafe(request.getParameter("quant_Roupas")));
            doacao.setCalcados(parseIntSafe(request.getParameter("quant_Calçados")));
            doacao.setLivros(parseIntSafe(request.getParameter("quant_Livros")));
            doacao.setBrinquedos(parseIntSafe(request.getParameter("quant_Brinquedos")));
            doacao.setAlimentos(parseIntSafe(request.getParameter("quant_Alimentos")));
            doacao.setOutroItem(request.getParameter("outroItem"));
            doacao.setOutroQtd(parseIntSafe(request.getParameter("quant_outro")));
            String campanha = request.getParameter("campanhaSelecionada");
            if (campanha != null && !campanha.isBlank()) {
                doacao.setCampanha(campanha); 
            }
            
            new DoacaoDAO().salvar(doacao);
            
            // 3. Redireciona
            response.sendRedirect("obrigado.html");
            
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao cadastrar doação.");
        }
    }
    
    private int parseIntSafe(String val) {
        try {
            return (val != null && !val.isBlank()) ? Integer.parseInt(val) : 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
} 
