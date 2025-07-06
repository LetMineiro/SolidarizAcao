/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solidarizacao.dao;

import com.solidarizacao.model.Usuario;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Janylson
 */
public class UsuarioDAO {

    public boolean emailExiste(String email) throws Exception {
        Connection conn = Conexao.getConnection();
        String sql = "SELECT id FROM usuarios WHERE email = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        boolean existe = rs.next();
        conn.close();
        return existe;
    }

    public void cadastrar(Usuario u) throws Exception {
        Connection conn = Conexao.getConnection();
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenha());
        stmt.executeUpdate();
        conn.close();
    }
    
    public void atualizarPerfil(String email, String telefone, String cidade, String estado) throws Exception {
    Connection conn = Conexao.getConnection();
    String sql = "UPDATE usuarios SET telefone = ?, cidade = ?, estado = ? WHERE email = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, telefone);
    stmt.setString(2, cidade);
    stmt.setString(3, estado);
    stmt.setString(4, email);
    stmt.executeUpdate();
    stmt.close();
    conn.close();
}
    
    public Usuario buscarPorEmailESenha(String email, String senha) throws Exception {
    Connection conn = Conexao.getConnection();
    String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, email);
    stmt.setString(2, senha);
    ResultSet rs = stmt.executeQuery();

    Usuario u = null;
    if (rs.next()) {
        u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setNome(rs.getString("nome"));
        u.setEmail(rs.getString("email"));
        u.setTelefone(rs.getString("telefone"));
        u.setCidade(rs.getString("cidade"));
        u.setEstado(rs.getString("estado"));
    }

    conn.close();
    return u;
}
    
    public JSONObject buscarPerfilCompleto(String email) throws Exception {
    Connection conn = Conexao.getConnection();
    JSONObject json = new JSONObject();

    // 1. Dados do usuário
    PreparedStatement userStmt = conn.prepareStatement("SELECT * FROM usuarios WHERE email = ?");
    userStmt.setString(1, email);
    ResultSet rsUser = userStmt.executeQuery();
    if (rsUser.next()) {
        json.put("nome", rsUser.getString("nome"));
        json.put("email", rsUser.getString("email"));
        json.put("telefone", rsUser.getString("telefone"));
        json.put("cidade", rsUser.getString("cidade") + " - " + rsUser.getString("estado"));
    }

    // 2. Campanhas
    PreparedStatement campStmt = conn.prepareStatement("SELECT titulo FROM campanhas WHERE email_usuario = ?");
    campStmt.setString(1, email);
    ResultSet rsCamp = campStmt.executeQuery();
    JSONArray campanhas = new JSONArray();
    while (rsCamp.next()) {
        campanhas.put(rsCamp.getString("titulo"));
    }
    json.put("campanhas", campanhas);

    // 3. Doações
    String sqlDoacoes =
        "SELECT d.roupas, d.calcados, d.livros, d.brinquedos, d.alimentos, " +
        "d.outro_item, d.outro_qtd " +
        "FROM cadastrodoacao c " +
        "JOIN doacoes d ON d.id_doador = c.id " +
        "WHERE c.email = ?";

    PreparedStatement doaStmt = conn.prepareStatement(sqlDoacoes);
    doaStmt.setString(1, email);
    ResultSet rsDoa = doaStmt.executeQuery();

    JSONArray doacoes = new JSONArray();
    while (rsDoa.next()) {
        if (rsDoa.getInt("roupas") > 0)
            doacoes.put("Roupas - " + rsDoa.getInt("roupas"));
        if (rsDoa.getInt("calcados") > 0)
            doacoes.put("Calçados - " + rsDoa.getInt("calcados"));
        if (rsDoa.getInt("livros") > 0)
            doacoes.put("Livros - " + rsDoa.getInt("livros"));
        if (rsDoa.getInt("brinquedos") > 0)
            doacoes.put("Brinquedos - " + rsDoa.getInt("brinquedos"));
        if (rsDoa.getInt("alimentos") > 0)
            doacoes.put("Alimentos - " + rsDoa.getInt("alimentos"));
        if (rsDoa.getInt("outro_qtd") > 0)
            doacoes.put(rsDoa.getString("outro_item") + " - " + rsDoa.getInt("outro_qtd"));
    }

    json.put("doacoes", doacoes);

    conn.close();
    return json;
}

}
