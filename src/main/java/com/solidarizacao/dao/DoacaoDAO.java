/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.solidarizacao.dao;

import com.solidarizacao.model.Doacao;
import java.sql.*;

/**
 *
 * @author Janylson
 */
public class DoacaoDAO {
    public void salvar(Doacao d) throws Exception {
        Connection conn = Conexao.getConnection();
        String sql = "INSERT INTO doacoes (id_doador, roupas, calcados, livros, brinquedos, alimentos, outro_item, outro_qtd) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, d.getIdDoador());
        stmt.setInt(2, d.getRoupas());
        stmt.setInt(3, d.getCalcados());
        stmt.setInt(4, d.getLivros());
        stmt.setInt(5, d.getBrinquedos());
        stmt.setInt(6, d.getAlimentos());
        stmt.setString(7, d.getOutroItem() != null ? d.getOutroItem() : "");
        stmt.setInt(8, d.getOutroQtd());
        
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
