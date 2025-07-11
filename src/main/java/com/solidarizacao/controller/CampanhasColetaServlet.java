/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.solidarizacao.controller;

import com.solidarizacao.dao.Conexao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Janylson
 */
@WebServlet("/api/pontos-coleta")
public class CampanhasColetaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        JSONArray jsonArray = new JSONArray();
        
        try (Connection conn = Conexao.getConnection()) {
            String sql = "SELECT campanha, cidade, bairro, rua, numero, itens_coleta, data_inicio, data_fim " +
                    "FROM solicitacao_caixa " +
                    "WHERE campanha IS NOT NULL AND campanha != ''";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("campanha", rs.getString("campanha"));
                obj.put("endereco", rs.getString("rua") + ", " + rs.getInt("numero") + " - " + rs.getString("bairro") + ", " + rs.getString("cidade"));
                obj.put("itens", rs.getString("itens_coleta"));
                
                // Adiciona data formatada dd/mm/aaaa
                Date inicio = rs.getDate("data_inicio");
                Date fim = rs.getDate("data_fim");
                String dataInicio = inicio != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(inicio) : "";
                String dataFim = fim != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(fim) : "";
                
                obj.put("data_inicio", dataInicio);
                obj.put("data_fim", dataFim);
                
                jsonArray.put(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        response.getWriter().print(jsonArray.toString());
    }
}
