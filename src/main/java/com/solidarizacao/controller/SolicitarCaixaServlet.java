package com.solidarizacao.controller;

import com.solidarizacao.dao.SolicitarCaixaDAO;
import com.solidarizacao.model.SolicitarCaixa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/solicitarCaixa")
public class SolicitarCaixaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        try {
            SolicitarCaixa solicitacao = new SolicitarCaixa();
            solicitacao.setNome(request.getParameter("nome"));
            solicitacao.setCep(request.getParameter("cep"));
            solicitacao.setRua(request.getParameter("rua"));
            solicitacao.setNumero(Integer.parseInt(request.getParameter("numero")));
            solicitacao.setComplemento(request.getParameter("complemento"));
            solicitacao.setBairro(request.getParameter("bairro"));
            solicitacao.setCidade(request.getParameter("cidade"));
            solicitacao.setUf(request.getParameter("uf"));
            solicitacao.setRede(request.getParameter("rede"));
            solicitacao.setTelefone(request.getParameter("telefone"));
            solicitacao.setEmail(request.getParameter("email"));
            solicitacao.setQuantidadeCaixas(Integer.parseInt(request.getParameter("caixa")));
            solicitacao.setOutro(request.getParameter("outro"));
            solicitacao.setObservacao(request.getParameter("mensagem"));
            
            // Itens de coleta
            String[] itensSelecionados = request.getParameterValues("itens");
            if (itensSelecionados != null) {
                solicitacao.setItens(String.join(", ", itensSelecionados));
            } else {
                solicitacao.setItens("");
            }
            
            // Campanha (escolhida ou manual)
            String campanha = request.getParameter("campanha");
            String campanhaManual = request.getParameter("campanhaManual");
            if (campanhaManual != null && !campanhaManual.isBlank()) {
                solicitacao.setCampanha(campanhaManual);
            } else {
                solicitacao.setCampanha(campanha != null ? campanha : "");
            }
            
            solicitacao.setDataInicio(request.getParameter("dataInicio"));
            solicitacao.setDataFim(request.getParameter("dataFim"));
            
            new SolicitarCaixaDAO().salvar(solicitacao);
            
            response.sendRedirect("obrigado.html");
            
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao processar solicitação de caixa.");
        }
    }
}
