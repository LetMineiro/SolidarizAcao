package com.solidarizacao.controller;

import com.solidarizacao.dao.SolicitacaoCaixaDAO;
import com.solidarizacao.model.SolicitacaoCaixa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/solicitarCaixa")
public class SolicitarCaixaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            SolicitacaoCaixa solicitacao = new SolicitacaoCaixa();
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
            solicitacao.setOutroProduto(request.getParameter("outro"));
            solicitacao.setObservacao(request.getParameter("mensagem"));

            String[] itensSelecionados = request.getParameterValues("itens");
            if (itensSelecionados != null) {
                solicitacao.setItensColeta(String.join(", ", itensSelecionados));
            } else {
                solicitacao.setItensColeta("");
            }

            new SolicitacaoCaixaDAO().salvar(solicitacao);

            response.sendRedirect("index.html");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao processar solicitação de caixa.");
        }
    }
}
