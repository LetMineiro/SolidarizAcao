package com.solidarizacao.dao;

import com.solidarizacao.model.SolicitarCaixa;
import java.sql.*;

public class SolicitarCaixaDAO {
    public void salvar(SolicitarCaixa s) throws Exception {
        Connection conn = Conexao.getConnection();
        String sql = "INSERT INTO solicitacao_caixa " +
                "(nome, cep, rua, numero, complemento, bairro, cidade, uf, rede, telefone, email, quantidade_caixas, itens_coleta, outro_produto, observacao, campanha, data_inicio, data_fim) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, s.getNome());
        ps.setString(2, s.getCep());
        ps.setString(3, s.getRua());
        ps.setInt(4, s.getNumero());
        ps.setString(5, s.getComplemento());
        ps.setString(6, s.getBairro());
        ps.setString(7, s.getCidade());
        ps.setString(8, s.getUf());
        ps.setString(9, s.getRede());
        ps.setString(10, s.getTelefone());
        ps.setString(11, s.getEmail());
        ps.setInt(12, s.getQuantidadeCaixas());
        ps.setString(13, s.getItens());
        ps.setString(14, s.getOutro());
        ps.setString(15, s.getObservacao());
        ps.setString(16, s.getCampanha());
        ps.setString(17, s.getDataInicio());
        ps.setString(18, s.getDataFim());
                
                ps.executeUpdate();
                conn.close();
    }
}