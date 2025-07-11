package com.solidarizacao.dao;

import com.solidarizacao.model.Doador;
import java.sql.*;

/**
 *
 * @author Janylson
 */
public class DoadorDAO {
    public int salvar(Doador d) throws Exception {
        Connection conn = Conexao.getConnection();
        String sql = "INSERT INTO cadastrodoacao (nome, cep, rua, numero, complemento, bairro, cidade, estado, telefone, email, mensagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, d.getNome());
        stmt.setString(2, d.getCep());
        stmt.setString(3, d.getRua());
        stmt.setString(4, d.getNumero());
        stmt.setString(5, d.getComplemento());
        stmt.setString(6, d.getBairro());
        stmt.setString(7, d.getCidade());
        stmt.setString(8, d.getEstado());
        stmt.setString(9, d.getTelefone());
        stmt.setString(10, d.getEmail());
        stmt.setString(11, d.getMensagem());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int id = -1;
        if (rs.next()) id = rs.getInt(1);
        stmt.close();
        conn.close();
        return id;
    }
} 
